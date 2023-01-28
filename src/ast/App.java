package ast;

import interp.Closure;
import interp.Env;
import interp.Value;
import typer.Type;
import typer.TypeError;

public class App extends Term{

    private Term execution;
    private Term argument;

    public App(Term execution, Term argument) {
        this.execution = execution;
        this.argument = argument;
    }

    @Override
    public Value interp(Env<Value> e) throws Exception {
        Closure closure = (Closure) execution.interp(e);
        closure.setEnv(closure.getEnv().add(closure.getArgument().varName, this.argument.interp(e)));
        if (closure.getFunction() instanceof Func function) {
            return new Closure(function.getArgument(), function.getFunction(), closure.getEnv());
        }
        return closure.getFunction().interp(closure.getEnv());
    }

    @Override
    public Type typer(Env<Type> e) {
        Type argType = argument.typer(e);
        Type execType = execution.typer(e);
        if(!execType.unify(argType))
            throw new TypeError("Couldn't unify funtion and argument");
        return execution.typer(e).deref();
    }
}
