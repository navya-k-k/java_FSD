<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
	<style type="text/css">
		body {
			font-family: Arial, sans-serif;
			background-color: white;
			margin: 0;
			padding: 0;
		}

		.container {
			max-width: 500px;
			margin: 0 auto;
			padding: 20px;
		}

		h1 {
			font-size: 2em;
			margin-top: 0;
			margin-bottom: 20px;
			font-weight: bold;
			text-align: center;
			color: #333;
		}

		.btn-container {
			display: flex;
			flex-direction: column;
			align-items: center;
			gap: 15px;
		}

		.btn-row {
			display: flex;
			justify-content: center;
		}

		.btn {
			padding: 15px 30px;
			background-color: #333;
			color: white;
			text-align: center;
			font-size: 1em;
			font-weight: bold;
			border: none;
			border-radius: 6px;
			cursor: pointer;
			transition: background-color 0.3s ease;
		}

		.btn:hover {
			background-color: #555;
		}
	</style>
</head>
<body>
	<div class="container">
		<h1>RAILWAY CROSSING APPLICATION</h1>

		<div class="btn-container">
			<div class="btn-row">
				<button onclick="location.href = 'user-login.jsp';" class="btn">LOGIN AS PUBLIC USER</button>
			</div>
			<div class="btn-row">
				<button onclick="location.href = 'admin-login.jsp';" class="btn">LOGIN AS GOVT. ADMIN</button>
			</div>
		</div>
	</div>
</body>
</html>
