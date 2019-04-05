<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String redirectURL = "/";
    if(session.getAttribute("user") == null || session.getAttribute("mode").equals("1") || session.getAttribute("mode").equals("2"))
    {
        response.sendRedirect(redirectURL);
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>System autoryzacji</title>
    <link rel="stylesheet" href="css/uikit.min.css">
    <script src="js/jquery.js"></script>
    <script src="js/uikit.min.js"></script>
</head>
<body>

<div class="uk-vertical-align uk-text-center uk-height-1-1">
    <div class="uk-vertical-align-middle" style="width: 400px;">


        <form class="uk-panel uk-panel-box uk-form" action="manage" method="post">
            <div class="uk-form-row">
                <input class="uk-width-1-1 uk-form-large" type="text" placeholder="Username" name="name">
            </div>
            <div class="uk-form-row">
                <select class="uk-width-1-1 uk-form-large" name="mode">
                    <option value="1">Normal user</option>
                    <option value="2">Premium user</option>
                    <option value="3">Admin</option>
                </select>
            </div>
            <div class="uk-form-row">
                <button class="uk-width-1-1 uk-button uk-button-primary uk-button-large">Update</button>
            </div>
        </form>

    </div>
</div>

</body>
</html>