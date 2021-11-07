<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
                <html>

                <head>
                    <title>Ma Pharmacie</title>
                    <link rel="stylesheet"
                        href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
                        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
                        crossorigin="anonymous">
                </head>

                <body>

                    <header>
                        <nav class="navbar navbar-expand-md navbar-dark" style="background-color: #007bff">
                            <div>
                                <a href="https://www.javaguides.net" class="navbar-brand"> Gestion de ma pharmacie </a>
                            </div>

                            <ul class="navbar-nav">
                                <li><a href="<%=request.getContextPath()%>/articles" class="nav-link">Articles</a></li>
                            </ul>

                            <div class="container text-right" style="display: unset;">
                                <a href="<%=request.getContextPath()%>/logout" class="btn btn-danger">Déconnexion</a>
                            </div>
                        </nav>
                    </header>
                    <br>
                    <div class="row">

                        <div class="container">
                            <h3 class="text-center">La liste des articles</h3>
                            <hr>
                            <form:form action="recherche" method="POST" modelAttribute="articleRecherche">
                                <fieldset class="form-group">
                                    <form:input type="text" path="nom"/>
                                    <button type="submit" class="btn btn-success">Rechercher</button>
                                </fieldset>

                            </form:form>
                            <div class="container text-right">
                                <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Ajouter un
                                    article</a>
                            </div>

                            <br>
                            <table class="table table-bordered">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Nom</th>
                                        <th>Prix</th>
                                        <th>Quantité</th>
                                        <th>Actions</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <!--   for (Todo todo: todos) {  -->
                                    <c:forEach var="article" items="${articleList}">

                                        <tr>
                                            <td>
                                                <c:out value="${article.id}" />
                                            </td>
                                            <td>
                                                <c:out value="${article.nom}" />
                                            </td>
                                            <td>
                                                <c:out value="${article.prix} euros" />
                                            </td>
                                            <td>
                                                <c:out value="${article.quantite}" />
                                            </td>
                                            <td><a href="edit?id=<c:out value='${article.id}' />">Modifier</a>
                                                &nbsp;&nbsp;&nbsp;&nbsp;
                                                <a href="delete?id=<c:out value='${article.id}' />">Supprimer</a>
                                                &nbsp;&nbsp;&nbsp;&nbsp;
                                                <a href="details?id=<c:out value='${article.id}' />">Voir</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    <!-- } -->
                                </tbody>

                            </table>
                        </div>
                    </div>
                </body>

                </html>