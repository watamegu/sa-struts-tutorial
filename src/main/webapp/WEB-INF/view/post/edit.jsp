<%@page pageEncoding="UTF-8"%>
<html>
<head>
<title>Tutorial:メモ編集</title>
<link rel="stylesheet" type="text/css" href="${f:url('/css/sa.css')}" />
</head>
<body>

<h1>メモ編集</h1>

<html:messages id="message" message="true">
<p>${message}</p>
</html:messages>
<s:form method="POST" action="/post/update/${f:h(strId)}/">
	<label for="title">タイトル</label><br />
	<html:text property="title" value="${f:h(title)}"></html:text><br />
	<label for="content">本文</label><br />
	<html:textarea property="content" value="${f:h(content)}"></html:textarea><br />
	<html:checkbox property="flag"/>重要フラグ<br />
	<input type="submit" name="update" value="保存する"/>
	<a href="../show/${f:h(strId)}">キャンセル</a>
</s:form>
</body>
</html>