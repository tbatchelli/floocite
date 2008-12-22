/**
 * Copyright 2008 Antoni Batchelli
 * Date: Dec 13, 2008
 */

public class StateMachineTests extends GroovyTestCase{
    void testMethodMissing(){
        StateMachine state = new StateMachine()
        state.someMethod();
        state.onEventMissing1()
        state.onEventSubmit()
        state.onEventMissing2()
        state.onEventFinish()
    }
}