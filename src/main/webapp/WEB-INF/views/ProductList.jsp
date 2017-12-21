<%--
  Created by IntelliJ IDEA.
  User: Piotr
  Date: 21.12.2017
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>ProductList</title>
</head>
<body ng-app="ysdapp">
<div ng-controller="ProductController as ctrl">
    <div class="row" id="moveable" ng-repeat="product in ctrl.products">
        <p>
            <span ng-bind="product.ean"></span>
            <span ng-bind="product.name"></span>

        </p>
    </div>
<script
        src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.
        4/angular.js"></script>
<script src="/static/js/app.js"></script>
<script src="/static/js/services/product_service.js_service.js"></script>
<script src="/static/js/controller/product_controller.js"></script>


</body>
</html>
