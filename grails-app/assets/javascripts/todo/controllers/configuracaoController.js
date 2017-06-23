//= wrapped

angular
    .module("todo")
    .controller("ConfiguracaoController", ConfiguracaoController);

function ConfiguracaoController(Configuracao) {
    var vm = this;

    vm.configuracoes = Configuracao.list();

    vm.newConfiguracao = new Configuracao();

    vm.save = function() {
        vm.newConfiguracao.$save({}, function() {
            vm.configuracaos.push(angular.copy(vm.newConfiguracao));
            vm.newConfiguracao = new Configuracao();
        });
    };

    vm.delete = function(configuracao) {
        configuracao.$delete({}, function() {
            var idx = vm.configuracaos.indexOf(configuracao);
            vm.configuracaos.splice(idx, 1);
        });
    };

    vm.update = function(configuracao) {
        configuracao.$update();
    };
}
