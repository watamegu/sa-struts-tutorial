<%@page pageEncoding="UTF-8"%>
<html>
<head>
<title>Tutorial: Profile</title>
<link rel="stylesheet" type="text/css" href="${f:url('/css/sa.css')}" />
</head>
<body>

<h1>ユーザー管理</h1>

<html:messages id="message" message="true">
<p>${message}</p>
</html:messages>
<p></p>
<table border="1">
  <tr>
		<td>ID</td>
		<td>ユーザー名</td>
		<td>Email</td>
		<td>編集or削除</td>
	</tr>
	<c:forEach var = "user" items = "${ userList }">
		<tr>
			<td>${f:h(user.id)}</td>
			<td>${f:h(user.name)}</td>
			<td>${f:h(user.email)}</td>
			<td>
					<a href="edit/${f:h(user.id)}">編集</a>
					<a href="delete/${f:h(user.id)}">削除</a>
			</td>
		</tr>
	</c:forEach>
</table>
<p></p>
<a href="../post/list">戻る</a>
</body>
</html>