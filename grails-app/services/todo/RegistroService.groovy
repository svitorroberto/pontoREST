package todo

import grails.transaction.Transactional

@Transactional
class RegistroService {

    def serviceMethod() {

    }

    def salvar(Registro registro){
        registro.situacao = Situacao.ACEITA
        registro.dataEHora = new Date()

        return registro.save()
    }
}
