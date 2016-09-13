<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>登录页面</title>
	</head>
	<body>
		<center>
			<s:form action="loginUser" method="post">
				<s:textfield name="username" label="用户名" />
				<s:password name="password" label="密码" />
				<s:submit value="确定" />
				<s:reset value="重置" />
			</s:form>
		</center>
		
		
		
		<br />
		自定义方法:<br />
		<form action="loginUser01.action" method="post">
			<input type="text" name="username01" value="" />
			<br />
			<input type="password" name="password01" value="" />
			<br />
			<input type="submit" name="submit" value="提交" />
			<br />
		</form>
		
		
		对象方式传递数据:<br />
		<form action="loginUser02.action" method="post">
			<input type="text" name="user.username" value="" />
			<br />
			<input type="password" name="user.password" value="" />
			<br />
			<select name="user.cityId">
				<option value="1">北京</option>
				<option value="2">上海</option>
				<option value="3">广州</option>
				<option value="4">深圳</option>
			</select>
			
			
			<br />
			
			<input type="checkbox" name="user.userInterest" value="1" />足球
			<input type="checkbox" name="user.userInterest" value="2" />篮球
			<input type="checkbox" name="user.userInterest" value="3" />排球
			<input type="checkbox" name="user.userInterest" value="4" />乒乓球
			<br />
			<input type="submit" name="submit" value="提交" />
			<br />
		
		</form>
	</body>
</html>