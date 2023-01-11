package ast;

public enum OPHP {
    TIMES, DIVIDE;

    public static OPHP parseOPHP(String op) {
        return switch (op) {
            case "*" -> TIMES;
            case "/" -> DIVIDE;
            default          -> throw new IllegalArgumentException("Unexpected operator: " + op);
        };
    }
}
