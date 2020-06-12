<%@page pageEncoding="UTF-8"%>
<html>
<head>
<title>Tutorial: Login</title>
<link rel="stylesheet" type="text/css" href="${f:url('/css/sa.css')}" />
</head>
<body>

<h1>新規登録</h1>

<html:errors/>
<s:form method="POST">
<label for="name">ユーザー名</label>
<html:text property="name" value=""></html:text><br />
<label for="name">Email</label>
<html:text property="email" value=""></html:text><br />
<label for="password">パスワード</label>
<input type="password" name="password" value=""><br />
<input type="submit" name="create" value="作成"/>
</s:form>
<p></p>
<a href="../login">キャンセル</a>
</body>
</html>