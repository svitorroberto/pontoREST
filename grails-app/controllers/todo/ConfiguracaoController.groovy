package todo

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ConfiguracaoController {

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Configuracao.list(params), model:[configuracaoCount: Configuracao.count()]
    }

    def show(Configuracao configuracao) {
        respond configuracao
    }

    @Transactional
    def save(Configuracao configuracao) {
        if (configuracao == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (configuracao.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond configuracao.errors, view:'create'
            return
        }

        configuracao.save flush:true

        respond configuracao, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Configuracao configuracao) {
        if (configuracao == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (configuracao.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond configuracao.errors, view:'edit'
            return
        }

        configuracao.save flush:true

        respond configuracao, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Configuracao configuracao) {

        if (configuracao == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        configuracao.delete flush:true

        render status: NO_CONTENT
    }
}
