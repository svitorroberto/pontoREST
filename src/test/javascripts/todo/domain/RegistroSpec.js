describe("todo module", function() {
    var $httpBackend;

    beforeEach(angular.mock.module("todo", function() {
    }));

    beforeEach(angular.mock.inject(function(_$httpBackend_) {
        $httpBackend = _$httpBackend_;
    }));

    afterEach(function() {
        $httpBackend.verifyNoOutstandingExpectation();
        $httpBackend.verifyNoOutstandingRequest();
    });

    describe("Registro domain", function() {

        var Registro;

        beforeEach(angular.mock.inject(function(_Registro_) {
            Registro = _Registro_;
        }));

        it("should be tested", function() {
            expect(true).toEqual(false);
        });

    });

});
