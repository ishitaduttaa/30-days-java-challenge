import java.awt.*;
import java.awt.event.*;
public class CharacterFrequency extends Frame implements ActionListener {
    TextField input;
    TextArea result;
    Button countButton;
    CharacterFrequency() {
        setTitle("Character Frequency Counter");
        setSize(500, 450); setLayout(null);
        setBackground(new Color(245, 247, 250));
        Label title = new Label("Character Frequency Counter");

        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBounds(90, 50, 350, 40); add(title);

        Label inputLabel = new Label("Enter your text:");
        inputLabel.setFont(new Font("Arial", Font.BOLD, 15));
        inputLabel.setBounds(50, 110, 150, 30); add(inputLabel);
        input = new TextField();
        input.setFont(new Font("Arial", Font.PLAIN, 16));
        input.setBounds(50, 145, 400, 40);
        add(input);
        countButton = new Button("Count Frequency");
        countButton.setFont(new Font("Arial", Font.BOLD, 15));
        countButton.setBounds(160, 200, 180, 45);
        add(countButton);
        Label resultLabel = new Label("Character Frequencies:");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 15));
        resultLabel.setBounds(50, 265, 200, 30);
        add(resultLabel);

        result = new TextArea();
        result.setFont(new Font("Consolas", Font.PLAIN, 15));
        result.setEditable(false);
        result.setBounds(50, 300, 400, 90);
        add(result);
        countButton.addActionListener(this);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }});
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String str = input.getText();
        int[] freq = new int[256];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != ' ') {
                freq[ch]++;
            }}
        result.setText("");
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                result.append((char) i + " = " + freq[i] + "\n");
            }}}
    public static void main(String[] args) {
        new CharacterFrequency();
    }
}