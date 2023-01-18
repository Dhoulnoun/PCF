package typer;

import java.util.Optional;

public enum Atom implements Type {
    BOOL, // for illustration, not defined in PCF
    INT;

    @Override
    public Type deref() {
        return this;
    }

    @Override
    public boolean unify(Type that) {
        Type deref_that = that.deref();
        // deref_that is an atom, a variable, or an arrow
        if (deref_that instanceof Atom) {
            return this == deref_that;
        } else if (deref_that instanceof Var) {
            // bind the variable to the atom
            ((Var) deref_that).binding = Optional.of(this);
            return true;
        } else return false;
    }
}
