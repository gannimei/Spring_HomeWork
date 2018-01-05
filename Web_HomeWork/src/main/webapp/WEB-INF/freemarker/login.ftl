<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>登录</title>
	</head>
	<body>
		<#if (error)??>
			<span style="color:red">${error}</span>
		</#if>
		<form action="login" method="post">
			<p>
				<label for="userName">
					用户名：<input type="text" name="userName" id="userName" />
				</label>
			</p>
			<p>
				<label for="password">
					密码：<input type="password" name="password" id="password" />
				</label>
			</p>
			<input type="submit" value="提交" />
		</form>
	</body>
</html>