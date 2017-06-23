describe("todo module", function() {
    var scope;

    beforeEach(angular.mock.module("todo", function() {
    }));

    beforeEach(angular.mock.inject(function($rootScope) {
        scope = $rootScope.$new();
    }));

    describe("RegistroController", function() {

        var ctrl;

        beforeEach(angular.mock.inject(function($controller) {
            ctrl = $controller("RegistroController", {});
        }));

        it("should be tested", function() {
            expect(true).toEqual(false);
        });

    });

});
