<html>
<head></head>
<body>
<h1>Login</h1>
<form name='f' action="login" method='POST'>
    <table>
        <tr>
            <td>User:</td>
            <td><input type='text' name='username' value=''></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='password'/></td>
        </tr>
        <tr>
            <td><input name="submit" type="submit" value="submit"/></td>
        </tr>
        <tr>
            <td><input type="button" value="Registration"
                       onclick="window.location.href = 'userRegistration'"></td>
        </tr>
    </table>
</form>
</body>
</html>