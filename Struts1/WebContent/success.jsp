<%@ page language="java" pageEncoding="GB2312"%>
<html>
	<head>
		<title>�ɹ�ҳ��</title>
	</head>
	<body>
		<p align="center">
			��¼�ɹ������������û�����:${username} <!-- jsp biao qian .. �����Խ�username��  �Զ����浽  -->
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