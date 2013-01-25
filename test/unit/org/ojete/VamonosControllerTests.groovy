package org.ojete



import org.junit.*
import grails.test.mixin.*

@TestFor(VamonosController)
@Mock(Vamonos)
class VamonosControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/vamonos/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.vamonosInstanceList.size() == 0
        assert model.vamonosInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.vamonosInstance != null
    }

    void testSave() {
        controller.save()

        assert model.vamonosInstance != null
        assert view == '/vamonos/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/vamonos/show/1'
        assert controller.flash.message != null
        assert Vamonos.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/vamonos/list'

        populateValidParams(params)
        def vamonos = new Vamonos(params)

        assert vamonos.save() != null

        params.id = vamonos.id

        def model = controller.show()

        assert model.vamonosInstance == vamonos
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/vamonos/list'

        populateValidParams(params)
        def vamonos = new Vamonos(params)

        assert vamonos.save() != null

        params.id = vamonos.id

        def model = controller.edit()

        assert model.vamonosInstance == vamonos
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/vamonos/list'

        response.reset()

        populateValidParams(params)
        def vamonos = new Vamonos(params)

        assert vamonos.save() != null

        // test invalid parameters in update
        params.id = vamonos.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/vamonos/edit"
        assert model.vamonosInstance != null

        vamonos.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/vamonos/show/$vamonos.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        vamonos.clearErrors()

        populateValidParams(params)
        params.id = vamonos.id
        params.version = -1
        controller.update()

        assert view == "/vamonos/edit"
        assert model.vamonosInstance != null
        assert model.vamonosInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/vamonos/list'

        response.reset()

        populateValidParams(params)
        def vamonos = new Vamonos(params)

        assert vamonos.save() != null
        assert Vamonos.count() == 1

        params.id = vamonos.id

        controller.delete()

        assert Vamonos.count() == 0
        assert Vamonos.get(vamonos.id) == null
        assert response.redirectedUrl == '/vamonos/list'
    }
}
