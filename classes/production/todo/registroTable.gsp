<div class="text-center">
	<table>
		<tbody>
		<g:each var="r" in="${registros}">
			<tr>
				<td>
					${r.dataEHora}
				</td>
				<td>
					${r.idPessoa}
				</td>
				<td>
					<button type="button" ng-click="vm.delete(r)">Deletar</button>
				</td>
			</tr>
		</g:each>
		</tbody>
	</table>
</div>