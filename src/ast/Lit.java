package ast;

import interp.Env;
import interp.IntVal;
import interp.Value;

public class Lit extends Term {
    public int value;

    public Lit(int value) {
        this.value = value;
    }

    @Override
    public Value interp(Env e) throws Exception {
        return new IntVal(value);
    }
}
