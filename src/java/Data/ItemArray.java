/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author 794458
 */
public class ItemArray implements Serializable{
public ArrayList<String> finalArray;
public ItemArray()
{
    finalArray = new ArrayList<String>();
   
}

    /**
     * @return the finalArray
     */
   

    /**
     * @param finalArray the finalArray to set
     */
   
    public void addFinalArray(String item)
    {
        finalArray.add(item);
        
    }
    
    public void removeFinalArray(String item)
    {
        int counter=0;
        for(String oldItem: finalArray)
        {
            if(oldItem.equals(item))
            {
                finalArray.remove(counter);
                
                break;
            }
            else
            {
               counter++; 
            }
        }

    }

    public int getSize()
    {
        return finalArray.size();
    }
}
