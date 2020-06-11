<%@page pageEncoding="UTF-8"%>
<html>
<head>
<title>Tutorial:メモ編集</title>
<link rel="stylesheet" type="text/css" href="${f:url('/css/sa.css')}" />
</head>
<body>

<h1>メモ作成</h1>
<p>${f:h(message)}</p>
<s:form method="POST" action="/post/create/">
	<label for="title">タイトル</label><br />
	<html:text property="title" value=""></html:text><br />
	<label for="content">本文</label><br />
	<html:textarea property="content" value=""></html:textarea><br />
	<input type="submit" name="create" value="作成する"/>
	<a href="list">キャンセル</a>
</s:form>
</body>
</html>