<%-- 
    Document   : shoppingList
    Created on : 7-Feb-2020, 8:41:36 AM
    Author     : 794458 -787900
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <h2>Hello ${loginName}</h2>
        <a href="ShoppingList?action=logout">Logout</a>
        <h2>List</h2>
        <form action="" method="POST">
        <table>
                    <tr><td>
                            Add <input type="text" name="itemName">
                </td></tr>
                            <tr><td>
                                    <input type="hidden" value="add" name="action">
                                    <input type="submit" value="Add">
                        </td></tr>
                            <tr>
                                ${missing}
                            </tr>
        </table>
        </form>
    <form action="" method="post"> 
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:forEach var="item" items="${itemList}" >
       
        <table>
            
            <tr>
                <td> 
                    
                    <input type="hidden" value="${item}" >
                    
                    <input type="radio" value="${item}" name="deleteItem">  
                    
                    ${item}
                    
                </td>
             
      </tr>
      
   </table>
    
</c:forEach>
    
    
<c:if test="${itemList.size()>0}">
    
    <input type="hidden" name="action" value="delete">
          
    <input type="submit" value="Delete Item"> 
    </form>
 </c:if>
   
            
    
    </body>
</html>
