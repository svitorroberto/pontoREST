//= wrapped

angular
    .module("todo")
    .factory("Registro", Registro);

function Registro($resource) {
    var Registro = $resource(
        "registro/:id",
        {"id": "@id"},
        {"update": {method: "PUT"}, "list": {method: "GET", isArray: true}}
    );
    return Registro;
}
