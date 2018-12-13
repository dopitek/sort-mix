package sortmix.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import javax.servlet.*;
import javax.servlet.http.*;
import sortmix.model.*;
import sortmix.common.*;
import sortmix.dao.Data;
import sortmix.dao.DbContext;
import sortmix.dao.Repository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dariu
 */
public class ActionServlet extends BaseServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param req servlet request
     * @param resp servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private TextSorterModel model;

    @Override
    public void init() throws ServletException {
        ServletConfig config = getServletConfig();
        ServletContext context = config.getServletContext();

        Connection connection = (Connection) context.getAttribute("dbConnection");
        if (connection == null) {
            connection = new DbContext().connect();
            context.setAttribute("dbConnection", connection);
            repository = new Repository(connection);
            try {
                repository.createTable();
            } catch (SQLException ex) {
                System.err.println("SQL exception: " + ex.getMessage());
            }
        } else {
            repository = new Repository(connection);
        }
        
        super.init();
        //ServletConfig config = getServletConfig();
        //ServletContext context = config.getServletContext();

        model = (TextSorterModel) context.getAttribute("model");
        if (model == null)
        {
            model = new TextSorterModel();
            context.setAttribute("model", model);
        }
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
