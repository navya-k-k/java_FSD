<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Alert Box on Page Load</title>
    <script>
        window.onload = function() {
            alert("Railway Crossing Already Exist");
            setTimeout(function() {
                window.location.href = "admin-dashboard.jsp";
            }, 10); // Delay the redirection for 2 seconds (2000 milliseconds)
        };
    </script>
</head>
<body>
</body>
</html>
