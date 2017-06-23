//= wrapped

angular
    .module("todo")
    .factory("Pessoa", Pessoa);

function Pessoa($resource) {
    var Pessoa = $resource(
        "pessoas/:id",
        {"id": "@id"},
        {"update": {method: "PUT"}, "list": {method: "GET", isArray: true}}
    );
    return Pessoa;
}
