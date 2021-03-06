package sortmix.servlets;

import sortmix.common.CookieHandler;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sortmix.dao.Data;

/**
 * Servlet used to show results from database
 * @author Dariusz Opitek
 * @version 1.3
 */
public class ReadServlet extends BaseServlet {

    /**
     * Calls base init method
     * @throws ServletException throws exception when base init fails
     */
    @Override
    public void init() throws ServletException {
        super.init();
    }

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

        response.setContentType("text/plain; charset=ISO-8859-2");
        PrintWriter out = response.getWriter();

        CookieHandler cookie = new CookieHandler();
        int calcCount = cookie.retrieveCalcCount(request);

        out.println("Your total calculations: " + calcCount);

        try {
            ArrayList<Data> list = repository.selectData();
            out.printf("%s\t%s\t%s\t%s\n", "Wejscie", "Wynik", "Metoda_Sortowania", "Data");
            out.println("-----------------------------------");
            for (Data data : list) {
                out.printf("\"%s\"\t", data.getInitText());
                out.printf("\"%s\"\t", data.getResultText());
                out.printf("%s\t", data.getSortingMode());
                out.printf("%s\n", data.getDate());
            }
            out.println("-----------------------------------");
        } catch (SQLException sqle) {
            System.err.println("SQL exception: " + sqle.getMessage());
        }
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
        processRequest(request, response);
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
        processRequest(request, response);
    }

}
