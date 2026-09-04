import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class MusicPlaylist extends JFrame {
    LinkedList<String> songs = new LinkedList<>();
    JTextField songText;
    DefaultListModel<String> listModel;
    JList<String> songList;

    MusicPlaylist() {
        setTitle("My Music Playlist");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        // Text field and Add button
        songText = new JTextField(20);
        JButton addButton = new JButton("Add Song");
        JPanel topPanel = new JPanel();
        topPanel.add(songText);
        topPanel.add(addButton);
        // List to show songs
        listModel = new DefaultListModel<>();
        songList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(songList);
        // Buttons
        JButton playButton = new JButton("Play");
        JButton removeButton = new JButton("Remove");
        JButton nextButton = new JButton("Next");
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(playButton);
        bottomPanel.add(removeButton);
        bottomPanel.add(nextButton);
        // Add song
        addButton.addActionListener(e -> {
            String song = songText.getText();
            if (!song.isEmpty()) {
                songs.add(song);
                listModel.addElement(song);
                songText.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Enter a song name");}});

        // Play selected song
        playButton.addActionListener(e -> {
            int index = songList.getSelectedIndex();
            if (index != -1) {
                String song = songs.get(index);
                JOptionPane.showMessageDialog(this, "Playing: " + song);
            } else {
                JOptionPane.showMessageDialog(this, "Select a song");
            }});
        // Remove selected song
        removeButton.addActionListener(e -> {
            int index = songList.getSelectedIndex();
            if (index != -1) {
                songs.remove(index);
                listModel.remove(index);
            } else {
                JOptionPane.showMessageDialog(this, "Select a song to remove");
            }});

        // Play next song
        nextButton.addActionListener(e -> {
            int index = songList.getSelectedIndex();
            if (index == -1) {
                if (!songs.isEmpty()) {
                    songList.setSelectedIndex(0);
                    JOptionPane.showMessageDialog(this, "Playing: " + songs.get(0)
                    );}
            } else {
                int next = index + 1;
                if (next < songs.size()) {
                    songList.setSelectedIndex(next);
                    JOptionPane.showMessageDialog(this, "Playing: " + songs.get(next)
                    );
                } else {
                    JOptionPane.showMessageDialog(this, "No more songs");
                }}});
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MusicPlaylist();
    }
}