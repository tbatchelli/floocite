/**
 * Copyright 2008 Antoni Batchelli
 * Date: Dec 13, 2008
 */

/**
 * TODO:
 *  - The states should know nothing about the state machine... they should just return the next state
 *  - Look into who spring webflow works
 *  - Think about how this state machine would be operated in terms of named transitions... for example... commit(), withdraw(), etc...
 */

public class StateMachine {
    BaseState currentState
    private String name = ""
    private BaseState[] states = [new StateStart('start', this), new StateA('A', this), new StateEnd('end', this)]
    private nameStateMap=[:]
    public StateMachine(){
        currentState=states[0]
        for( state in states){
            nameStateMap[state.name]=state
        }
    }
    public getState(String stateName){
        return nameStateMap[stateName]
    }
    def methodMissing(String name, args) {
        if (name.startsWith("transitionTo")) {
            currentState.onExit()
            def nextState=currentState.invokeMethod(name,args)
            if(nextState)
                currentState=nextState
            currentState.onEntry()
        } else {
            println "The method '$name' does not exist."
        }
    }
}

public class BaseState {
    protected String stateName
    protected StateMachine stateMachine
    public BaseState(String stateName, StateMachine stateMachine) {
        this.stateName = stateName
        this.stateMachine = stateMachine
    }
    protected def methodMissing(String name, args) {
        if (name.startsWith("transitionTo")) {
            def destinationState = (name =~ "transitionTo(.*)")[0][1]
            println "There is no such transition to state $destinationState"
            return this
        } else {
            println "The method '$name' does not exist."
            return this
        }
    }
    public onEntry(){
        println "Entering state $stateName"
    }
    public onExit(){
        println "Exiting state $stateName"
    }
    public getName(){
        return stateName
    }

}

public class StateA extends BaseState{
    public StateA(String stateName, StateMachine stateMachine){
        super(stateName, stateMachine)
    }
    public transitionToEnd(){
        println "Transitioning to state End"
        return stateMachine.getState("end")
    }
}

public class StateEnd extends BaseState{
    public StateEnd(String stateName, StateMachine stateMachine){
        super(stateName, stateMachine)
    }
}

public class StateStart extends BaseState{
    public StateStart(String stateName, StateMachine stateMachine){
        super(stateName, stateMachine)
    }
    public transitionToA(){
        println "Transitioning to state A";
        return stateMachine.getState("A")
    }


}