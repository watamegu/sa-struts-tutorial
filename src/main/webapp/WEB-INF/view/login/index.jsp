<%@page pageEncoding="UTF-8"%>
<html>
<head>
<title>Tutorial: Login</title>
<link rel="stylesheet" type="text/css" href="${f:url('/css/sa.css')}" />
</head>
<body>

<h1>Login</h1>

<html:messages id="message" message="true">
<p>${message}</p>
</html:messages>
<s:form method="POST">
<label for="name">ユーザー名</label>
<html:text property="name" value=""></html:text><br />
<label for="password">パスワード</label>
<input type="password" name="password" value=""><br />
<p></p>
<input type="submit" name="login" value="ログイン"/>
</s:form>
<a href="../user/new">新規登録</a>
</body>
</html>