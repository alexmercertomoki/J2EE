/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package hf.pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class LAB7Servlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try {
             PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
             
            // define and get the integers and operator
            String x=request.getParameter("bigint1");
            String y=request.getParameter("bigint2");
            BigInteger xx=new BigInteger(x);
            BigInteger yy=new BigInteger(y);
            BigInteger result=new BigInteger(y);
            String operator =request.getParameter("operator");
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Calculation : </title>");            
            out.println("</head>");
            out.println("<body>");
           try{
            //select  operators and operates   and then print to the browser
            switch (operator) {
            case "Addition": 
                result=xx.add(yy);
                out.println("<h1>Addition Calculation result: " + result.toString() + "</h1>");  
                     break;
            case "Multiplication":  
                result=xx.multiply(yy);
                out.println("<h1>Multiplication Calculation result: " + result.toString() + "</h1>");  
                     break;
            case "Prime":  
                result=xx.gcd(yy);
                if(result.equals(new BigInteger("1"))){
                   out.println("<h1>Prime Calculation result: " + "They are relatively prime" + "</h1>");  
                }
                else{
                   out.println("<h1>Prime Calculation result:" + "They are NOT relatively prime" + "</h1>");
                }  
                    break;
            case "Modulo":
                result=xx.mod(yy);
                out.println("<h1>Modulo Calculation result: " + result.toString() + "</h1>");
                    break;
            case "Inversemodular": 
                result=xx.modInverse(yy);
                out.println("<h1>Inversemodular Calculation result: " + result.toString() + "</h1>");
                    break;
            case "Power":  
                result=xx.pow(Integer.parseInt(y)); //convert to int 
                out.println("<h1>Power Calculation result: " + result.toString() + "</h1>");
                    break;
            default:  
                out.println("<h1>you should insert right calculations </h1>");
                    break;
             }
            }
           //print error message 
           catch(Exception e){
               out.print( "<h1>Error : "+ e.getMessage()+"<h1>");
           }
           
            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception e){
             // if wrong input is caught print the message to the page 
             PrintWriter out1=response.getWriter();
             out1.println("<h1>Error input : Please input integer and right operators..</h1>");
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

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
