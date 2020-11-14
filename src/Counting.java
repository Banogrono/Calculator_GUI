
public class Counting {

    private static String boardContentP1;

    public static int flag = -1;

    public static void setBoardContent1(String text) {
        boardContentP1 = text;
    }

    private static String boardContentP2;
    public static void setBoardContent2(String text) {
        boardContentP2 = text;
    }

    private static double result;

    public static double getResult() {
        return result;
    }

    static void add() {
        double a = Double.parseDouble(boardContentP1);
        double b = Double.parseDouble(boardContentP2);
        result = 0;
        result = a + b;

    }

    static void subtract() {
        double a = Double.parseDouble(boardContentP1);
        double b = Double.parseDouble(boardContentP2);
        result = 0;
        result = a - b;

    }

    static void multiply() {
        double a = Double.parseDouble(boardContentP1);
        double b = Double.parseDouble(boardContentP2);
        result = 0;
        result = a * b;

    }

    static void divide() {
        double a = Double.parseDouble(boardContentP1);
        double b = Double.parseDouble(boardContentP2);
        result = 0;
        result = a / b;

    }

    static void doMath() {
        switch (flag) {
            case 0: { // Add
                add();
                break;
            }
            case 1: { // Sub
                subtract();
                break;
            }
            case 2: { // Mult
                multiply();
                break;
            }
            case 3: { // Div
                divide();
                break;
            }
            default: { // Wrong type
                System.out.println("Wrong input");
                break;
            }
        }
    }


}
