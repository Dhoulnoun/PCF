package ast;

import interp.Env;
import interp.Value;
import typer.Type;

public class Var extends Term{

    String varName;

    public Var(String varName) {
        this.varName = varName;
    }

    @Override
    public Value interp(Env<Value> e) throws Exception {
        return e.lookup(varName).orElseThrow(()-> new Exception("Variable not declared"));
    }

    @Override
    public Type typer(Env<Type> e) {
        return e.lookup(varName).orElse(new typer.Var());
    }
}
