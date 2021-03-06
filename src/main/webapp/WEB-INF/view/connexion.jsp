<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Connexion</title>
	
	<!--  Include CSS and Bootstrap CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<!-- Bootstrap icons  -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
	<!-- Customized style -->
	<style type="text/css">
		.icon{
			width: 80px;
		    height: 80px;
		    background: #0affc2;
		    border-radius: 50%;
		    font-size: 30px;
		    margin: 0 auto;
		    margin-bottom: 10px;
		}
		#connexion{
			background: #0affc2;
			width: 140px;
		    height: 40px;
		}
	</style>
</head>

<body class="bg-secondary bg-opacity-10">
	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-lg-4 col-sm-6 text-center">
				<div class="icon d-flex align-items-center justify-content-center mt-5 mb-3">
					<i class="bi bi-person-fill text-light"></i>
				</div>
				<form method="post" action="connexion">
					<div class="mb-3">
						<label for="login" class="form-label fs-4">Login</label>
						<input type="text" class="form-control" id="login" name="login" value="${programmeur.login}" aria-describedby="loginErreur">
						<div id="loginErreur" class="text-danger form-text">${form.erreurs.login}</div>
					</div>
					<div class="mb-3">
						<label for="motPasse" class="form-label fs-4">Mot de passe</label>
						<input type="password" class="form-control" id="motPasse" name="motPasse" aria-describedby="motPasseErreur">
						<div id="motPasseErreur" class="text-danger form-text">${form.erreurs.motPasse}</div>
					</div>
					<button type="submit" class="btn text-light" id="connexion">Connexion</button>
				</form>
				<c:if test="${!empty form.resultat}">
					<div class="alert alert-danger mt-3" role="alert">${form.resultat}</div>
				</c:if>
			</div>
		</div>
	</div>

	<!-- Bootstrap Bundle with Popper -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>