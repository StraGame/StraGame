

<!DOCTYPE html>
<html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,db.User"%>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="ProductStyle.css" rel="stylesheet" type="text/css">
	<title>Storage DS/BF</title>
</head>

<body>
	<h2>Products</h2>
	<a href="DbServlet">List</a>
	<table border="1">
		<tr>
			<th>Code </th>
			<th>Name </th>
			<th>Description </th>
			<th>Action</th>
		</tr>
		<%
			if (users != null && users.size() != 0) {
				Iterator<?> it = users.iterator();
				while (it.hasNext()) {
					User user = (User) it.next();
		%>
		<tr>
			<td><%=user.getNickname()%></td>
			<td><%=user.getNome()%></td>
			<td><%=user.getCognome()%></td>
			<td><%=user.getRuolo()%></td>
		</tr>
		<%
				}
			} else {
		%>
		<tr>
			<td colspan="6">No products available</td>
		</tr>
		<%
			}
		%>
	</table>
	

</body>
</html>