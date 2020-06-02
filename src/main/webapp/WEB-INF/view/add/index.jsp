<%@page pageEncoding="UTF-8"%>
<html>
<head>
<title>Tutorial: Add</title>
<link rel="stylesheet" type="text/css" href="${f:url('/css/sa.css')}" />
</head>
<body>

<h1>Tutorial: Form</h1><a href="http://localhost:8080/sa-struts-tutorial/">Homeへ</a>

<html:errors/>
<s:form method="POST">
<label for="name">名前</label>
<html:text property="name"/><br />
<label for="article">本文</label>
<html:textarea property="article"/>
<input type="submit" name="submit" value="送信する"/>
<br />
<br />
${f:h(name)}<br />
${f:h(article)}<br />
</s:form>
</body>
</html>