package org.ojete

class VamonosController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [vamonosInstanceList: Vamonos.list(params), vamonosInstanceTotal: Vamonos.count()]
    }

    def create = {
        def vamonosInstance = new Vamonos()
        vamonosInstance.properties = params
        return [vamonosInstance: vamonosInstance]
    }

    def save = {
        def vamonosInstance = new Vamonos(params)
        if (vamonosInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'vamonos.label', default: 'Vamonos'), vamonosInstance.id])}"
            redirect(action: "show", id: vamonosInstance.id)
        }
        else {
            render(view: "create", model: [vamonosInstance: vamonosInstance])
        }
    }

    def show = {
        def vamonosInstance = Vamonos.get(params.id)
        if (!vamonosInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'vamonos.label', default: 'Vamonos'), params.id])}"
            redirect(action: "list")
        }
        else {
            [vamonosInstance: vamonosInstance]
        }
    }

    def edit = {
        def vamonosInstance = Vamonos.get(params.id)
        if (!vamonosInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'vamonos.label', default: 'Vamonos'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [vamonosInstance: vamonosInstance]
        }
    }

    def update = {
        def vamonosInstance = Vamonos.get(params.id)
        if (vamonosInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (vamonosInstance.version > version) {
                    
                    vamonosInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'vamonos.label', default: 'Vamonos')] as Object[], "Another user has updated this Vamonos while you were editing")
                    render(view: "edit", model: [vamonosInstance: vamonosInstance])
                    return
                }
            }
            vamonosInstance.properties = params
            if (!vamonosInstance.hasErrors() && vamonosInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'vamonos.label', default: 'Vamonos'), vamonosInstance.id])}"
                redirect(action: "show", id: vamonosInstance.id)
            }
            else {
                render(view: "edit", model: [vamonosInstance: vamonosInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'vamonos.label', default: 'Vamonos'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def vamonosInstance = Vamonos.get(params.id)
        if (vamonosInstance) {
            try {
                vamonosInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'vamonos.label', default: 'Vamonos'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'vamonos.label', default: 'Vamonos'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'vamonos.label', default: 'Vamonos'), params.id])}"
            redirect(action: "list")
        }
    }
}
