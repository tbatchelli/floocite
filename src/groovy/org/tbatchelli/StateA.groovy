package org.tbatchelli
/**
 * Copyright 2008 Antoni Batchelli
 * Date: Dec 25, 2008
 */

public class StateA extends BaseState {
    public StateA(String stateName, StateMachine stateMachine) {
        super(stateName, stateMachine)
    }

    public onEventFinish() {
        println "Transitioning to state End"
        return stateMachine.getState("end")
    }
}