<%@page pageEncoding="UTF-8"%>
<html>
<head>
<title>Tutorial: Profile</title>
<link rel="stylesheet" type="text/css" href="${f:url('/css/sa.css')}" />
</head>
<body>

<h1>Tutorial: Profile</h1>

<p>${f:h(message)}</p><br />
<p></p>
<table>
  <tr>
		<td>ID</td>
		<td>名前</td>
		<td>Email<td>
	</tr>
	<c:forEach var = "user" items = "${ userList }">
		<tr>
			<td>${f:h(user.id)}</td>
			<td>${f:h(user.name)}</td>
			<td>${f:h(user.email)}<td>
			<td><a href="edit/${f:h(user.id)}">編集</a></td>
			<td><a href="delete/${f:h(user.id)}">削除</a></td>
		</tr>
	</c:forEach>
</table>
<p></p>
<a href="/sa-struts-tutorial/user/menu">戻る</a>
<a href="logout">ログアウト</a>

</body>
</html>