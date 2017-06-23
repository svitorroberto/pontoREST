import todo.Registro
import todo.Todo

class BootStrap {

    def init = { servletContext ->
        5.times { new Todo(description: "Todo ${it+1}").save() }
        5.times { new Registro(dataEHora: Date.newInstance(), idPessoa: 10, justificativa: "teste 0"+it).save() }
//        7.times {new Configuracao(diaDaSemana: Dia.values()[it+1], cargaHoraria: it+1, tipo: Tipo.values()[1])}
    }
    def destroy = {
    }
}
