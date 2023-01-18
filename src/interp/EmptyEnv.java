package interp;

import java.util.Optional;

public class EmptyEnv<T> extends Env<T> {

    public EmptyEnv() {

    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Binding<T> last() {
        throw new RuntimeException("Empty environment has no last binding");
    }

    @Override
    public Env<T> previous() {
        throw new RuntimeException("Empty environment has no previous environment");
    }

    @Override
    public Optional<T> lookup(String id) {
        return Optional.empty();
    }
}
