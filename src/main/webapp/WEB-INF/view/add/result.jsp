<%@page pageEncoding="UTF-8"%>
<html>
<head>
<title>Tutorial: Add</title>
<link rel="stylesheet" type="text/css" href="${f:url('/css/sa.css')}" />
</head>
<body>

<h1>Tutorial: Form Result</h1><a href="http://localhost:8080/sa-struts-tutorial/">Homeへ</a>

<html:errors/>
<s:form>
<label for="name">名前：</label>
${f:h(name)}<br />
<label for="name">本文：</label>
${f:h(article)}<br />
<input type="submit" name="index" value="戻る"/>
</s:form>
</body>
</html>