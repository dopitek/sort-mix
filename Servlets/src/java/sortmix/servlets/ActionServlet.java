package sortmix.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;
import javax.servlet.*;
import javax.servlet.http.*;
import sortmix.model.*;
import sortmix.common.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dariu
 */
public class ActionServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param req servlet request
     * @param resp servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/plain; charset=ISO-8859-2");
        PrintWriter out = resp.getWriter();

        out.println("Passed parameters:");

        String text = req.getParameter("inputText");
        SortingMode sortingMode = SortingMode.valueOf(req.getParameter("sortingMode"));

        TextSorterModel model = new TextSorterModel();
        model.setText(text);
        model.setSortingMode(sortingMode);

        out.println(text);
        out.println(sortingMode);
        
        try {
            String result = model.process();
            out.println(result);
            
            // zapis do bazy
            
        } catch (NonSortingModeException | NoTextInputException ex) {
            out.println("wrong");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param req servlet request
     * @param resp servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}
