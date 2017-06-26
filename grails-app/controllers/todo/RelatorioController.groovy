package todo

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class RelatorioController {

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    RelatorioService relatorioService

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Relatorio.list(params), model:[relatorioCount: Relatorio.count()]
    }

    def show(Relatorio relatorio) {
        respond relatorio
    }

    @Transactional
    def save(Relatorio relatorio) {
        if (relatorio == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (relatorio.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond relatorio.errors, view:'create'
            return
        }

        relatorio.save flush:true

        respond relatorio, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Relatorio relatorio) {
        if (relatorio == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (relatorio.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond relatorio.errors, view:'edit'
            return
        }

        relatorio.save flush:true

        respond relatorio, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Relatorio relatorio) {

        if (relatorio == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        relatorio.delete flush:true

        render status: NO_CONTENT
    }

    def relatorioRegistros(Relatorio relatorio){
        relatorio = new Relatorio([idPessoa: 10])//FIXME
        respond relatorios: relatorioService.obterRelatorios(relatorio), view:'relatorioRegistros'
    }
}
