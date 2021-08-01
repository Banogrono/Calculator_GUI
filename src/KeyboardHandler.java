import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardHandler implements KeyListener {

    private final StringBuilder textFiledContent;
    private final JTextField outputTextField;
    private boolean isZeroIntended = false;

    public KeyboardHandler(JTextField jTextField) {
        this.outputTextField = jTextField;
        textFiledContent = new StringBuilder();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {

        var key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_1, KeyEvent.VK_NUMPAD1 -> textFiledContent.append("1");
            case KeyEvent.VK_2, KeyEvent.VK_NUMPAD2 -> textFiledContent.append("2");
            case KeyEvent.VK_3, KeyEvent.VK_NUMPAD3 -> textFiledContent.append("3");
            case KeyEvent.VK_4, KeyEvent.VK_NUMPAD4 -> textFiledContent.append("4");
            case KeyEvent.VK_5, KeyEvent.VK_NUMPAD5 -> textFiledContent.append("5");
            case KeyEvent.VK_6, KeyEvent.VK_NUMPAD6 -> textFiledContent.append("6");
            case KeyEvent.VK_7, KeyEvent.VK_NUMPAD7 -> textFiledContent.append("7");
            case KeyEvent.VK_8, KeyEvent.VK_NUMPAD8 -> textFiledContent.append("8");
            case KeyEvent.VK_9, KeyEvent.VK_NUMPAD9 -> textFiledContent.append("9");
            case KeyEvent.VK_0, KeyEvent.VK_NUMPAD0 -> {
                textFiledContent.append("0");
                isZeroIntended = !isZeroIntended;
            }
            case KeyEvent.VK_PERIOD, KeyEvent.VK_COMMA -> {
                var strTextFieldContent = textFiledContent.toString();
                if (strTextFieldContent.contains(".")) return;
                if (strTextFieldContent.trim().equals(""))
                    textFiledContent.append("0");

                textFiledContent.append(".");
                outputTextField.setText(textFiledContent.toString());
            }


            // operations
            case KeyEvent.VK_DIVIDE -> {
                Counting.setBoardContent1(textFiledContent.toString());
                outputTextField.setText(" ");
                textFiledContent.delete(0, textFiledContent.length());
                textFiledContent.append(" ");
                Counting.flag = 3;

            }
            case KeyEvent.VK_MULTIPLY -> {
                Counting.setBoardContent1(textFiledContent.toString());
                outputTextField.setText(" ");
                textFiledContent.delete(0, textFiledContent.length());
                textFiledContent.append(" ");
                Counting.flag = 2;
            }
            case KeyEvent.VK_ADD -> {
                Counting.setBoardContent1(textFiledContent.toString());
                outputTextField.setText(" ");
                textFiledContent.delete(0, textFiledContent.length());
                textFiledContent.append(" ");
                Counting.flag = 0;
            }
            case KeyEvent.VK_SUBTRACT -> {
                var textFieldContent = textFiledContent.toString();
                if (textFieldContent.contains("-")) return;
                if (textFieldContent.trim().equals(""))
                    textFiledContent.append("-");
                else {
                    Counting.setBoardContent1(textFiledContent.toString());
                    outputTextField.setText(" ");
                    textFiledContent.delete(0, textFiledContent.length());
                    textFiledContent.append(" ");
                    Counting.flag = 1;
                }
            }
            case KeyEvent.VK_ENTER -> {
                if (Counting.flag != 4)
                    Counting.setBoardContent2(textFiledContent.toString());

                Counting.doMath();
                textFiledContent.delete(0, textFiledContent.length());

                var result = Counting.getResult();
                if (result % 1 == 0) {
                    outputTextField.setText(Double.toString((int) result));
                    textFiledContent.append((int) result);
                } else {
                    outputTextField.setText(Double.toString(result));
                    textFiledContent.append(result);
                }

                Counting.flag = 4;
            }
            case KeyEvent.VK_BACK_SPACE -> textFiledContent.deleteCharAt(textFiledContent.length() - 1);
        }
        outputTextField.setText(textFiledContent.toString());
    }
}
