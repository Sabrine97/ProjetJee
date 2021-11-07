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
                                <caption>
                                    <h2>

                                        Consulter un article
                                    </h2>
                                </caption>
                                <fieldset class="form-group">
                                    <c:choose>
                                        <c:when test="${article.nom == 'Aspirine'}">
                                            <img src="/img/aspirine.jpg" style="width: 50%;">
                                        </c:when>
                                        <c:when test="${article.nom == 'Paracetamol'}">
                                            <img src="/img/paracetamol.png" style="width: 50%;">
                                        </c:when>
                                        <c:when test="${article.nom == 'Ibuprofène'}">
                                            <img src="/img/ibupro.jpg" style="width: 50%;">
                                        </c:when>
                                        <c:otherwise>
                                            <img src="/img/no_image.jpg" style="width: 50%;">
                                        </c:otherwise>
                                    </c:choose>
                                </fieldset>
                                <fieldset class="form-group">
                                    <label>Nom de l'article</label>
                                    <input type="text" class="form-control" value="${article.nom}"
                                        readonly="readonly" />
                                </fieldset>
                                <fieldset class="form-group">
                                    <label>Prix</label>
                                    <input type="text" class="form-control" value="${article.prix}"
                                        readonly="readonly" />
                                </fieldset>
                                <fieldset class="form-group">
                                    <label>Quantité</label>
                                    <input type="text" class="form-control" value="${article.quantite}"
                                        readonly="readonly" />
                                </fieldset>
                                <fieldset class="form-group">
                                    <label>Description de l'article</label>
                                    <input type="text" class="form-control" value="${article.description}"
                                        readonly="readonly" />
                                </fieldset>
                                <fieldset>
                                    <a href="<%=request.getContextPath()%>/articles" class="btn btn-warning">Retour</a>
                                </fieldset>
                            </div>
                        </div>
                    </div>


                </body>

                </html>