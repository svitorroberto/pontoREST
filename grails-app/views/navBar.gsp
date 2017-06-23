<div class="navbar navbar-default navbar-static-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" ng-click="navExpanded = !navExpanded">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/">
				<i class="fa grails-icon">
					<asset:image src="grails-cupsonly-logo-white.svg"/>
				</i> ZG Ponto Eletrônico
			</a>
		</div>

		<div class="navbar-collapse collapse" aria-expanded="false" style="height: 0.8px;" uib-collapse="!navExpanded">
			<ul class="nav navbar-nav navbar-right">
				<li class="container">
					<a class="navbar-brand" href="/marcacao">Bater Ponto</a>
				</li>
				<li class="container">
					<a class="navbar-brand" href="/requisicao">Requisitar Ponto</a>
				</li>
				<li class="container">
					<a class="navbar-brand" href="/relatorio">Relatório</a>
				</li>
			</ul>
		</div>
	</div>
</div>