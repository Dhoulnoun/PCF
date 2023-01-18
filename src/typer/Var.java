package typer;

import java.util.Optional;
// TODO: deal with IDE alerts
// TODO: improve with switch expressions
// TODO: add variable names
public class Var implements Type {
    Optional<Type> binding;

    public static boolean occurCheck(Var x, Type a) {
        boolean result = occurCheck_(x, a);
        if (!result)
            System.out.println(x + " occurs in " + a);
        return result;
    }
    private static boolean occurCheck_(Var x, Type t) {
        Type deref_t = t.deref();
        if (deref_t instanceof Atom)
            return true;
        else if (deref_t instanceof Arrow arrow) { // a -> b
            return occurCheck(x, arrow.a) && occurCheck(x, arrow.b);
        } else { // this is an unbound variable
            if (deref_t == x)
                return false;
            else {
                Optional<Type> binding = ((Var) deref_t).binding;
                return binding.map(type -> occurCheck(x, type)).orElse(true);
            }
        }
    }
    public Var(){
        binding = Optional.empty();
    }
    @Override
    public Type deref() {
        if (binding.isEmpty()) // unbound variable
            return this;
        else // retrieve binding
            return binding.get().deref();
    }

    @Override
    public boolean unify(Type that) {
        Type t1 = this.deref();
        Type t2 = that.deref();
        if (t1 instanceof Atom) {
            if (t2 instanceof Atom) {
                return (t1 == t2);
            } else if (t2 instanceof Var v2) { // t2 is a variable
                v2.binding = Optional.of(t1);
                return true;
            } else
                return false;
        } else if (t1 instanceof Arrow arrow1) {
            if (t2 instanceof Arrow arrow2)
                return (arrow1.a.unify(arrow2.a) &&
                        arrow1.b.unify(arrow2.b));
            else if (t2 instanceof Var v2) {
                if (occurCheck(v2, t1)) {
                    v2.binding = Optional.of(t1);
                    return true;
                } else
                    return false;
            } else
                return false;
        } else { // t1 is a variable
            // the following case (two identical unbound variables) can be avoided
            // by implementing unbound variables as self-references
            // otherwise if this case is forgotten, cycles are created,
            // which result in infinite dereferencing
            if (t2 instanceof Var && t1 == t2)
                return true;
            else if (occurCheck((Var)t1, t2)) {
                ((Var)t1).binding = Optional.of(t2);
                return true;
            } else
                return false;
        }
    }
    @Override
    public String toString() {
        if (binding.isEmpty())
            return super.toString();
        else
            return binding.get().toString();
    }
}
