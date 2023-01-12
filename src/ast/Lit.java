package ast;

import interp.Env;
import interp.Value;

public class Lit extends Term {
    public int value;

    public Lit(int value) {
        this.value = value;
    }

    @Override
    public Value interp(Env e) throws Exception {
        throw new Exception("Not implemented");
    }
}
