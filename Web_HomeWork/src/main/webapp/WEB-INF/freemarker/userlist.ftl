<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>�û���Ϣ</title>
	</head>
	<body>
		<table border="2">
			<tbody>
				<#list userList as user>
					<tr>
						<td>${user.getUserId()?c}</td>
						<td>${user.getUserName()}</td>
					</tr>
				</#list>
			</tbody>
		</table>
	</body>
</html>