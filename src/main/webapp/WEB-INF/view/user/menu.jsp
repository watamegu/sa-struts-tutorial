<%@page pageEncoding="UTF-8"%>
<html>
<head>
<title>Tutorial: Menu</title>
<link rel="stylesheet" type="text/css" href="${f:url('/css/sa.css')}" />
</head>
<body>

<h1>Tutorial: Menu</h1>
<p>${f:h(message)}</p><br />
<a href="profile">プロフィール表示</a><br />
<a href="show">ユーザー一覧</a><br />
<a href="new">ユーザー作成</a><br />
<a href="logout">ログアウト</a>

</body>
</html>