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

    public VarUse getArgument() {
        return this.argument;
    }

    public Term getFunction() {
        return this.function;
    }

    @Override
    public Value interp(Env<Value> e) throws Exception {
        return new Closure(argument, function, e);
    }

    @Override
    public Type typer(Env<Type> e) {
        return new Arrow(argument.typer(e).deref(), function.typer(e).deref()).deref();
    }
}
