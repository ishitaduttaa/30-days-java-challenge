import javax.swing.*;
public class Palindrome {
    public static void main(String[] args) {
        JFrame f = new JFrame("Palindrome Checker");
        JLabel l = new JLabel("Enter Text:");
        l.setBounds(50, 50, 100, 30);
        JTextField t = new JTextField();
        t.setBounds(150, 50, 150, 30);
        JButton b = new JButton("Check");
        b.setBounds(120, 100, 100, 30);
        JLabel result = new JLabel();
        result.setBounds(100, 150, 200, 30);
        b.addActionListener(e -> {
            String str = t.getText();
            String rev = "";
            for (int i = str.length() - 1; i >= 0; i--) {
                rev = rev + str.charAt(i);
            }
            if (str.equalsIgnoreCase(rev)) {
                result.setText("Palindrome");
            } else {
                result.setText("Not Palindrome");
            }
        });
        f.add(l);f.add(t);f.add(b);f.add(result);
        f.setSize(350, 250);
        f.setLayout(null);f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}