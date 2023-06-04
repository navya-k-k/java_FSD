<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
	<link rel="stylesheet" type="text/css" href="index.css">
	<style type="text/css">
		body {
			font-family: Arial, sans-serif;
			background-color: #f1f1f1;
			margin: 0;
			padding: 0;
		}

		.container {
			max-width: 500px;
			margin: 0 auto;
			padding: 20px;
		}

		h2 {
			font-size: 2em;
			text-align: center;
			margin: 0;
			padding: 20px 0;
			color: #333;
		}

		.form-container {
			background-color: white;
			box-shadow: 0 2px 4px rgba(46, 91, 173, 0.6);
			margin-left: auto;
			margin-right: auto;
			margin-top: 50px;
			padding: 20px;
			border-radius: 5px;
			width: 70%;
		}

		.form-title {
			color: green;
			font-size: 1.5em;
			text-align: center;
			margin-bottom: 30px;
			text-shadow: 2px 4px 4px rgba(46, 91, 173, 0.6);
		}

		.input-field {
			margin-bottom: 20px;
		}

		.input-field input[type="email"],
		.input-field input[type="password"] {
			width: 100%;
			border: none;
			border-bottom: 1px solid #ccc;
			padding: 10px;
			font-size: 1em;
		}

		.input-field input[type="email"]:focus,
		.input-field input[type="password"]:focus {
			border-bottom: 1px solid #333;
		}

			.btn-login {
			width: 100%;
			padding: 15px;
			background-color: #4CAF50;
			color: #fff;
			border: none;
			border-radius: 5px;
			cursor: pointer;
		}

		.btn-login:hover {
			background-color: red;
		}
		

		.btn-login:hover {
			background-color: darkred;
		}

		.register-link {
			display: flex;
			justify-content: flex-end;
			margin-top: 20px;
		}

		.register-link a {
			color: blue;
			text-decoration: underline;
		}
	</style>
</head>
<body>
	<div class="container">
		<div class="form-container">
			<h2>RAILWAY CROSSING APPLICATION</h2>

			<div class="form-title">USER LOGIN</div>

			<form action="userlogin" method="post">
				<div class="input-field">
					<input id="email" type="email" class="validate" name="email" placeholder="Enter email" required>
				</div>

				<div class="input-field">
					<input id="password" type="password" class="validate" placeholder="Enter password" name="password" required>
				</div>

				<div class="center">
					<button class="btn-login" type="submit">LOGIN</button>
				</div>
			</form>

			<div class="register-link">
				<span class="right">Not a member?</span>
				<a class="modal-trigger" href="user-register.jsp"><u>REGISTER</u></a>
			</div>
		</div>
	</div>
</body>
</html>
