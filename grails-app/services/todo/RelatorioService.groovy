package todo

import grails.transaction.Transactional
import org.joda.time.DateTime
import org.joda.time.Minutes
import org.joda.time.Period

import java.text.DateFormat
import java.text.SimpleDateFormat

@Transactional
class RelatorioService {
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	def serviceMethod() {
	}

	def obterRelatorios(Relatorio relatorio) {
		Relatorio resultadoRelatorio = new Relatorio()
		if(relatorio.idPessoa != null) {
			ArrayList<Registro> registros
			registros = Registro.executeQuery("from Registro where idPessoa = :id", [id: relatorio.idPessoa])
			Map<String, List<Registro>> registrosSeparados = separaPorDia(registros)
			List<Relatorio> relatorios = formarRelatorios(registrosSeparados)
			return relatorios
		}
		else{
			ArrayList<Registro> registros
			registros = Registro.executeQuery("from Registro")
			Map<String, List<Registro>> registrosSeparados = separaPorDia(registros)
			List<Relatorio> relatorios = formarRelatorios(registrosSeparados)
			return relatorios
		}
	}

	def Map separaPorDia(ArrayList<Registro> registros) {
		Map<String, List<Registro>> registrosSeparados = new HashMap<String, List<Registro>>();
		for (Registro registro : registros) {
			String somenteData = dateFormat.format(registro.dataEHora)
			if (!registrosSeparados.containsKey(somenteData)) {
				List<Registro> quaseRelatorio = new ArrayList<>()
				quaseRelatorio.add(registro)
				registrosSeparados.put(somenteData, quaseRelatorio)
			}else {
				List<Registro> quaseRelatorio = registrosSeparados.get(somenteData)
				quaseRelatorio.add(registro)
				registrosSeparados.put(somenteData, quaseRelatorio)
			}
		}

		return registrosSeparados
	}

	def List<Relatorio> formarRelatorios(Map<String, List<Registro>> mapRegistros) {
		List<Relatorio> listaRelatorioPorDia = new ArrayList<>()
		Relatorio relatorio
		mapRegistros.each {
			relatorio = new Relatorio()
			relatorio.setIdPessoa(it.value.get(0).idPessoa)
			if(it.value.size()==4){
				relatorio.setPontoBatido(it.getValue())
				contarHoras(relatorio)
			}
			listaRelatorioPorDia.add(relatorio)
		}
		return listaRelatorioPorDia
	}

	def Relatorio contarHoras(Relatorio relatorio){
		List<DateTime> jodaHoras = new ArrayList<>()
		relatorio.pontoBatido.each {
			jodaHoras.add(new DateTime(it.dataEHora))
		}
		Period horasTrabalhadas = new Period(jodaHoras.get(0), jodaHoras.get(1))
		Period horasTrabalhadas2 = new Period(jodaHoras.get(2), jodaHoras.get(3))
		Period horasTotal = horasTrabalhadas+horasTrabalhadas2
		relatorio.setSaldoHoras(horasTotal)
		return relatorio
	}
}
