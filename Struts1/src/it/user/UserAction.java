package it.user;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import it.domain.User;

public class UserAction extends ActionSupport{
	
		private static final long serialVersionUID = 5922553179222906288L;
		
		private String username;
		private String password;

		private String username01;
		private String password01;
		
		private User user;
		
		
//		private String[] interest;
		

		@Override
		public String execute() throws Exception {
			
			if (username.equals("test") && password.equals("12345")) {
				return "success";
			} else {
				return "error";
			}
		}

		public String loginuser01(){

			System.out.println(username01);
			System.out.println(password01);
			
			return "success";
		}

		public String loginuser02(){

			System.out.println(user.getUsername());	
			System.out.println(user.getPassword());	
			System.out.println(user.getCityId());
			System.out.println(user.getUserInterest());
			System.out.println("------------------");
			
//			if(user.getUserInterest()!=null){
//				for(String str : user.getUserInterest()){
//					if(str.equals("1"))
//					System.out.println("soccer");
//					if(str.equals("2"))
//						System.out.println("basket");
//					if(str.equals("3"))
//						System.out.println("volley");
//					if(str.equals("4"))
//						System.out.println("ping");
//				}
//			}
			
			if(user.getUserInterest()!=null){
				int len=user.getUserInterest().length;
				String[] temp=new String[len];
				for(int i=0; i<len;i++){
					
					switch(user.getUserInterest()[i]) {
					case "1":
						temp[i]="Soccer";
						break;
					case "2":
						temp[i]="Basket";
						break;
					case "3":
						temp[i]="Volley";
						break;
					case "4":
						temp[i]="Ping";
						break;
					}
					
				}
				user.setUserInterest(temp);
			}
			
			
			return Action.SUCCESS; 
		}
		
		
		public String getPassword() {
			return password;
		}



		public void setPassword(String password) {
			this.password = password;
		}



		public String getUsername() {
			return username;
		}



		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword01() {
			return password01;
		}

		public void setPassword01(String password01) {
			this.password01 = password01;
		}

		public String getUsername01() {
			return username01;
		}

		public void setUsername01(String username01) {
			this.username01 = username01;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

//		public String[] getInterest() {
//			return interest;
//		}
//
//		public void setInterest(String[] interest) {
//			this.interest = interest;
//		}
}
