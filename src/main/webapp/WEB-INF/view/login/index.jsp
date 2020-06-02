<%@page pageEncoding="UTF-8"%>
<html>
<head>
<title>Tutorial: Login</title>
</head>
<body>

<h1>Login</h1>

<html:errors/>
<s:form method="POST">
<label for="name">ユーザー名</label>
<html:text property="name"></html:text><br />
<label for="password">パスワード</label>
<html:text property="password"></html:text><br />
<p></p>
<input type="submit" name="login" value="ログイン"/>
</s:form>
</body>
</html>