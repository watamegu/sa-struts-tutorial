<%@page pageEncoding="UTF-8"%>
<html>
<head>
<title>Tutorial：メモ詳細</title>
<link rel="stylesheet" type="text/css" href="${f:url('/css/sa.css')}" />
</head>
<body>

<h1>メモ詳細</h1>

<html:messages id="message" message="true">
<p>${message}</p>
</html:messages>
<p>タイトル：${f:h(title)}</p>
<p>本文：</p>
<p>${f:h(content)}</p>
<br />
<p>
	<a href="../list">戻る</a>|
	<a href="../edit/${f:h(id)}">編集する</a>|
	<a href="../delete/${f:h(id)}">削除する</a>
</p>
</body>
</html>