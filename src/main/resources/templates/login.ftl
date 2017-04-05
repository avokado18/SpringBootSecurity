<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link href="/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <title>Spring Security Example</title>
</head>
<body>

<form action="/login" method="post">
    <div>
        <label> Имя :
        <input type="text" name="username" class="form-control"/> </label>
    </div>
    <div>
        <label> Пароль:
        <input type="password" name="password" class="form-control"/> </label>
    </div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" class="btn btn-success"/>
    <div><input type="submit" value="Вход"/></div>
</form>
</body>
</html>
