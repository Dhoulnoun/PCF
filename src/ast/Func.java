package ast;

import interp.Env;
import interp.Value;

public class Func extends Term{

    String variable;
    Term function;

    @Override
    public Value interp(Env e) throws Exception {
        return null;
    }
}
