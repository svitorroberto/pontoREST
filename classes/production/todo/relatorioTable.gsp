<div class="text-center">
	<table>
		<tbody>
		<g:each var="r" in="${relatorios}">
			<tr>
				<td>
					${r.idPessoa}
				</td>
				<td>
					<tr>
						<g:formatDate>${r.pontoBatido.get(0)} - ${r.pontoBatido.get(1)}</g:formatDate>
						<g:formatDate>${r.pontoBatido.get(2)} - ${r.pontoBatido.get(3)}</g:formatDate>
					</tr>
				</td>
				<td>
					${r.saldoHoras}
				</td>
			</tr>
		</g:each>
		</tbody>
	</table>
</div>