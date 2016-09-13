<%@ page language="java" pageEncoding="GB2312"%>
<html>
	<head>
		<title>成功页面</title>
	</head>
	<body>
		<p align="center">
			登录成功！！！您的用户名是:${username} <!-- jsp biao qian .. 找属性叫username的  自动保存到  -->
			<br />
			${user.username}&nbsp;
			${user.password}&nbsp;
			${user.cityId}&nbsp;
			
			<%
			    String[] a =(String[])request.getAttribute("user.userInterest");
				
				for(int i=0; i<a.length;i++){
					out.print(a[i]+"  ");
				} 
			%>
			
		</p>
	</body>
</html>