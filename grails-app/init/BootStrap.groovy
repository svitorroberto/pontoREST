import grails.plugin.springsecurity.SpringSecurityService
import todo.Registro
import todo.Todo
import todo.security.SecRole
import todo.security.SecUser
import todo.security.SecUserSecRole

class BootStrap {

    SpringSecurityService springSecurityService

    def init = { servletContext ->
        5.times { new Todo(description: "Todo ${it+1}").save() }
        4.times {
            Date data = Date.newInstance()
            new Registro(dataEHora: data, idPessoa: 10, justificativa: "teste 0"+it).save() }


        def userRole = SecRole.findByAuthority('ROLE_USER') ?: new SecRole(authority: 'ROLE_USER').save(failOnError: true)
        def adminRole = SecRole.findByAuthority('ROLE_ADMIN') ?: new SecRole(authority: 'ROLE_ADMIN').save(failOnError: true)

        def adminUser = SecUser.findByUsername('admin') ?: new SecUser(
                username: 'admin',
                password: springSecurityService.encodePassword('admin'),
                enabled: true).save(failOnError: true)

        if (!adminUser.authorities.contains(adminRole)) {
            SecUserSecRole.create adminUser, adminRole
        }
//        7.times {new Configuracao(diaDaSemana: Dia.values()[it+1], cargaHoraria: it+1, tipo: Tipo.values()[1])}
    }
    def destroy = {
    }
}
