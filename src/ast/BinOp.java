package ast;

import interp.Env;
import interp.IntVal;
import interp.Value;

public class BinOp extends Term {
    public OP op;
    public Term term1;
    public Term term2;

    public BinOp(OP op, Term term1, Term term2) {
        this.op = op;
        this.term1 = term1;
        this.term2 = term2;
    }

    @Override
    public Value interp(Env e) throws Exception {
        switch (op){
            case PLUS -> {
                return new IntVal((((IntVal) term1.interp(e)).valeur + ((IntVal) term2.interp(e)).valeur));
            }
            case MINUS -> {
                return new IntVal((((IntVal) term1.interp(e)).valeur - ((IntVal) term2.interp(e)).valeur));
            }
            case TIMES -> {
                return new IntVal((((IntVal) term1.interp(e)).valeur * ((IntVal) term2.interp(e)).valeur));
            }
            case DIVIDE -> {
                return new IntVal((((IntVal) term1.interp(e)).valeur / ((IntVal) term2.interp(e)).valeur));
            }
        }
        throw new Exception("OP not recognized");
    }
}
