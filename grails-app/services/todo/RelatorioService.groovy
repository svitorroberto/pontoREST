package todo

import grails.transaction.Transactional

import java.text.DateFormat
import java.text.SimpleDateFormat

@Transactional
class RelatorioService {
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    def serviceMethod() {

    }

    def obterRelatorios(Relatorio relatorio){
        Relatorio resultadoRelatorio = new Relatorio()
       //    if(relatorio.pontoBatido.isEmpty()){
            ArrayList<Registro> registros
            def datas = Registro.executeQuery("from Registro where idPessoa = :id", [id:relatorio.idPessoa])
            datas.each {
                registros = Registro.executeQuery("select idPessoa CAST(dataehora AS DATE) as data from Registro where idPessoa = :id and data = CAST(:data)", [id:relatorio.idPessoa, data: it])
                registros.each { data, index ->
                    resultadoRelatorio.pontoBatido
                }
            }

            //ArrayList<Registro> registros = Registro.executeQuery("from Registro where idPessoa = :id", [id:relatorio.idPessoa])

        //}

        return Relatorio.executeQuery("from Relatorio where idPessoa = :id", [offset:0, max:4, id:relatorio.idPessoa])
    }

    def Map separaPorDia(ArrayList<Registro> registros){
        //retorna Map<Date,List<Relatorio>>
    }
}
