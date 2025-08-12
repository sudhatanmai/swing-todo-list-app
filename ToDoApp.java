import javax.swing.*;

public class ToDoApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("To-Do");
            DefaultListModel<String> model = new DefaultListModel<>();
            JList<String> list = new JList<>(model);
            JTextField field = new JTextField(15);
            JButton add = new JButton("Add");
            JButton del = new JButton("Delete");

            JPanel top = new JPanel();
            top.add(field); top.add(add); top.add(del);

            frame.add(top, java.awt.BorderLayout.NORTH);
            frame.add(new JScrollPane(list), java.awt.BorderLayout.CENTER);

            add.addActionListener(e -> {
                String t = field.getText().trim();
                if (!t.isEmpty()) { model.addElement(t); field.setText(""); }
            });

            del.addActionListener(e -> {
                int i = list.getSelectedIndex();
                if (i != -1) model.remove(i);
                else JOptionPane.showMessageDialog(frame, "Select a task first.");
            });

            frame.setSize(360, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
