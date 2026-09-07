import javax.swing.*;
import java.awt.*;
import java.util.PriorityQueue;

class Task {
    String name;
    int priority;
    Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }
    public String toString() {
        return name + " - Priority: " + priority;
    }
}

public class TaskScheduler extends JFrame {
    JTextField taskField, priorityField;
    JTextArea taskArea;
    PriorityQueue<Task> tasks = new PriorityQueue<>((a, b) -> a.priority - b.priority);
    TaskScheduler() {
        setTitle("Task Scheduler");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        taskField = new JTextField(20);
        priorityField = new JTextField(5);
        JButton addButton = new JButton("Add Task");
        JButton completeButton = new JButton("Complete Task");

        taskArea = new JTextArea(15, 35);
        taskArea.setEditable(false);
        add(new JLabel("Task:"));
        add(taskField);
        add(new JLabel("Priority:"));
        add(priorityField);
        add(addButton);
        add(completeButton);
        add(new JScrollPane(taskArea));

        addButton.addActionListener(e -> {
            String name = taskField.getText();
            int priority = Integer.parseInt(priorityField.getText());

            tasks.add(new Task(name, priority));
            taskField.setText("");
            priorityField.setText("");
            showTasks();
        });

        completeButton.addActionListener(e -> {
            if (tasks.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No tasks available");
                return;
            }
            Task task = tasks.poll();
            JOptionPane.showMessageDialog(this, "Completed: " + task.name);
            showTasks();
        });
        setVisible(true);
    }

    void showTasks() {
        taskArea.setText("");
        for (Task task : tasks) {
            taskArea.append(task + "\n");
        }
    }

    public static void main(String[] args) {
        new TaskScheduler();
    }
}
