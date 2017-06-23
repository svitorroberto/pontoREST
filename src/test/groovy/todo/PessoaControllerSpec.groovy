package todo

import grails.test.mixin.*
import spock.lang.*
import static org.springframework.http.HttpStatus.*

@TestFor(PessoaController)
@Mock(Pessoa)
class PessoaControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null

        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
        assert false, "TODO: Provide a populateValidParams() implementation for this generated test suite"
    }

    void "Test the index action returns the correct response"() {

        when:"The index action is executed"
            controller.index()

        then:"The response is correct"
            response.text == '[]'
    }


    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = JSON_CONTENT_TYPE
            request.method = 'POST'
            def pessoa = new Pessoa()
            pessoa.validate()
            controller.save(pessoa)

        then:"The create view is rendered again with the correct model"
            response.status == UNPROCESSABLE_ENTITY.value()
            response.json.errors

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            pessoa = new Pessoa(params)

            controller.save(pessoa)

        then:"A redirect is issued to the show action"
            Pessoa.count() == 1
            response.status == CREATED.value()
            response.json            
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            response.reset()
            def pessoa= new Pessoa(params).save()
            controller.show(pessoa)

        then:"A model is populated containing the domain instance"
            pessoa!= null
            response.status == OK.value()
            response.json
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = JSON_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.status == NOT_FOUND.value()

        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def pessoa= new Pessoa()
            pessoa.validate()
            controller.update(pessoa)

        then:"The edit view is rendered again with the invalid instance"
            response.status == UNPROCESSABLE_ENTITY.value()
            response.json.errors

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            pessoa= new Pessoa(params).save(flush: true)
            controller.update(pessoa)

        then:"A redirect is issued to the show action"
            pessoa!= null
            response.status == OK.value()
            response.json.id == pessoa.id
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = JSON_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.status == NOT_FOUND.value()


        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def pessoa= new Pessoa(params).save(flush: true)

        then:"It exists"
            Pessoa.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(pessoa)

        then:"The instance is deleted"
            Pessoa.count() == 0
            response.status == NO_CONTENT.value()
            
    }
}