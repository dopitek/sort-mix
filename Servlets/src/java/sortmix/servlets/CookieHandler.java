/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortmix.servlets;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dariu
 */
public class CookieHandler {
    public int retrieveCalcCount(HttpServletRequest request)
    {
        Cookie[] cookies = request.getCookies();
        int calcCount = 0;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("calcCount")) {
                    calcCount = Integer.parseInt(cookie.getValue());
                    break;
                }
            }
        }
        
        return calcCount;
    }
    
    public void writeCalcCount(HttpServletResponse response, int calcCount)
    {
        Cookie cookie = new Cookie("calcCount", Integer.toString(calcCount));
        response.addCookie(cookie);
    }
    
    
}
