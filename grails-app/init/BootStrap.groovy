import todo.Registro
import todo.Todo

class BootStrap {

    public static final long HOUR = 3600*1000;

    def init = { servletContext ->
        5.times { new Todo(description: "Todo ${it+1}").save() }
        4.times {
            Date data = Date.newInstance()
            new Registro(dataEHora: data, idPessoa: 10, justificativa: "teste 0"+it).save() }
//        7.times {new Configuracao(diaDaSemana: Dia.values()[it+1], cargaHoraria: it+1, tipo: Tipo.values()[1])}
    }
    def destroy = {
    }
}
