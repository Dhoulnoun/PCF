package interp;

import ast.Term;
import ast.Var;

public class Closure extends Value{

    Term function;
    Env env;
    Var argument;

    public Closure(Term function, Env env, Var argument) {
        this.function = function;
        this.env = env;
        this.argument = argument;
    }

    public Term getFunction() {
        return function;
    }
    public Var getArgument() {
        return argument;
    }
    public Env getEnv() {
        return env;
    }

    public void setEnv(Env env) {
        this.env = env;
    }

    @Override
    public String toString() {
        return "Closure{" +
                "function=" + function +
                ", env=" + env +
                ", argument=" + argument +
                '}';
    }
}
