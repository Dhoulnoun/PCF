package ast;

public enum OPLP {
    PLUS, MINUS;

    public static OPLP parseOPLP(String op) {
        return switch (op) {
            case "+" -> PLUS;
            case "-" -> MINUS;
            default          -> throw new IllegalArgumentException("Unexpected operator: " + op);
        };
    }
}
