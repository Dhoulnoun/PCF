package interp;

public class Binding {
    public String name;
    public Value value;

    public Binding(String name, Value value) {
        this.name = name;
        this.value = value;
    }
}
