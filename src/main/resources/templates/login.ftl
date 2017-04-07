<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<body>

<form action="/login" method="post">
    <div>
        <label> User Name :
            <input type="text" name="name" class="form-control form-horizontal"/> </label>
    </div>
    <div>
        <label> Password:
            <input type="password" name="password" class="form-control form-horizontal"/> </label>
    </div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <div><input type="submit" value="Sign In" class="btn btn-success"/></div>
</form>
</body>
</html>