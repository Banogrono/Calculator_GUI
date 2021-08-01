public class Counting {

    public static int flag = -1;
    private static String boardContentP1;
    private static String boardContentP2;
    private static double result;

    public static void setBoardContent1(String text) {
        boardContentP1 = text;
    }

    public static void setBoardContent2(String text) {
        boardContentP2 = text;
    }

    public static double getResult() {
        return result;
    }

    static void add(double a, double b) {
        result = 0;
        result = a + b;
    }

    static void subtract(double a, double b) {
        result = 0;
        result = a - b;

    }

    static void multiply(double a, double b) {
        result = 0;
        result = a * b;

    }

    static void divide(double a, double b) {
        if (a == 0 || b == 0) return;
        result = 0;
        result = a / b;

    }

    static void doMath() {
        var a = Double.parseDouble(boardContentP1);
        var b = Double.parseDouble(boardContentP2);
        switch (flag) {
            case 0 -> add(a, b);
            case 1 -> subtract(a, b);
            case 2 -> multiply(a, b);
            case 3 -> divide(a, b);
            default -> System.out.println("Wrong input");
        }
    }
}
