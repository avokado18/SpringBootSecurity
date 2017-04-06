<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <title>Spring Security Example</title>
</head>
<body>

<form action="/login" method="post">
    <div>
        <label> User Name :
            <input type="text" name="username" class="form-control"/> </label>
    </div>
    <div>
        <label> Password:
            <input type="password" name="password" class="form-control"/> </label>
    </div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" class="btn btn-success"/>
    <div><input type="submit" value="Sign In"/></div>
</form>
</body>
</html>