package interp;

import java.util.Optional;

public class EmptyEnv extends Env {

    public EmptyEnv() {

    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Binding last() {
        throw new RuntimeException("Empty environment has no last binding");
    }

    @Override
    public Env previous() {
        throw new RuntimeException("Empty environment has no previous environment");
    }

    @Override
    public Env add(String id, Value value) {
        return new NonEmptyEnv(new Binding(id, value), this);
    }

    @Override
    public Optional<Value> lookup(String id) {
        return Optional.empty();
    }
}
