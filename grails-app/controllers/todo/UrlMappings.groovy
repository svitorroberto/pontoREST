package todo

class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?(.$format)?" {
			constraints {
				// apply constraints here
			}
		}
		/*
delete "/$controller/$id(.$format)?"(action: 'delete')
get "/$controller(.$format)?"(action: 'index')
get "/$controller/$id(.$format)?"(action: 'show')
post "/$controller(.$format)?"(action: 'save')
put "/$controller/$id(.$format)?"(action: 'update')
patch "/$controller/$id(.$format)?"(action: 'patch')
		 */

		"/todos"(resources: "todo")
		"/pessoas"(resources: "pessoa")
		"/configuracoes"(resources: "configuracao")

		"/pendingTodos"(controller: 'todo', action: 'pending')
		"/testeRelatorio"(controller: 'relatorio', action: 'listar')

		"/registro/submit"(controller: "test", action: "index")

		"/"(view: 'index')
		"/marcacao"(view: '/marcacao')
		"/relatorio"(view: '/relatorio')
		"/requisicao"(view: '/requisicao')
		"/cadastro"(view: '/cadastro')
		"/configuracao"(view: '/configuracao')


		"/registro/registro"(controller: 'registro', action: "list")
		"500"(view: '/error')
		"404"(view: '/notFound')
	}
}
