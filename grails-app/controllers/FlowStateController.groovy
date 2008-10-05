class FlowStateController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    def allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        if(!params.max) params.max = 10
        [ flowStateList: FlowState.list( params ) ]
    }

    def show = {
        def flowState = FlowState.get( params.id )

        if(!flowState) {
            flash.message = "FlowState not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ flowState : flowState ] }
    }

    def delete = {
        def flowState = FlowState.get( params.id )
        if(flowState) {
            flowState.delete()
            flash.message = "FlowState ${params.id} deleted"
            redirect(action:list)
        }
        else {
            flash.message = "FlowState not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def flowState = FlowState.get( params.id )

        if(!flowState) {
            flash.message = "FlowState not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ flowState : flowState ]
        }
    }

    def update = {
        def flowState = FlowState.get( params.id )
        if(flowState) {
            flowState.properties = params
            if(!flowState.hasErrors() && flowState.save()) {
                flash.message = "FlowState ${params.id} updated"
                redirect(action:show,id:flowState.id)
            }
            else {
                render(view:'edit',model:[flowState:flowState])
            }
        }
        else {
            flash.message = "FlowState not found with id ${params.id}"
            redirect(action:edit,id:params.id)
        }
    }

    def create = {
        def flowState = new FlowState()
        flowState.properties = params
        return ['flowState':flowState]
    }

    def save = {
        def flowState = new FlowState(params)
        if(!flowState.hasErrors() && flowState.save()) {
            flash.message = "FlowState ${flowState.id} created"
            redirect(action:show,id:flowState.id)
        }
        else {
            render(view:'create',model:[flowState:flowState])
        }
    }
}
