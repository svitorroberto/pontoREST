//= wrapped

angular
    .module("todo")
    .factory("Configuracao", Configuracao);

function Configuracao($resource) {
    var Configuracao = $resource(
        "configuracoes/:id",
        {"id": "@id"},
        {"update": {method: "PUT"}, "list": {method: "GET", isArray: true}}
    );
    return Configuracao;
}
