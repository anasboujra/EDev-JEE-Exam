<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Liste des projets</title>

	<!--  Include CSS and Bootstrap CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<!-- Bootstrap icons  -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
</head>

<body>
	
	<div class="container mt-3">
		<div class="row">
			<div class="col-10">
				<h2>Programmeur: ${sessionScope.sessionUtilisateur.nom} ${sessionScope.sessionUtilisateur.prenom}</h2>
			</div>
			<div class="col-auto">
				<a href="deconnexion" class="btn btn-danger btn-sm mt-2 ms-5" role="button">Se Déconnecter</a>
			</div>
		</div>
	
		<table class="table mt-3">
			<thead class="table-secondary">
				<tr>
					<th scope="col">Réf Projet</th>
					<th scope="col">Description</th>
					<th scope="col">Volume horaire</th>
					<th scope="col">Heures développées</th>
					<th scope="col" class="text-danger">Supprimer</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="element" items="${liste}">
					<tr>
						<th scope="row">${element.projet.reference}</th>
						<td>${element.projet.description}</td>
						<td>${element.projet.volume} heures</td>
						<td>${element.heures} heures</td>
						<td>
							<a href="?delete=${element.id}">
								<i class="bi bi-trash-fill text-danger ms-3"></i>
							</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>


	<!-- Bootstrap Bundle with Popper -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>