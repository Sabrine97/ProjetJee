<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
                <!DOCTYPE html>
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
                                <a href="https://www.javaguides.net" class="navbar-brand"> Gestion de ma
                                    pharmacie </a>
                            </div>

                            <ul class="navbar-nav">
                                <li><a href="<%=request.getContextPath()%>/articles" class="nav-link">Articles</a></li>
                            </ul>
                            <div class="container text-right" style="display: unset;">
                                <a href="<%=request.getContextPath()%>/logout" class="btn btn-danger">Déconnexion</a>
                            </div>
                        </nav>
                    </header>
                    <div class="container col-md-5">
                        <div class="card">
                            <div class="card-body">
                                <form:form action="update" method="POST" modelAttribute="article">
                                    <caption>
                                        <h2>

                                            Modifier un article
                                        </h2>
                                    </caption>
                                    <form:input type="hidden" path="id"/>
                                    <fieldset class="form-group">
                                        <label>Nom de l'article</label>
                                        <form:input type="text" class="form-control" path="nom" required="required"/>
                                    </fieldset>
                                    <fieldset class="form-group">
                                        <label>Prix</label>
                                        <form:input type="text" class="form-control" path="prix" required="required"/>
                                    </fieldset>
                                    <fieldset class="form-group">
                                        <label>Quantité</label>
                                        <form:input type="text" class="form-control" path="Quantite" required="required"/>
                                    </fieldset>
                                    <fieldset class="form-group">
                                        <label>Description de l'article</label>
                                        <form:input type="text" class="form-control" path="description"
                                            required="required"/>
                                    </fieldset>
                                    <fieldset>
                                        <button type="submit" class="btn btn-success">Enregistrer</button>
                                        <a href="<%=request.getContextPath()%>/articles" class="btn btn-warning">Annuler</a>
                                    </fieldset>
                                </form:form>
                            </div>
                        </div>
                    </div>


                </body>

                </html>