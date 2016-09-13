<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form name="search" action="search.do" method="get">
	<table>
		<tr>
			<td>
				<table border="1" style="border-color: aqua; border-style: solid;"  cellpadding="10">
					<c:if test='${!(empty user)}'>
						<tr>
							<td colspan="2" align="center">
								${numEntries} address book entries.
								&nbsp;&nbsp;&nbsp;&nbsp;
								Logged in as user <b>${user.userName}</b>.
								&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="logout.do">Logout</a> 
								&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="manage-users.do">Manage Users</a>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <a href="dump-data.do">Backup Data</a>
							</td>
						</tr>
					</c:if>
					<tr>
						<td align="left">
							<table>
								<tr>
									<td>
										<font size="4">Last Name:</font>
									</td>
									<td>
										<input id="last" type="text" name="last"
											   maxLength="100" size="33"
											   onkeyup="searchSuggest(this);"
											   onblur="lostFocus(this);"
											   autocomplete="off"
											   value="${last}"
										/>
										<div id="search_suggest_last" class="search_suggest"></div>
									</td>
									<td>
										&nbsp;&nbsp;
										<font size="4">First Name:</font>
									</td>
									<td>
										<input id="first" type="text" name="first"
											   maxLength="100" size="33"
											   onkeyup="searchSuggest(this);"
											   onblur="lostFocus(this);"
											   autocomplete="off"
											   value="${first}"
										/>
										<div id="search_suggest_first" class="search_suggest"></div>
									</td>
								</tr>
							</table>
						</td>
						<td rowspan="2">
							<font size="4">
							<ul style="margin-top:0px; margin-bottom:0px">
								<li><a href="advanced-search.do">Advanced Search</a></li>
								<c:if test="${empty user}">
									<li><a href="login.do">Login</a></li>
								</c:if>
								<li><a href="add-entry.do">New Entry</a></li>
							</ul>
							</font>
						</td>
					</tr>
					<tr>
						<td align="center">
							<font size="4">Last Names starting with: 
								<a href="search.do?last=A">A</a>
								<a href="search.do?last=B">B</a>
								<a href="search.do?last=C">C</a>
								<a href="search.do?last=D">D</a>
								<a href="search.do?last=E">E</a>
								<a href="search.do?last=F">F</a>
								<a href="search.do?last=G">G</a>
								<a href="search.do?last=H">H</a>
								<a href="search.do?last=I">I</a>
								<a href="search.do?last=J">J</a>
								<a href="search.do?last=K">K</a>
								<a href="search.do?last=L">L</a>
								<a href="search.do?last=M">M</a>
								<a href="search.do?last=N">N</a>
								<a href="search.do?last=O">O</a>
								<a href="search.do?last=P">P</a>
								<a href="search.do?last=Q">Q</a>
								<a href="search.do?last=R">R</a>
								<a href="search.do?last=S">S</a>
								<a href="search.do?last=T">T</a>
								<a href="search.do?last=U">U</a>
								<a href="search.do?last=V">V</a>
								<a href="search.do?last=W">W</a>
								<a href="search.do?last=X">X</a>
								<a href="search.do?last=Y">Y</a>
								<a href="search.do?last=Z">Z</a>
							</font>
						</td>
					</tr>
				</table>
			</td>
			<!-- We need a div in which to place an invisible submit button when the user is allowed to hit enter to submit a form request -->
			<td>
				<div id="submitDiv" style="visibility:hidden">
					<input type="submit" name="button" value="."/>
				</div>
			</td>
		</tr>
	</table>
</form>
