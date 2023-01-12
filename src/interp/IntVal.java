package interp;

public class IntVal extends Value {
    public int i;

    public IntVal(int i) {
        this.i = i;
    }

    public String toString() {
        return Integer.toString(i);
    }
}

