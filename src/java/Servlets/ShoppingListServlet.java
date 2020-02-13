/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Data.ItemArray;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 794458
 */
public class ShoppingListServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ShoppingListServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ShoppingListServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
      HttpSession session = request.getSession();
      String action = request.getParameter("action");
      String list = (String)session.getAttribute("LIST");
      if(action == null)
      {
        
        if(list==null)
          {
          getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
          }
          else
          {
              //session.removeAttribute("LIST");
              request.setAttribute("loginName", session.getAttribute("username"));
              getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
          }  
      }
      else
      { //getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
          
          session.invalidate();
          response.sendRedirect("ShoppingList");
      }     
      
        
    
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        ServletContext sc = getServletContext();
        String url = "/WEB-INF/shoppingList.jsp";
        String register =request.getParameter("action");
        if(register.equals("register"))
        {
            String name = request.getParameter("usernameLogin");
            if(name.equals("") || name==null)
            {
                request.setAttribute("message", "Please enter username");
                url = "/WEB-INF/register.jsp";
                sc.getRequestDispatcher(url).forward(request, response);
                
            } 
            else 
            {
                HttpSession session = request.getSession();
                session.setAttribute("username", name);
                request.setAttribute("loginName", session.getAttribute("username"));
                session.setAttribute("LIST", "Has list");
                response.sendRedirect("ShoppingList");
            }
        }
        else
            if(register.equals("add"))
        {
            String itemToBeAdded = request.getParameter("itemName");
            if(!itemToBeAdded.equals("") && itemToBeAdded!=null)
            {
            HttpSession session = request.getSession();
            ArrayList<String> item = (ArrayList) session.getAttribute("itemList");
            if(item == null)
            {
               item = new ArrayList<>();
            }
            
            item.add(itemToBeAdded);
            session.setAttribute("LIST", "Has list");
            session.setAttribute("itemList", item);
            
            response.sendRedirect("ShoppingList");
            
            }
            else
            {
                request.setAttribute("missing", "Please enter an item");
                sc.getRequestDispatcher(url).forward(request, response);
            }
    }
        else
                if(register.equals("delete"))
                {
                    String name = request.getParameter("deleteItem");
                    if(name!=null)
                {
                    HttpSession session = request.getSession();
                    ArrayList<String> list =(ArrayList) session.getAttribute("itemList");
                    int counter=0;
                   for(String oldItem: list)
                   {
                     if(oldItem.equals(name))
            {
                     list.remove(counter);
                
                break;
            }
            else
            {
               counter++; 
            }
        }
                    session.setAttribute("itemList", list);
                    sc.getRequestDispatcher(url).forward(request, response);
                }
                    else
                    {
                        sc.getRequestDispatcher(url).forward(request, response);
                    }
                }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
