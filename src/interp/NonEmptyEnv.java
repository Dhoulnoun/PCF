package interp;

import java.util.Optional;

public class NonEmptyEnv extends Env {
    private final Binding last;
    private final Env previous;

    public NonEmptyEnv(Binding last, Env previous) {
        this.last = last;
        this.previous = previous;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Binding last() {
        return last;
    }

    @Override
    public Env previous() {
        return previous;
    }

    @Override
    public Env add(String id, Value value) {
        return new NonEmptyEnv(new Binding(id, value), this);
    }

    @Override
    public Optional<Value> lookup(String id) {
        if (last.name.equals(id)) {
            return Optional.of(last.value);
        } else {
            return previous.lookup(id);
        }
    }
}
