import java.util.Stack;

public class JVMCallStackSimulation {

    static Stack<String> callStack = new Stack<>();

    static void callMethod(String name) {
        callStack.push(name);
        printStack("Call " + name);
    }

    static void returnMethod() {
        String name = callStack.pop();
        printStack("Return " + name);
    }

    static void printStack(String action) {
        System.out.println(action);
        System.out.println("Call Stack: " + callStack);
        System.out.println();
    }

    public static void main(String[] args) {

        callMethod("main");
        callMethod("login");
        callMethod("validate");

        returnMethod();
        returnMethod();
        returnMethod();
    }
}
