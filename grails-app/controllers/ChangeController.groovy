class ChangeController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    def allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        if(!params.max) params.max = 10
        [ changeList: Change.list( params ) ]
    }

    def show = {
        def change = Change.get( params.id )

        if(!change) {
            flash.message = "Change not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ change : change ] }
    }

    def delete = {
        def change = Change.get( params.id )
        if(change) {
            change.delete()
            flash.message = "Change ${params.id} deleted"
            redirect(action:list)
        }
        else {
            flash.message = "Change not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def change = Change.get( params.id )

        if(!change) {
            flash.message = "Change not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ change : change ]
        }
    }

    def update = {
        def change = Change.get( params.id )
        if(change) {
            change.properties = params
            if(!change.hasErrors() && change.save()) {
                flash.message = "Change ${params.id} updated"
                redirect(action:show,id:change.id)
            }
            else {
                render(view:'edit',model:[change:change])
            }
        }
        else {
            flash.message = "Change not found with id ${params.id}"
            redirect(action:edit,id:params.id)
        }
    }

    def create = {
        def change = new Change()
        change.properties = params
        return ['change':change]
    }

    def save = {
        def change = new Change(params)
        if(!change.hasErrors() && change.save()) {
            flash.message = "Change ${change.id} created"
            redirect(action:show,id:change.id)
        }
        else {
            render(view:'create',model:[change:change])
        }
    }
}
