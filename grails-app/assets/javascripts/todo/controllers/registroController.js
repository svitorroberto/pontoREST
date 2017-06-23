//= wrapped

angular
    .module("todo")
    .controller("RegistroController", RegistroController);

function RegistroController(Registro) {
    var vm = this;

	vm.registros = Registro.list();

	vm.newRegistro = new Registro();

	vm.save = function() {
		vm.newRegistro.$save({}, function() {
			vm.registros.push(angular.copy(vm.newRegistro));
			vm.newRegistro = new Registro();
		});
	};

	vm.registrar = function() {
		vm.newRegistro.$save({}, function() {
			vm.newRegistro.situacao = 1;
			vm.newRegistro.dataEHora = new Date();
			vm.registros.push(angular.copy(vm.newRegistro));
			vm.newRegistro = new Registro();
		});
	}

	vm.delete = function(registro) {
		registro.$delete({}, function() {
			var idx = vm.registros.indexOf(registro);
			vm.registros.splice(idx, 1);
		});
	};

	vm.update = function(registro) {
		registro.$update();
	};
}
