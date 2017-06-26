package todo

import grails.databinding.BindingFormat
import grails.rest.Resource

@Resource(readOnly = false, formats = ['json', 'xml'])
class Registro {
	Long idPessoa
	Date dataEHora
	String justificativa
	Situacao situacao

	static constraints = {
		justificativa nullable: true
		situacao nullable: true
		situacao defaultValue: 1
	}

	def beforeInsert(){
		this.dataEHora = new Date()
	}

}