package org.tbatchelli
/**
 * Copyright 2008 Antoni Batchelli
 * Date: Dec 25, 2008
 */


public class StateStart extends BaseState {

    public StateStart(String stateName, StateMachine stateMachine) {
        super(stateName, stateMachine)
    }

    public onEventSubmit() {
        println "Transitioning to state A";
        return stateMachine.getState("A")
    }


}