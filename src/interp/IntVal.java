package interp;

public class IntVal extends Value {
    public int valeur;

    public IntVal(int val) {
        this.valeur = val;
    }

    public String toString() {
        return Integer.toString(valeur);
    }
}

