class FlowController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    def allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        if(!params.max) params.max = 10
        [ flowList: Flow.list( params ) ]
    }

    def show = {
        def flow = Flow.get( params.id )

        if(!flow) {
            flash.message = "Flow not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ flow : flow ] }
    }

    def delete = {
        def flow = Flow.get( params.id )
        if(flow) {
            flow.delete()
            flash.message = "Flow ${params.id} deleted"
            redirect(action:list)
        }
        else {
            flash.message = "Flow not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def flow = Flow.get( params.id )

        if(!flow) {
            flash.message = "Flow not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ flow : flow ]
        }
    }

    def update = {
        def flow = Flow.get( params.id )
        if(flow) {
            flow.properties = params
            if(!flow.hasErrors() && flow.save()) {
                flash.message = "Flow ${params.id} updated"
                redirect(action:show,id:flow.id)
            }
            else {
                render(view:'edit',model:[flow:flow])
            }
        }
        else {
            flash.message = "Flow not found with id ${params.id}"
            redirect(action:edit,id:params.id)
        }
    }

    def create = {
        def flow = new Flow()
        flow.properties = params
        return ['flow':flow]
    }

    def save = {
        def flow = new Flow(params)
        if(!flow.hasErrors() && flow.save()) {
            flash.message = "Flow ${flow.id} created"
            redirect(action:show,id:flow.id)
        }
        else {
            render(view:'create',model:[flow:flow])
        }
    }
}
