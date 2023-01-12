package interp;

import java.util.Optional;

public abstract class Env {

    public abstract boolean isEmpty();
    // last() returns the last binding added to the environment
    public abstract Binding last();
    // previous() returns the previous environment
    public abstract Env previous();
    // creates a new environment whose last binding is id = value
    public abstract Env add(String id, Value value);
    // returns the value of id if it exists, hence the use of Optional
    public abstract Optional<Value> lookup(String id);


}
