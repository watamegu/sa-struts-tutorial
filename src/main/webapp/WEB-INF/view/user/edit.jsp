<%@page pageEncoding="UTF-8"%>
<html>
<head>
<title>Tutorial: Login</title>
<link rel="stylesheet" type="text/css" href="${f:url('/css/sa.css')}" />
</head>
<body>

<h1>Edit</h1>

<p>${f:h(message)}</p><br />
<s:form method="POST" action="/user/update/${f:h(strId)}/">
<label for="name">ユーザー名</label>
<html:text property="name" value="${f:h(name)}"></html:text><br />
<label for="name">Email</label>
<html:text property="email" value="${f:h(email)}"></html:text><br />
<label for="password">パスワード</label>
<input type="password" name="password" value="${f:h(password)}"><br />
<input type="submit" name="update" value="更新"/>
</s:form>
<p></p>
<a href="/sa-struts-tutorial/user/menu">戻る</a>
</body>
</html>