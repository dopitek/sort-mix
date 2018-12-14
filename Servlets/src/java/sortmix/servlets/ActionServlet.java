package sortmix.servlets;

import sortmix.common.CookieHandler;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.servlet.*;
import javax.servlet.http.*;
import sortmix.model.*;
import sortmix.common.*;
import sortmix.dao.Data;

/**
 * Servlet used to calculate input data
 * @author Dariusz Opitek
 * @version 1.3
 */
public class ActionServlet extends BaseServlet {

    /**
     * Model used to process text
     */
    private TextSorterModel model;

    /**
     * Creates TextSorterModel instance and calls base init method
     * @throws ServletException throws exception when base init fails
     */
    @Override
    public void init() throws ServletException {
        ServletConfig config = getServletConfig();
        ServletContext context = config.getServletContext();

        model = (TextSorterModel) context.getAttribute("model");
        if (model == null)
        {
            model = new TextSorterModel();
            context.setAttribute("model", model);
        }
        
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

        out.println("Passed parameters:");

        String text = request.getParameter("inputText");
        String sortingModeString = request.getParameter("sortingMode");
        SortingMode sortingMode = SortingMode.valueOf(sortingModeString);

        model.setText(text);
        model.setSortingMode(sortingMode);

        out.println(text);
        out.println(sortingMode);
        
        try {
            String result = model.process();
            out.println(result);
            
            Data data = new Data();
            data.setInitText(text);            
            data.setResultText(result);
            data.setSortingMode(sortingModeString);
            data.setDate(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new java.util.Date()));
            repository.insertData(data);
            
            CookieHandler cookie = new CookieHandler();
            int calcCount = cookie.retrieveCalcCount(request);
            cookie.writeCalcCount(response, calcCount+1);
            
        } catch (NonSortingModeException | NoTextInputException ex) {
            out.println("Model exception: " + ex.getMessage());
        } catch (SQLException sqle) {
            out.println("SQL exception: " + sqle.getMessage());
        }
    }

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
