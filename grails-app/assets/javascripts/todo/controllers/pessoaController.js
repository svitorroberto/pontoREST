//= wrapped

angular
    .module("todo")
    .controller("PessoaController", PessoaController);

function PessoaController(Pessoa) {
    var vm = this;

    vm.pessoas = Pessoa.list();

    vm.newPessoa = new Pessoa();

    vm.save = function() {
        vm.newPessoa.$save({}, function() {
            vm.pessoas.push(angular.copy(vm.newPessoa));
            vm.newPessoa = new Pessoa();
        });
    };

    vm.delete = function(pessoa) {
        pessoa.$delete({}, function() {
            var idx = vm.pessoas.indexOf(pessoa);
            vm.pessoas.splice(idx, 1);
        });
    };

    vm.update = function(pessoa) {
        pessoa.$update();
    };
}
