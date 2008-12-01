import grails.converters.JSON
import org.grails.plugins.springsecurity.controller.AuthBase

class TicketController extends AuthBase {

    def index = { redirect(action: list, params: params) }

    // the delete, save and update actions only accept POST requests
    def allowedMethods = [delete: 'POST', save: 'POST', update: 'POST']

    def list = {
        if (!params.max) params.max = 10
        [ticketList: Ticket.list(params)]
    }

    def show = {
        def ticket = Ticket.get(params.id)

        if (!ticket) {
            flash.message = "Ticket not found with id ${params.id}"
            redirect(action: list)
        }
        else { return [ticket: ticket] }
    }

    def delete = {
        def ticket = Ticket.get(params.id)
        if (ticket) {
            ticket.delete()
            flash.message = "Ticket ${params.id} deleted"
            redirect(action: list)
        }
        else {
            flash.message = "Ticket not found with id ${params.id}"
            redirect(action: list)
        }
    }

    def edit = {
        def ticket = Ticket.get(params.id)

        if (!ticket) {
            flash.message = "Ticket not found with id ${params.id}"
            redirect(action: list)
        }
        else {
            return [ticket: ticket]
        }
    }

    def update = {
        def ticket = Ticket.get(params.id)
        if (ticket) {
            ticket.properties = params
            if (!ticket.hasErrors() && ticket.save()) {
                flash.message = "Ticket ${params.id} updated"
                redirect(action: show, id: ticket.id)
            }
            else {
                render(view: 'edit', model: [ticket: ticket])
            }
        }
        else {
            flash.message = "Ticket not found with id ${params.id}"
            redirect(action: edit, id: params.id)
        }
    }

    def create = {
        def ticket = new Ticket()
        ticket.properties = params
        return ['ticket': ticket]
    }

    def save = {
        def ticket = new Ticket(params)
        if (!ticket.hasErrors() && ticket.save()) {
            flash.message = "Ticket ${ticket.id} created"
            redirect(action: show, id: ticket.id)
        }
        else {
            render(view: 'create', model: [ticket: ticket])
        }
    }

    def dataTableJSON = {
        def tickets = Ticket.list(params)
        def data = [totalRecords: Ticket.count(), results: tickets]
        render data as JSON
    }
}
