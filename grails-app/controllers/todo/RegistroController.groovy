package todo


import grails.rest.*
import grails.converters.*

import static org.springframework.http.HttpStatus.CREATED

class RegistroController extends RestfulController{
	static responseFormats = ['json', 'xml']

	RegistroService registro

	RegistroController() {
		super(Registro)
	}

	def listaRegistros() {
		return [registros: Registro.list(params)]
	}

	def batePonto() {
		return [registros: Registro.get()]
	}

	def list(){
		respond Registro.getAll()
	}

	def filtrar(){

	}

	def salvar(){
		def r = new Registro(params)
		return registro.salvar(r)
	}

}
