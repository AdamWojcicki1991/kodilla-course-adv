package com.kodilla.agent.exercise;

import net.bytebuddy.asm.Advice;

public class MyMethodMonitor {
    @Advice.OnMethodEnter
    public static void enter(@Advice.Origin Class clazz, @Advice.Origin("#m") String methodName) {
        System.out.println("User Agent caught invocation of method: " + methodName);
    }

    @Advice.OnMethodExit
    public static void exit() {
        System.out.println("Exiting method job done.");
    }
}
