package edu.cmu.bilei.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.cmu.bilei.model.FavoriteDAO;
import edu.cmu.bilei.model.UserDAO;

/**
 * Servlet The main controller
 */


public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;	
	
	// all the actions
	LoginAction la;
	AddFavAction afa; 
	JumpCountAction jca;
	LogoutAction loa;
	RegisterAction ra;
	ViewAllAction vaa;
	ViewAllUserFavAction vaufa;
	DeleteAction da; 
    ManageAction ma;
    PasswordChangeAction pca;
	
	public void init() throws ServletException{
		// create table 
		UserDAO ud = new UserDAO();
		FavoriteDAO fdao = new FavoriteDAO();
		ud.createUserTable();
		fdao.createFavouriteTable();
		// init the actions 
		la = new LoginAction();
		afa = new AddFavAction();
		jca = new JumpCountAction();
		loa = new LogoutAction();
		ra = new RegisterAction();
		vaa = new ViewAllAction();
		vaufa = new ViewAllUserFavAction();
		da = new DeleteAction();
		ma = new ManageAction();
		pca = new PasswordChangeAction();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// the nextpage we need to dispatch to 
		String nextpage = "";
		
		// handle login.do 
		if(request.getServletPath().equals("/login.do")){
				 nextpage = la.performAction(request);
		}
		
		// adding favourites 
		if(request.getServletPath().equals("/add.do")){
			    nextpage = afa.performAction(request);
		}
		// count plus one and then go to the site 
		if(request.getServletPath().equals("/jumpcount.do")){
			jca.performAction(request);
			
			response.sendRedirect("http://" + request.getParameter("url"));
			
			return; 
			
		}
		// logout set session to empty 
		if(request.getServletPath().equals("/logout.do")){
		    nextpage = loa.performAction(request);
		}
		//register 
		if(request.getServletPath().equals("/register.do")){
		    nextpage = ra.performAction(request);
		}
		// view all the user's favourites the page 
		if(request.getServletPath().equals("/viewall.do")){
			HttpSession hs = request.getSession();
			nextpage = vaa.performAction(hs);
		}
		// view all users favourites items 
		if(request.getServletPath().equals("/alluserfavourites.do")){ 
			nextpage = vaufa.performAction(request);
		}
		// delete the item  with id 
		if(request.getServletPath().equals("/delete.do")){ 
			nextpage = da.performAction(request);
		}
		//manage account 
		if(request.getServletPath().equals("/manage.do")){ 
			nextpage = ma.performAction(request);
		}
		// change password 
		if(request.getServletPath().equals("/passchange.do")){ 
			nextpage = pca.performAction(request);
		}
		
		
		// go to the page 
		RequestDispatcher dispatcher = request
				.getRequestDispatcher(nextpage);
		dispatcher.forward(request, response);
		return ;
		
	}

}
