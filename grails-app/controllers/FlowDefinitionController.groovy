class FlowDefinitionController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    def allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        if(!params.max) params.max = 10
        [ flowDefinitionList: FlowDefinition.list( params ) ]
    }

    def show = {
        def flowDefinition = FlowDefinition.get( params.id )

        if(!flowDefinition) {
            flash.message = "FlowDefinition not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ flowDefinition : flowDefinition ] }
    }

    def delete = {
        def flowDefinition = FlowDefinition.get( params.id )
        if(flowDefinition) {
            flowDefinition.delete()
            flash.message = "FlowDefinition ${params.id} deleted"
            redirect(action:list)
        }
        else {
            flash.message = "FlowDefinition not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def flowDefinition = FlowDefinition.get( params.id )

        if(!flowDefinition) {
            flash.message = "FlowDefinition not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ flowDefinition : flowDefinition ]
        }
    }

    def update = {
        def flowDefinition = FlowDefinition.get( params.id )
        if(flowDefinition) {
            flowDefinition.properties = params
            if(!flowDefinition.hasErrors() && flowDefinition.save()) {
                flash.message = "FlowDefinition ${params.id} updated"
                redirect(action:show,id:flowDefinition.id)
            }
            else {
                render(view:'edit',model:[flowDefinition:flowDefinition])
            }
        }
        else {
            flash.message = "FlowDefinition not found with id ${params.id}"
            redirect(action:edit,id:params.id)
        }
    }

    def create = {
        def flowDefinition = new FlowDefinition()
        flowDefinition.properties = params
        return ['flowDefinition':flowDefinition]
    }

    def save = {
        def flowDefinition = new FlowDefinition(params)
        if(!flowDefinition.hasErrors() && flowDefinition.save()) {
            flash.message = "FlowDefinition ${flowDefinition.id} created"
            redirect(action:show,id:flowDefinition.id)
        }
        else {
            render(view:'create',model:[flowDefinition:flowDefinition])
        }
    }
}
