<form action="/logout" method="post">
            <input type="submit" value="Выход" class="btn btn-danger"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>