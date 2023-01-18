package typer;

public interface Type {
    // returns the dereferenced value of "this"
    Type deref();
    // unifies "this" and "that", returns true in case of success, false otherwise
    boolean unify(Type that);
}
