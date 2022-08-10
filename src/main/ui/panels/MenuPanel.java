package ui.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {
    private JButton addButton;
    private JButton removeButton;
    private JPanel addPanel;
    private JPanel removePanel;
    private JButton loadButton;
    private JButton saveButton;
    private JTextField courseNameField1;
    private JTextField profNameField;
    private JTextField gradeField;
    private JTextField courseNameField2;
    //private static final int GAP = 10;

    // EFFECTS: make the menu panel
    public MenuPanel() {
        setBackground(new Color(255, 255, 255));
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        setPreferredSize(new Dimension(5, 85));
        makeAddPanel();
        makeRemovePanel();
        loadButton();
        saveButton();
    }

    // MODIFIES: this
    // EFFECTS: make the addPanel and add the addPanel to this menu panel
    private void makeAddPanel() {
        addPanel = new JPanel();
        this.addButton = new JButton("Add Course");
        this.addButton.setActionCommand("Add");
        //addButton.setOpaque(true);
        //addButton.setBackground(new Color(0, 0, 0));
        //addButton.setForeground(new Color(0, 128, 255));
        JPanel addFieldPanel = (JPanel) createAddFieldPanel();
        addPanel.add(addFieldPanel);
        addPanel.add(this.addButton);
        addPanel.setLayout(new BoxLayout(addPanel, BoxLayout.LINE_AXIS));
        //add(this.addPanel);
    }

    // MODIFIES: this
    // EFFECTS: return a addFieldPanel
    protected JComponent createAddFieldPanel() {
        JPanel panel = new JPanel(new SpringLayout());
        String[] labelStrings = {"Course's name: ", "Prof's name: ", "Grade(on a scale of 0 to 100): "};
        JLabel[] labels = new JLabel[labelStrings.length];
        JComponent[] fields = new JComponent[labelStrings.length];
        int fieldNum = 0;
        courseNameField1  = new JTextField();
        courseNameField1.setColumns(20);
        fields[fieldNum++] = courseNameField1;
        profNameField = new JTextField();
        profNameField.setColumns(20);
        fields[fieldNum++] = profNameField;
        gradeField = new JTextField();
        gradeField.setColumns(20);
        fields[fieldNum++] = gradeField;
        for (int i = 0; i < labelStrings.length; i++) {
            labels[i] = new JLabel(labelStrings[i], JLabel.TRAILING);
            labels[i].setLabelFor(fields[i]);
            panel.add(labels[i]);
            panel.add(fields[i]);
            //JTextField tf = (JTextField)fields[i];
            //tf.addActionListener(this);
        }
        return panel;
    }

    // MODIFIES: this
    // EFFECTS: make a removePanel and add the removePanel in this menuPanel
    private void makeRemovePanel() {
        removePanel = new JPanel();
        removeButton = new JButton("Remove Course");
        courseNameField2 = new JTextField(20);
        //removeButton.setOpaque(true);
        //removeButton.setBackground(new Color(0, 0, 0));
        //removeButton.setForeground(new Color(204, 0, 0));
        removeButton.setActionCommand("Remove");
        removePanel.add(courseNameField2);
        removePanel.add(removeButton);
        removePanel.setLayout(new BoxLayout(addPanel, BoxLayout.LINE_AXIS));
        //add(this.removePanel);
    }

    // MODIFIES: this
    // EFFECTS: make a loadButton and add the loadButton to this panel
    private void loadButton() {
        loadButton = new JButton("Load");
        //loadButton.setOpaque(true);
        //comp.setForeground(new Color(0, 204, 0));
        loadButton.setActionCommand("Load");
        //add(this.loadButton);
    }

    // MODIFIES: this
    // EFFECTS: make a saveButton and add the saveButton to this panel
    private void saveButton() {
        saveButton = new JButton("Save");
        //saveButton.setOpaque(true);
        //comp.setForeground(new Color(0, 204, 0));
        saveButton.setActionCommand("Save");
        //add(this.saveButton);
    }

    //EFFECTS: get the addButton
    public JButton getAddButton() {
        return this.addButton;
    }

    //EFFECTS: get the removeButton
    public JButton getRemoveButton() {
        return this.removeButton;
    }

    //EFFECTS: get the loadButton
    public JButton getLoadButton() {
        return this.loadButton;
    }

    //EFFECTS: get the saveButton
    public JButton getSaveButton() {
        return this.saveButton;
    }

    //EFFECTS: get the courseNameField1
    public JTextField getCourseNameField1() {
        return this.courseNameField1;
    }

    //EFFECTS: get the profNameField
    public JTextField getProfNameField() {
        return this.profNameField;
    }

    //EFFECTS: get the gradeField
    public JTextField getGradeField() {
        return this.gradeField;
    }

    //EFFECTS: get the courseNameField2
    public JTextField getCourseNameField2() {
        return this.courseNameField2;
    }

    //@Override
    //public void actionPerformed(ActionEvent e) {

    //}
}
