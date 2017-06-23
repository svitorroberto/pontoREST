<!doctype html>
<html lang="en" class="no-js">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
	<title>Welcome to Grails</title>
	<meta name="viewport" content="width=device-width, initial-scale=1"/>

	<style type="text/css">
	[ng\:cloak], [ng-cloak], [data-ng-cloak], [x-ng-cloak], .ng-cloak, .x-ng-cloak {
		display: none !important;
	}
	</style>

	<asset:stylesheet src="application.css"/>

	<asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>

	<script type="text/javascript">
		window.contextPath = "${request.contextPath}";
	</script>
</head>

<body ng-app="todo" ng-controller="TodoController as vm">

<g:include view="navBar.gsp"></g:include>

<div class="svg" role="presentation">
	<div class="grails-logo-container">
		<asset:image src="grails-cupsonly-logo-white.svg" class="grails-logo"/>
	</div>
</div>

<div id="content" role="main">
	<section class="row colset-2-its">
		<!-- Our code will be here -->
		<!--
		<div class="form">
			<input type="text" ng-model="vm.newTodo.description"/>
			<button type="button" ng-click="vm.save()">add</button>
		</div>

            <div ng-include="'/todo/list.html'"></div>
        -->

	</section>
</div>

<div class="footer" role="contentinfo"></div>

<div id="spinner" class="spinner" style="display:none;">
	<g:message code="spinner.alt" default="Loading&hellip;"/>
</div>

<asset:javascript src="/todo/app"/>
</body>
</html>
