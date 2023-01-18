package interp;

import java.util.Optional;

public class NonEmptyEnv<T> extends Env<T> {
    private final Binding<T> last;
    private final Env<T> previous;

    public NonEmptyEnv(Binding last, Env<T> previous) {
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
    public Env<T> previous() {
        return previous;
    }

    @Override
    public Optional<T> lookup(String id) {
           return this.last.getName().equals(id) ? Optional.of(this.last.getValue()) : this.previous().lookup(id);
    }
}
