import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Window extends JFrame {

    // ===========> Look & Feel <==================

        Color bg_dark_gray = new Color(24,25,19);
        Color bg_gray = new Color(45,45,45);
        Color bg_highlight = new Color(60,60,60);
        Color fg_white = new Color(237,237,237);

        Font font = new Font("Consolas", Font.PLAIN,48);

    // =============================================

    public Window() {

        super("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);
        //setLayout();
        setVisible(true);

        initComponents();

    }

    private void initComponents() {

        // ====> Backbone panel <====================================
        // Holds every other component

        var backPanel = new JPanel();
        backPanel.setBackground(bg_dark_gray);
        backPanel.setLayout(new BorderLayout());
        add(backPanel);

        // ====> Output panel <=======================================
        // Holds output text field

        var outputPanel = new JPanel();
        outputPanel.setBackground(bg_gray);
        outputPanel.setLayout(new GridLayout(1,1));
        outputPanel.setSize(500,100);
        backPanel.add(outputPanel, BorderLayout.NORTH);

        // ====> Button panel <========================================
        // Holds buttons

        var buttonPanel = new JPanel();
        buttonPanel.setBackground(bg_dark_gray);
        buttonPanel.setLayout(new GridLayout(4,4,3,3));
        backPanel.add(buttonPanel,BorderLayout.CENTER);

        // ====> Output text field <==================================

        StringBuilder curretnTextFieldContent = new StringBuilder();
        curretnTextFieldContent.append(" ");

        var outputTextField = new JTextField();
        outputTextField.setText(curretnTextFieldContent.toString());
        outputTextField.setForeground(fg_white);
        outputTextField.setBackground(bg_gray);
        outputTextField.setFont(font);
        outputTextField.setSize(490,50);
        outputTextField.setBorder(BorderFactory.createEtchedBorder(0));
        outputPanel.add(outputTextField);

        // ====> Buttons <===========================================

        JButton [] buttons = new JButton[16];

        for (int i = 15; i >= 0 ; i--) {
            buttons[i] = new JButton();

            int finalI1 = i;
            buttons[i].addMouseListener(new MouseAdapter() {  // highlighting button
                @Override
                public void mouseEntered(MouseEvent e) {
                    buttons[finalI1].setBackground(bg_highlight);
                }
            });
            buttons[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseExited(MouseEvent e) {
                    buttons[finalI1].setBackground(bg_gray);
                }
            });

            buttons[i].setBackground(bg_gray);
            buttons[i].setForeground(fg_white);
            buttons[i].setFont(font);
            buttons[i].setBorder(BorderFactory.createEtchedBorder(0)); // button border
            buttonPanel.add(buttons[i]);
        }

        // row 1
        buttons[15].setText("9");
        buttons[14].setText("8");
        buttons[13].setText("7");
        buttons[12].setText("+");
        // row 2
        buttons[11].setText("4");
        buttons[10].setText("5");
        buttons[9].setText("6");
        buttons[8].setText("-");
        // row 3
        buttons[7].setText("1");
        buttons[6].setText("2");
        buttons[5].setText("3");
        buttons[4].setText("x");
        // row 4
        buttons[3].setText("0");
        buttons[2].setText(".");
        buttons[1].setText("=");
        buttons[0].setText("/");

        // =====================

        buttons[15].addActionListener(e -> {
                    curretnTextFieldContent.append(9);
                    outputTextField.setText(curretnTextFieldContent.toString());
                }
                );

        buttons[15].addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == 105 || e.getKeyCode() == 57) {
                    curretnTextFieldContent.append(9);
                    outputTextField.setText(curretnTextFieldContent.toString());
                }
            }
        });

        buttons[14].addActionListener(e -> {
                    curretnTextFieldContent.append(8);
                    outputTextField.setText(curretnTextFieldContent.toString());
                }
        );
        buttons[13].addActionListener(e -> {
                    curretnTextFieldContent.append(7);
                    outputTextField.setText(curretnTextFieldContent.toString());
                }
        );
        buttons[12].addActionListener(e -> { // Add
                    Counting.setBoardContent1(curretnTextFieldContent.toString());
                    outputTextField.setText(" ");
                    curretnTextFieldContent.delete(0,curretnTextFieldContent.length());
                    curretnTextFieldContent.append(" ");
                    Counting.flag = 0;
                }
        );

        // ---------------------------------------------------------------------
        buttons[11].addActionListener(e -> {
                    curretnTextFieldContent.append(4);
                    outputTextField.setText(curretnTextFieldContent.toString());
                }
        );
        buttons[10].addActionListener(e -> {
                    curretnTextFieldContent.append(5);
                    outputTextField.setText(curretnTextFieldContent.toString());
                }
        );
        buttons[9].addActionListener(e -> {
                    curretnTextFieldContent.append(6);
                    outputTextField.setText(curretnTextFieldContent.toString());
                }
        );
        buttons[8].addActionListener(e -> { // sub
                    Counting.setBoardContent1(curretnTextFieldContent.toString());
                    outputTextField.setText(" ");
                    curretnTextFieldContent.delete(0,curretnTextFieldContent.length());
                    curretnTextFieldContent.append(" ");
                    Counting.flag = 1;
                }
        );

        // ---------------------------------------------------------------------
        buttons[7].addActionListener(e -> {
                    curretnTextFieldContent.append(1);
                    outputTextField.setText(curretnTextFieldContent.toString());
                }
        );
        buttons[6].addActionListener(e -> {
                    curretnTextFieldContent.append(2);
                    outputTextField.setText(curretnTextFieldContent.toString());
                }
        );
        buttons[5].addActionListener(e -> {
                    curretnTextFieldContent.append(3);
                    outputTextField.setText(curretnTextFieldContent.toString());
                }
        );
        buttons[4].addActionListener(e -> { // mult
                Counting.setBoardContent1(curretnTextFieldContent.toString());
                outputTextField.setText(" ");
                curretnTextFieldContent.delete(0,curretnTextFieldContent.length());
                curretnTextFieldContent.append(" ");
                Counting.flag = 2;
                }
        );

        // ---------------------------------------------------------------------
        buttons[3].addActionListener(e -> {
                    curretnTextFieldContent.append(0);
                    outputTextField.setText(curretnTextFieldContent.toString());
                }
        );
        buttons[2].addActionListener(e -> {
                    curretnTextFieldContent.append(".");
                    outputTextField.setText(curretnTextFieldContent.toString());
                }
        );
        buttons[1].addActionListener(e -> { // equals
                if (Counting.flag != 4)
                    Counting.setBoardContent2(curretnTextFieldContent.toString());

                Counting.doMath();
                curretnTextFieldContent.delete(0,curretnTextFieldContent.length());
                outputTextField.setText(Double.toString(Counting.getResult()));
                curretnTextFieldContent.append(Counting.getResult());
                Counting.flag = 4;
                }
        );
        buttons[0].addActionListener(e -> { // div
                Counting.setBoardContent1(curretnTextFieldContent.toString());
                outputTextField.setText(" ");
                curretnTextFieldContent.delete(0,curretnTextFieldContent.length());
                curretnTextFieldContent.append(" ");
                Counting.flag = 3;
                }
        );





    }



}
