package org.tbatchelli
/**
 * Copyright 2008 Antoni Batchelli
 * Date: Dec 25, 2008
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
    private nameStateMap = [:]

    public StateMachine() {
        currentState = states[0]
        for (state in states) {
            nameStateMap[state.name] = state
        }
    }

    public getState(String stateName) {
        return nameStateMap[stateName]
    }

    def methodMissing(String name, args) {
        if (name.startsWith("onEvent")) {
            currentState.onExit()
            def nextState = currentState.invokeMethod(name, args)
            if (nextState)
                currentState = nextState
            currentState.onEntry()
        } else {
            println "State $currentState.name has no method named '$name'."
        }
    }
}