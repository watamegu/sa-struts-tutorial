<%@page pageEncoding="UTF-8"%>
<html>
<head>
<title>メモ一覧</title>
<link rel="stylesheet" type="text/css" href="${f:url('/css/sa.css')}" />
</head>
<body>

<h1>メモ一覧</h1>

<html:messages id="message" message="true">
<p>${message}</p>
</html:messages>
<table border="1">
  <tr>
  	<td>フラグ</td>
		<td>ID</td>
		<td>タイトル</td>
	</tr>
	<c:forEach var = "post" items = "${ postList }">
		<tr>
			<td>${f:h(post.flag)}</td>
			<td>${f:h(post.id)}</td>
			<td><a href="show/${f:h(post.id)}">${f:h(post.title)}</a></td>
		</tr>
	</c:forEach>
</table>
<p></p>
<p></p>
<a href="new">新規メモ</a><br />
<c:if test="${admin = true}">
	<a href="../user/list">ユーザー管理</a>
</c:if>
<p></p>
<p></p>
<a href="../user/logout">ログアウト</a>

</body>
</html>