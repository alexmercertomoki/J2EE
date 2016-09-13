/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuhao.com;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This servlet serves to process the get request passed by index.jsp
 * @author Fuhao
 */


public class BigCalc extends HttpServlet {
    CalculatorModel cm = null;
    
    @Override
    public void init() {
        cm = new CalculatorModel();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String num1 = request.getParameter("number1");
        String num2 = request.getParameter("number2");
        String operation = request.getParameter("operation");
        
        String nextView;
        String result = cm.calculate(num1, num2, operation);
        request.setAttribute("result", result);
        request.setAttribute("number1", num1);
        request.setAttribute("number2", num2);
        nextView = "index.jsp";
        
        // Transfer control over the the correct "view"
        RequestDispatcher view = request.getRequestDispatcher(nextView);
        view.forward(request, response);
    }

}
