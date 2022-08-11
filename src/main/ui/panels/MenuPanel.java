package ui.panels;

import javax.swing.*;
import java.awt.*;

// Represents a MenuPanel
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

    // EFFECTS: make the menu panel
    public MenuPanel() {
        setBackground(new Color(255, 255, 255));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(20, 150));
        makeAddPanel();
        makeRemovePanel();
        loadButton();
        saveButton();
        this.setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: make the addPanel and add the addPanel to this menu panel
    private void makeAddPanel() {
        addPanel = new JPanel();
        this.addButton = new JButton("Add Course");
        this.addButton.setActionCommand("Add");
        JPanel addFieldPanel = (JPanel) createAddFieldPanel();
        addPanel.add(addFieldPanel);
        addPanel.add(this.addButton);
        addPanel.setLayout(new BoxLayout(addPanel, BoxLayout.LINE_AXIS));
        this.add(addPanel);
    }

    // MODIFIES: this
    // EFFECTS: return a addFieldPanel
    //the methods is implemented from ListDemo linked below:
    //https://docs.oracle.com/javase/tutorial/uiswing/examples/components/ListDemoProject/src/components/ListDemo.java
    protected JComponent createAddFieldPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        String[] labelStrings = {"Course's name: ", "Prof's name: ", "Grade(on a scale of 0 to 100): "};
        JLabel[] labels = new JLabel[labelStrings.length];
        JComponent[] fields = new JComponent[labelStrings.length];
        int fieldNum = 0;
        courseNameField1  = new JTextField();
        courseNameField1.setColumns(35);
        fields[fieldNum++] = courseNameField1;
        profNameField = new JTextField();
        profNameField.setColumns(15);
        fields[fieldNum++] = profNameField;
        gradeField = new JTextField();
        gradeField.setColumns(10);
        fields[fieldNum++] = gradeField;
        for (int i = 0; i < labelStrings.length; i++) {
            labels[i] = new JLabel(labelStrings[i], JLabel.TRAILING);
            labels[i].setLabelFor(fields[i]);
            panel.add(labels[i]);
            panel.add(fields[i]);
        }
        return panel;
    }

    // MODIFIES: this
    // EFFECTS: make a removePanel and add the removePanel in this menuPanel
    private void makeRemovePanel() {
        removePanel = new JPanel();
        removeButton = new JButton("Remove Course");
        //courseNameField2 = new JTextField(25);
        removeButton.setActionCommand("Remove");
        JPanel removeFieldPanel = (JPanel) createRemoveFieldPanel();
        removePanel.add(removeFieldPanel);
        removeFieldPanel.add(this.removeButton);
        removePanel.setLayout(new BoxLayout(removePanel, BoxLayout.LINE_AXIS));
        this.add(removePanel);
    }

    // MODIFIES: this
    // EFFECTS: return a removeFieldPanel
    //the methods is implemented from ListDemo linked below:
    //https://docs.oracle.com/javase/tutorial/uiswing/examples/components/ListDemoProject/src/components/ListDemo.java
    protected JComponent createRemoveFieldPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        String[] labelStrings = {"Course's name: "};
        JLabel[] labels = new JLabel[labelStrings.length];
        JComponent[] fields = new JComponent[labelStrings.length];
        int fieldNum = 0;
        courseNameField2  = new JTextField();
        courseNameField2.setColumns(35);
        fields[fieldNum++] = courseNameField2;
        for (int i = 0; i < labelStrings.length; i++) {
            labels[i] = new JLabel(labelStrings[i], JLabel.TRAILING);
            labels[i].setLabelFor(fields[i]);
            panel.add(labels[i]);
            panel.add(fields[i]);
        }
        return panel;
    }

    // MODIFIES: this
    // EFFECTS: make a loadButton and add the loadButton to this panel
    private void loadButton() {
        loadButton = new JButton("Load");
        loadButton.setActionCommand("Load");
        this.add(this.loadButton);
    }

    // MODIFIES: this
    // EFFECTS: make a saveButton and add the saveButton to this panel
    private void saveButton() {
        saveButton = new JButton("Save");
        saveButton.setActionCommand("Save");
        this.add(this.saveButton);
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

}
