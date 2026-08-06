import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    JTextField text;
    double num1, num2, result;
    String operator = "";
    public Calculator() {
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        //diplay box
        text = new JTextField();
        text.setFont(new Font("Arial", Font.BOLD, 25));
        text.setHorizontalAlignment(JTextField.RIGHT);
        text.setEditable(false);
        add(text, BorderLayout.NORTH);
        //panel for buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));
        String buttons[] = {
                "7","8","9","/",
                "4","5","6","*",
                "1","2","3","-",
                "C","0","=","+"
        };
        // create buttons
        for(String b : buttons){
            JButton btn = new JButton(b);
            btn.setFont(new Font("Arial", Font.BOLD,20));
            btn.addActionListener(this);
            panel.add(btn);
        }
        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        String value = e.getActionCommand();
        if(value.equals("C")){// clear out
            text.setText("");
            num1 = num2 = result = 0;
            operator = "";
        }//no. and operator
        else if(value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/")){
            num1 = Double.parseDouble(text.getText());
            operator = value;
            text.setText("");
        }//answer calculation
        else if(value.equals("=")){
            num2 = Double.parseDouble(text.getText());
            switch(operator){
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if(num2 != 0)
                        result = num1 / num2;
                    else{
                        text.setText("Error");
                        return;
                    }
            }
            text.setText(String.valueOf(result));
        }
        else{
            text.setText(text.getText() + value); //no. pressed
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}