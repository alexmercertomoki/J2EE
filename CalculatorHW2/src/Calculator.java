import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Bilei
 * This is a servlet calculator
 * 
 */
@WebServlet(urlPatterns = {"/calc"})
public class Calculator extends HttpServlet{
	/**
	 * @req HTTP request has the x y value and operation 
	 * @resp HTTP response writes back to the client 
	 * 
	 * This do get Do the calculation 
	 */
	private static final long serialVersionUID = 1L;
	
	double x;
	double y;
	StringBuilder finalResult;
	int errorFlag;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();	
		finalResult = new StringBuilder();
		errorFlag = 0;
		String strx = req.getParameter("x");
		String stry = req.getParameter("y");
		x = initializeNumber(strx);
		y = initializeNumber(stry);
		
		if(errorFlag == 1){
			out.println(finalResult);
			return;
		}
		
		double result = 0.00; 
		
		String op = req.getParameter("operation");
		
		
		switch(op){
		case "+":
			result = x + y; 
			break;
		case "-":
			result = x - y;
			break;
		case "*":
			result = x * y;
			break;
		case "/":
			if(y == 0){
			   finalResult.append("Cannot divide by 0");
			   out.println(finalResult);
			   return;
			}
			result = x / y;
			break; 
		}
		
		out.println("x" + op + "y" + "=" + result);
	
	}
	/**
	 * @strNum Strings to parse to double
	 * 
	 * This way gets to know which one is wrong
	 */
	
	private double initializeNumber(String strNum){
		double number = 0.00;
		try{
			 number = Double.parseDouble(strNum);
			
		} catch(NumberFormatException e){
			finalResult.append(strNum + " is not a number, please insert a number <br>");
			errorFlag = 1; 
		}
		return number;
	}
	

}
