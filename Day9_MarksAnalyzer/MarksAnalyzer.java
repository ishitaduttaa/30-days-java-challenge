import java.awt.*;
import java.awt.event.*;

public class MarksAnalyzer extends Frame {
    TextField t1, t2, t3, t4, t5;
    Label result;
    MarksAnalyzer() {
        setTitle("Marks Analyzer");
        setSize(400, 400);
        setLayout(new GridLayout(7, 2));
        add(new Label("Subject 1:"));
        t1 = new TextField();
        add(t1);
        add(new Label("Subject 2:"));
        t2 = new TextField();
        add(t2);
        add(new Label("Subject 3:"));
        t3 = new TextField();
        add(t3);
        add(new Label("Subject 4:"));
        t4 = new TextField();
        add(t4);
        add(new Label("Subject 5:"));
        t5 = new TextField();
        add(t5);
        Button button = new Button("Analyze");
        add(button);
        result = new Label("Result");
        add(result);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int total = Integer.parseInt(t1.getText()) + Integer.parseInt(t2.getText()) + Integer.parseInt(t3.getText()) + Integer.parseInt(t4.getText()) + Integer.parseInt(t5.getText());
                double average = total / 5.0;
                result.setText("Total: " + total + " Average: " + average);
            }});setVisible(true);
    }
    public static void main(String[] args) {
        new MarksAnalyzer();
    }
}