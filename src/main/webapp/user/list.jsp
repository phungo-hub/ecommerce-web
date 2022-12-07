<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>CozMoStore</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
    <style>
        nav {
            font-size: 1.15rem;
            top: 0;
        }
        .container {
            text-align: center;
        }

        .user-avatar {
            width: 3.25rem;
            height: 3.25rem;
            border-radius: 50%;
        }

        .user-actions {
            width: 10rem;
            background-color: #f8f9fa;
            border-radius: 5%;
            display: none;
            top: 120%;
            animation: fadeIn ease-in .3s;
        }
        .user-actions::before {
            content: "";
            display: block;
            position: absolute;
            left: 0;
            top: -25px;
            height: 30px;
            width: 100%;
        }
        @keyframes fadeIn {
            from {
                opacity: 0;
            } to {
                  opacity: 1;
              }
        }

        .tony:hover .user-actions {
            display: block;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light mb-2">
    <div class="container-sm">
        <a class="navbar-brand middle" href="/eyeglasses">CozmoStore</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/eyeglasses">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">About</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Contact</a>
                </li>
            </ul>

            <ul class="navbar-nav my-2 my-lg-0">
                <c:if test="${requestScope['username'] != null}">
                    <li class="tony nav-item d-flex align-items-center position-relative">
                        <img src="/img/pikachu.jpeg" alt="" class="user-avatar">
                        ${requestScope['username']}
                        <a class="nav-link user-actions position-absolute" href="/eyeglasses">
                            <div class="user-actions__log-out">
                                Log Out
                            </div>
                        </a>
                    </li>
                </c:if>
                <c:if test="${requestScope['username'] == null}">
                    <li class="nav-item">
                        <a class="nav-link" href="user/login.jsp">Login</a>
                    </li>
                </c:if>
                <li class="nav-item d-flex align-items-center">
                    <a class="nav-link" href="/shopping-cart">Shopping Bag</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <div class="jumbotron">
        <h1>Eyeglasses products</h1>
        <p>All CozMoStore spectacles and sunglasses come with high index aspheric lenses that have dust-repellent coating and offer UV protection.
            Find your perfect pair of eyewear in OWNDAYS.</p>
    </div>
</div>
<div class="input-group justify-content-center mb-5">
    <form class="form-outline w-25 d-flex" method="get">
        <input type="search" name="search" id="form1" class="form-control" placeholder="Enter brand name or product number"/>
        <button type="submit" class="btn btn-primary">
            <i class="fas fa-search"></i>
        </button>
    </form>
</div>
<c:set var="eyeglasses"
    value="${requestScope['eyeglasses']}"
></c:set>
<div class="container">
    <c:forEach var="i" begin="0" end="${eyeglasses.size()-1}" step="3">
        <div class="row text-center">
            <div class="col-4">
                <a class="ripple" href="/eyeglasses?action=view&id=${eyeglasses[i].getId()}">
                    <img class="w-100 hover-shadow" src="${eyeglasses[i].getUrl()}" alt="John Dilinger">
                </a>

                <div class="price-desc">
                    <p><a class="nav-link link-secondary" href="/eyeglasses?action=view&id=${eyeglasses[i].getId()}">
                        ${eyeglasses[i].getName()}
                    </a></p>

                    <p><a class="nav-link link-secondary" href="/eyeglasses?action=view&id=${eyeglasses[i].getId()}">
                        $${eyeglasses[i].getPrice()}
                    </a></p>
                    <p><a class="nav-link link-secondary" href="/eyeglasses?action=view&id=${eyeglasses[i].getId()}">
                            ${eyeglasses[i].getId()}
                    </a></p>
                </div>
            </div>
            <c:if test="${eyeglasses[i+1] != null}">
                <div class="col-4">
                    <a class="ripple" href="/eyeglasses?action=view&id=${eyeglasses[i+1].getId()}">
                        <img class="w-100 hover-shadow" src="${eyeglasses[i+1].getUrl()}" alt="John Dilinger">
                    </a>

                    <div class="price-desc">
                        <p><a class="nav-link link-secondary" href="/eyeglasses?action=view&id=${eyeglasses[i+1].getId()}">
                                ${eyeglasses[i+1].getName()}
                        </a></p>

                        <p><a class="nav-link link-secondary" href="/eyeglasses?action=view&id=${eyeglasses[i+1].getId()}">
                                $${eyeglasses[i+1].getPrice()}
                        </a></p>
                        <p><a class="nav-link link-secondary" href="/eyeglasses?action=view&id=${eyeglasses[i+1].getId()}">
                                ${eyeglasses[i+1].getId()}
                        </a></p>
                    </div>
                </div>
            </c:if>

            <c:if test="${eyeglasses[i+2] != null}">
            <div class="col-4">
                <a class="ripple" href="/eyeglasses?action=view&id=${eyeglasses[i+2].getId()}">
                    <img class="w-100 hover-shadow" src="${eyeglasses[i+2].getUrl()}" alt="John Dilinger">
                </a>

                <div class="price-desc">
                    <p><a class="nav-link link-secondary" href="/eyeglasses?action=view&id=${eyeglasses[i+2].getId()}">
                            ${eyeglasses[i+2].getName()}
                    </a></p>

                    <p><a class="nav-link link-secondary" href="/eyeglasses?action=view&id=${eyeglasses[i+2].getId()}">
                            $${eyeglasses[i+2].getPrice()}
                    </a></p>
                    <p><a class="nav-link link-secondary" href="/eyeglasses?action=view&id=${eyeglasses[i+2].getId()}">
                            ${eyeglasses[i+2].getId()}
                    </a></p>
                </div>
            </c:if>
            </div>
        </div>
    </c:forEach>

</div>
<!-- Footer -->
<footer class="text-center text-lg-start bg-white text-muted">
    <!-- Section: Social media -->
    <section class="d-flex justify-content-center justify-content-lg-between p-4 border-bottom">
        <!-- Left -->
        <div class="me-5 d-none d-lg-block">
            <span>Get connected with us on social networks:</span>
        </div>
        <!-- Left -->

        <!-- Right -->
        <div>
            <a href="" class="me-4 link-secondary">
                <i class="fab fa-facebook-f"></i>
            </a>
            <a href="" class="me-4 link-secondary">
                <i class="fab fa-twitter"></i>
            </a>
            <a href="" class="me-4 link-secondary">
                <i class="fab fa-google"></i>
            </a>
            <a href="" class="me-4 link-secondary">
                <i class="fab fa-instagram"></i>
            </a>
            <a href="" class="me-4 link-secondary">
                <i class="fab fa-linkedin"></i>
            </a>
            <a href="" class="me-4 link-secondary">
                <i class="fab fa-github"></i>
            </a>
        </div>
        <!-- Right -->
    </section>
    <!-- Section: Social media -->

    <!-- Section: Links  -->
    <section class="">
        <div class="container text-center text-md-start mt-5">
            <!-- Grid row -->
            <div class="row mt-3">
                <!-- Grid column -->
                <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
                    <!-- Content -->
                    <h6 class="text-uppercase fw-bold mb-4">
                        <i class="fas fa-gem me-3 text-secondary"></i>Company name
                    </h6>
                    <p>
                        Here you can use rows and columns to organize your footer content. Lorem ipsum
                        dolor sit amet, consectetur adipisicing elit.
                    </p>
                </div>
                <!-- Grid column -->

                <!-- Grid column -->
                <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
                    <!-- Links -->
                    <h6 class="text-uppercase fw-bold mb-4">
                        Products
                    </h6>
                    <p>
                        <a href="#!" class="text-reset">Angular</a>
                    </p>
                    <p>
                        <a href="#!" class="text-reset">React</a>
                    </p>
                    <p>
                        <a href="#!" class="text-reset">Vue</a>
                    </p>
                    <p>
                        <a href="#!" class="text-reset">Laravel</a>
                    </p>
                </div>
                <!-- Grid column -->

                <!-- Grid column -->
                <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
                    <!-- Links -->
                    <h6 class="text-uppercase fw-bold mb-4">
                        Useful links
                    </h6>
                    <p>
                        <a href="#!" class="text-reset">Pricing</a>
                    </p>
                    <p>
                        <a href="#!" class="text-reset">Settings</a>
                    </p>
                    <p>
                        <a href="#!" class="text-reset">Orders</a>
                    </p>
                    <p>
                        <a href="#!" class="text-reset">Help</a>
                    </p>
                </div>
                <!-- Grid column -->

                <!-- Grid column -->
                <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
                    <!-- Links -->
                    <h6 class="text-uppercase fw-bold mb-4">Contact</h6>
                    <p><i class="fas fa-home me-3 text-secondary"></i> New York, NY 10012, US</p>
                    <p>
                        <i class="fas fa-envelope me-3 text-secondary"></i>
                        info@example.com
                    </p>
                    <p><i class="fas fa-phone me-3 text-secondary"></i> + 01 234 567 88</p>
                    <p><i class="fas fa-print me-3 text-secondary"></i> + 01 234 567 89</p>
                </div>
                <!-- Grid column -->
            </div>
            <!-- Grid row -->
        </div>
    </section>
    <!-- Section: Links  -->

    <!-- Copyright -->
    <div class="text-center p-4" style="background-color: rgba(0, 0, 0, 0.025);">
        &#169;2022 Copyright:
        <a class="text-reset fw-bold" href="https://mdbootstrap.com/">Phu</a>
    </div>
    <!-- Copyright -->
</footer>
<!-- Footer -->
</body>
<script src="https://kit.fontawesome.com/4846f4e74e.js" crossorigin="anonymous"></script>
</html>