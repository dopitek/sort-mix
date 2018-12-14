package sortmix.common;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class for writing to and reading from cookies number of calculations
 * @author Dariusz Opitek
 * @version 1.3
 */
public class CookieHandler {

    /**
     * Gets actual number of calculations
     * @param request request from which cookies are red
     * @return returns actual number of calculations
     */
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
    
    /**
     * Writes actual calculations number to cookie
     * @param response response in which cookie are send
     * @param calcCount calculations number to be saved
     */
    public void writeCalcCount(HttpServletResponse response, int calcCount)
    {
        Cookie cookie = new Cookie("calcCount", Integer.toString(calcCount));
        response.addCookie(cookie);
    }
}
