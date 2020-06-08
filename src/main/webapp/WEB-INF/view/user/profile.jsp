<%@page pageEncoding="UTF-8"%>
<html>
<head>
<title>Tutorial: Profile</title>
<link rel="stylesheet" type="text/css" href="${f:url('/css/sa.css')}" />
</head>
<body>

<h1>Tutorial: Profile</h1>

<html:errors/>
<p></p>
<p>名前：${f:h(name)}</p><br />
<p>Email：${f:h(email)}</p><br />
<p></p>
<a href="menu">戻る</a>
<a href="logout">ログアウト</a>

</body>
</html>