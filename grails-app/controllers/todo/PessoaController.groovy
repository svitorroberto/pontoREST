package todo

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PessoaController {

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Pessoa.list(params), model:[pessoaCount: Pessoa.count()]
    }

    def show(Pessoa pessoa) {
        respond pessoa
    }

    @Transactional
    def save(Pessoa pessoa) {
        if (pessoa == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (pessoa.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond pessoa.errors, view:'create'
            return
        }

        pessoa.save flush:true

        respond pessoa, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Pessoa pessoa) {
        if (pessoa == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (pessoa.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond pessoa.errors, view:'edit'
            return
        }

        pessoa.save flush:true

        respond pessoa, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Pessoa pessoa) {

        if (pessoa == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        pessoa.delete flush:true

        render status: NO_CONTENT
    }
}
