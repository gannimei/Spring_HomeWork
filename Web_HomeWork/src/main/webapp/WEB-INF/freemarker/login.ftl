<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>��¼</title>
	</head>
	<body>
		<#if (error)??>
			<span style="color:red">${error}</span>
		</#if>
		<form action="login" method="post">
			<p>
				<label for="userName">
					�û�����<input type="text" name="userName" id="userName" />
				</label>
			</p>
			<p>
				<label for="password">
					���룺<input type="password" name="password" id="password" />
				</label>
			</p>
			<input type="submit" value="�ύ" />
		</form>
	</body>
</html>