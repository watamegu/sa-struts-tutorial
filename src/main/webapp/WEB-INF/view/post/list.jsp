<%@page pageEncoding="UTF-8"%>
<html>
<head>
<title>Tutorial:メモ一覧</title>
<link rel="stylesheet" type="text/css" href="${f:url('/css/sa.css')}" />
</head>
<body>

<h1>メモ一覧</h1>
<p>${f:h(message)}</p>
<table>
  <tr>
		<td>ID</td>
		<td>タイトル</td>
	</tr>
	<c:forEach var = "post" items = "${ postList }">
		<tr>
			<td>${f:h(post.id)}</td>
			<td><a href="show/${f:h(post.id)}">${f:h(post.title)}</a></td>
		</tr>
	</c:forEach>
</table>
<p></p>
<p></p>
<a href="new">新規メモ</a>
<p></p>
<p></p>
<a href="../user/logout">ログアウト</a>

</body>
</html>