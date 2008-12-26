package org.tbatchelli
/**
 * Copyright 2008 Antoni Batchelli
 * Date: Dec 25, 2008
 */

public class BaseState {
    protected String stateName
    protected StateMachine stateMachine

    public BaseState(String stateName, StateMachine stateMachine) {
        this.stateName = stateName
        this.stateMachine = stateMachine
    }

    protected def methodMissing(String name, args) {
        if (name.startsWith("onEvent")) {
            def eventName = (name = ~"onEvent(.*)")[0][1]
            println
            "State $stateName has no handler for event $eventName"
            return this
        } else {
            println
            "The method '$name' does not exist."
            return this
        }
    }

    public onEntry() {
        println
        "Entering state $stateName"
    }

    public onExit() {
        println
        "Exiting state $stateName"
    }

    public getName() {
        return stateName
    }

}