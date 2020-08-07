/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imam.sp_checklist.widget;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Imam-pc
 */
public class isValidTime {
    
    public boolean isValidTimeVal(String time){
        
        // Regex to check valid time in 24-hour format. 
        String regex = "([01]?[0-9]|2[0-3]):[0-5][0-9]"; 
  
        // Compile the ReGex 
        Pattern p = Pattern.compile(regex); 
  
        // If the time is empty 
        // return false 
        if (time == null) { 
            return false; 
        } 
  
        // Pattern class contains matcher() method 
        // to find matching between given time 
        // and regular expression. 
        Matcher m = p.matcher(time); 
  
        // Return if the time 
        // matched the ReGex 
        return m.matches(); 
    }
    
    
}
