package ast;

import interp.Closure;
import interp.Env;
import interp.Value;
import typer.Arrow;
import typer.Type;

public class Func extends Term{

    VarUse argument;
    Term function;

    public Func(VarUse variable, Term function) {
        this.argument = variable;
        this.function = function;
    }

    @Override
    public Value interp(Env<Value> e) throws Exception {
        return new Closure(function, e, argument);
    }

    @Override
    public Type typer(Env<Type> e) {
        return new Arrow(argument.typer(e).deref(), function.typer(e).deref()).deref();
    }
}
