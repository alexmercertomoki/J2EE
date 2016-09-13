<jsp:include page="template-top.jsp" />

<p style="font-size:medium">
	Add a new picture:
</p>

<jsp:include page="error-list.jsp" />

<p>
	<form method="post" action="upload.do" enctype="multipart/form-data">
		<table>
			<tr>
				<td>File: </td>
				<td colspan="2"><input type="file" name="file" value="${filename}"/></td>
			</tr>
			<tr>
				<td>Caption: </td>
				<td><input type="text" name="caption" value="${caption}"/></td>
				<td>(optional)</td>
			</tr>
			<tr>
				<td colspan="3" align="center">
					<input type="submit" name="button" value="Upload File"/>
				</td>
			</tr>
		</table>
	</form>
</p>
<hr/>
<%@ page import="databeans.Photo" %>
<p>
	<table>
<%
        Photo[] photos = (Photo[])request.getAttribute("photoList");
        for (int i=0; i<photos.length; i++) {
%>
        <tr>
            <td valign="top">
                <form method="POST" action="remove.do">
                    <input type="hidden" name="id" value="<%=photos[i].getId()%>"/>
                    <input type="submit" value="X"/>
                </form>
            </td>
            <td valign="top">
                <form method="POST" action="move-up.do">
                    <input type="hidden" name="id" value="<%=photos[i].getId()%>" />
                    <input type="submit" value="&uarr;" <%= i==0 ? "disabled" : "" %> />
                </form>
            </td>
            <td valign="top">
                <form method="POST" action="move-down.do">
                    <input type="hidden" name="id" value="<%=photos[i].getId()%>"/>
                    <input type="submit" value="&darr;" <%= i==photos.length-1 ? "disabled" : "" %> />
                </form>
            </td>
            <td valign="top"><a href="view.do?id=<%=photos[i].getId()%>"><%=photos[i].getCaption()%></a></td>
        </tr>
<%
		}
%>
	</table>
</p>

<jsp:include page="template-bottom.jsp" />
