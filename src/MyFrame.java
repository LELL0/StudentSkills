import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Hashtable;

import javax.swing.*;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

//Author
//Elia El Khoury
//201910274

public class MyFrame extends JFrame implements ActionListener {
//	LeftPanel leftPanel = LeftPanel.getLeftPanel();
//	RightPanel rightPanel = RightPanel.getRightPanel();
/////////////////////////////////////////////////////////
	private JTextField textName, textAddress, textGender, textKnowledge, textSubject;
	private JTextArea areaAddress, areaName;
	private JButton btnSave, btnReset, btnDelete;
	private JCheckBox chckbxJava, chckbxPython;
	private JRadioButton rdbtnFemale, rdbtnMale;
	private ButtonGroup rdbGender;
	private JComboBox comboBoxSubject;
	private int id = 0;
	// private String name, address, gender, subject;
	// private int Knowledge;
	// private JPanel leftPanel;
	private ArrayList<Student> studentData = new ArrayList<Student>();
	private Hashtable<Integer, String> subjects = new Hashtable<Integer, String>();
/////////////////////////////////////////////////////////
	DAOStudents DAOStudent = DAOStudents.getDAOStudent();

	private JPanel rightPanel;
	private JTable table;
	private DefaultTableModel model;
	private final Object[] row;
	private Object[] column = { "Name", "Address", "Gender", "Knowledge", "Subject" };

	private int selectedRow = 0;
	// previous selected row
	private int selectedRow_ = 0;

/////////////////////////////////////////////////////////
	public static void main(String[] args) {

		try {
			MyFrame frame = new MyFrame();
			frame.pack();
			frame.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public MyFrame() {
		//////////////////////////////////////////////////////////////////
		// The LEFT PANEL
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(null);
		// leftPanel.setPreferredSize(new Dimension(350, 190));
		leftPanel.setBackground(SystemColor.controlDkShadow);
		leftPanel.setBounds(0, 0, 345, 400);
		// add(leftPanel);

		// TextFields
		textName = new JTextField();
		textName.setBackground(SystemColor.controlDkShadow);
		textName.setFont(new Font("Arial", Font.BOLD, 14));
		textName.setText("Name");
		textName.setEditable(false);
		textName.setColumns(10);
		textName.setBounds(23, 33, 86, 20);
		textName.setBorder(BorderFactory.createLineBorder(SystemColor.controlDkShadow));
		leftPanel.add(textName);

		textAddress = new JTextField();
		textAddress.setBackground(SystemColor.controlDkShadow);
		textAddress.setFont(new Font("Arial", Font.BOLD, 14));
		textAddress.setText("Address");
		textAddress.setEditable(false);
		textAddress.setColumns(10);
		textAddress.setBounds(23, 82, 86, 20);
		textAddress.setBorder(BorderFactory.createLineBorder(SystemColor.controlDkShadow));
		leftPanel.add(textAddress);

		textGender = new JTextField();
		textGender.setBackground(SystemColor.controlDkShadow);
		textGender.setFont(new Font("Arial", Font.BOLD, 14));
		textGender.setText("Gender");
		textGender.setEditable(false);
		textGender.setColumns(10);
		textGender.setBounds(23, 151, 86, 20);
		textGender.setBorder(BorderFactory.createLineBorder(SystemColor.controlDkShadow));
		leftPanel.add(textGender);

		textKnowledge = new JTextField();
		textKnowledge.setBackground(SystemColor.controlDkShadow);
		textKnowledge.setFont(new Font("Arial", Font.BOLD, 14));
		textKnowledge.setText("Knowledge");
		textKnowledge.setEditable(false);
		textKnowledge.setColumns(10);
		textKnowledge.setBounds(23, 200, 86, 20);
		textKnowledge.setBorder(BorderFactory.createLineBorder(SystemColor.controlDkShadow));
		leftPanel.add(textKnowledge);

		textSubject = new JTextField();
		textSubject.setBackground(SystemColor.controlDkShadow);
		textSubject.setFont(new Font("Arial", Font.BOLD, 14));
		textSubject.setText("Subject");
		textSubject.setEditable(false);
		textSubject.setColumns(10);
		textSubject.setBounds(23, 276, 86, 20);
		textSubject.setBorder(BorderFactory.createLineBorder(SystemColor.controlDkShadow));
		leftPanel.add(textSubject);

		// buttons
		btnSave = new JButton("Save");
		btnSave.setBackground(new Color(153, 153, 153));
		btnSave.addActionListener(this);
		btnSave.setFont(new Font("Arial", Font.BOLD, 12));
		btnSave.setBounds(19, 345, 89, 23);
		btnSave.setBorder(BorderFactory.createLineBorder(SystemColor.controlDkShadow));
		leftPanel.add(btnSave);

		btnReset = new JButton("Reset");
		btnReset.setBackground(new Color(153, 153, 153));
		btnReset.addActionListener(this);
		btnReset.setFont(new Font("Arial", Font.BOLD, 12));
		btnReset.setBounds(127, 345, 89, 23);
		btnReset.setBorder(BorderFactory.createLineBorder(SystemColor.controlDkShadow));
		leftPanel.add(btnReset);

		btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Arial", Font.BOLD, 12));
		btnDelete.addActionListener(this);
		btnDelete.setBorder(BorderFactory.createLineBorder(SystemColor.controlDkShadow));
		btnDelete.setBackground(new Color(153, 153, 153));
		btnDelete.setBounds(235, 345, 89, 23);
		leftPanel.add(btnDelete);

		// TextAreas
		areaName = new JTextArea();
		areaName.setFont(new Font("Arial", Font.PLAIN, 14));
		areaName.setBackground(new Color(153, 153, 153));
		areaName.setBounds(148, 33, 161, 20);
		leftPanel.add(areaName);

		areaAddress = new JTextArea();
		areaAddress.setFont(new Font("Arial", Font.PLAIN, 14));
		areaAddress.setBackground(new Color(153, 153, 153));
		areaAddress.setBounds(148, 82, 161, 20);
		leftPanel.add(areaAddress);

		// Radio Buttons
		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBackground(SystemColor.controlDkShadow);
		rdbtnMale.setFont(new Font("Arial", Font.BOLD, 11));
		rdbtnMale.setBounds(150, 150, 60, 23);
		leftPanel.add(rdbtnMale);

		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBackground(SystemColor.controlDkShadow);
		rdbtnFemale.setFont(new Font("Arial", Font.BOLD, 11));
		rdbtnFemale.setBounds(235, 151, 75, 20);
		leftPanel.add(rdbtnFemale);

		rdbGender = new ButtonGroup();
		rdbGender.add(rdbtnMale);
		rdbGender.add(rdbtnFemale);

		// CheckBoxes
		chckbxJava = new JCheckBox("Java");
		chckbxJava.setBackground(SystemColor.controlDkShadow);
		chckbxJava.setFont(new Font("Arial", Font.BOLD, 11));
		chckbxJava.setBounds(150, 199, 60, 23);
		leftPanel.add(chckbxJava);

		chckbxPython = new JCheckBox("Python");
		chckbxPython.setBackground(SystemColor.controlDkShadow);
		chckbxPython.setFont(new Font("Arial", Font.BOLD, 11));
		chckbxPython.setBounds(235, 200, 75, 20);
		leftPanel.add(chckbxPython);

		// ComboBox
		comboBoxSubject = new JComboBox();
		comboBoxSubject.setFont(new Font("Arial", Font.BOLD, 12));
		comboBoxSubject.setBackground(new Color(153, 153, 153));
		comboBoxSubject.setModel(
				new DefaultComboBoxModel(new String[] { "select a subject", "Cyber Security", "Artificial intelligence",
						"Big Data", "Data Science", "Software Engineering", "Network Administration" }));
		comboBoxSubject.setBounds(129, 276, 180, 20);
		comboBoxSubject.setBorder(BorderFactory.createLineBorder(SystemColor.controlDkShadow));
		leftPanel.add(comboBoxSubject);

		textName.setBorder(BorderFactory.createLineBorder(SystemColor.controlDkShadow));

		// setting up the array
		subjects.put(0, "select a subject");
		subjects.put(1, "Cyber Security");
		subjects.put(2, "Artificial intelligence");
		subjects.put(3, "Big Data");
		subjects.put(4, "Data Science");
		subjects.put(5, "Software Engineering");
		subjects.put(6, "Network Administration");

		//////////////////////////////////////////////////////////////////
		rightPanel = new JPanel();
		rightPanel.setBackground(SystemColor.controlDkShadow);
		rightPanel.setBounds(0, 0, 650, 400);
		// add(rightPanel);
		rightPanel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, 650, 400);
		rightPanel.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Hashtable<String, String> data = new Hashtable<String, String>();

//				System.out.println(model.getValueAt(table.getSelectedRow(), 0).toString());
//				System.out.println(model.getValueAt(table.getSelectedRow(), 1).toString());
//				System.out.println(model.getValueAt(table.getSelectedRow(), 2).toString());
//				System.out.println(model.getValueAt(table.getSelectedRow(), 3).toString());
//				System.out.println(model.getValueAt(table.getSelectedRow(), 4).toString());

				// leftPanel.setAreaName(model.getValueAt(i, 0).toString());
				selectedRow = table.getSelectedRow();

				// clear the selection
				// table.clearSelection();
				/////////////////////////////////////////////////////////////////
				data.put("name", model.getValueAt(selectedRow, 0).toString());
				data.put("address", model.getValueAt(selectedRow, 1).toString());
				data.put("gender", model.getValueAt(selectedRow, 2).toString());
				data.put("knowledge", model.getValueAt(selectedRow, 3).toString());
				data.put("subject", model.getValueAt(selectedRow, 4).toString());

				// if (selectedRow == selectedRow_) {

				Student stu = new Student(studentData.get(selectedRow).getId(),
						model.getValueAt(selectedRow, 0).toString(), model.getValueAt(selectedRow, 1).toString(),
						model.getValueAt(selectedRow, 2).toString(), model.getValueAt(selectedRow, 3).toString(),
						model.getValueAt(selectedRow, 4).toString());

				// tableUpdate(stu);
				// DAOStudent.updateStudent(stu);

				String error = checkIfValidStu(stu);

				if (!error.isEmpty() && selectedRow == selectedRow_) {
					JOptionPane.showMessageDialog(null, error);
					String knowledge = "";
					if (chckbxJava.isSelected()) {
						knowledge = "Java";
					}
					if (chckbxPython.isSelected()) {
						if (knowledge.equals("Java")) {
							knowledge += " and Python";
						} else {
							knowledge = "Python";
						}
					}

					// setting a value for gender
					String gender = "";
					if (rdbtnMale.isSelected()) {
						gender = "Male";
					}
					if (rdbtnFemale.isSelected()) {
						gender = "Female";

					}
					Student stuForm = new Student(id, areaName.getText(), areaAddress.getText(), gender, knowledge,
							(String) comboBoxSubject.getSelectedItem());

					tableUpdate(stuForm);
				} else if (selectedRow == selectedRow_) {

					// System.out.println("updating");
					DAOStudent.updateStudent(stu);
					// updating array
					studentData.set(selectedRow, stu);
					settingForm(data);
				} else {
					// setting the form only
					// System.out.println("SETING THE FORM ONLY");
					settingForm(data);
				}

//				} else {
//					
//				
//				}

				selectedRow_ = selectedRow;
			}
		});
		table.setBorder(null);
		table.setGridColor(Color.DARK_GRAY);

		model = new DefaultTableModel();
		row = new Object[5];
		model.setColumnIdentifiers(column);
		table.setModel(model);

		table.setBackground(Color.GRAY);
		table.setFont(new Font("Arial", Font.BOLD, 12));
		scrollPane.setViewportView(table);

		//////////////////////////////////////////////////////////////////
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("student.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.35);
		getContentPane().add(splitPane, BorderLayout.CENTER);

		splitPane.setLeftComponent(leftPanel);
		splitPane.setRightComponent(rightPanel);
		splitPane.setPreferredSize(new Dimension(1000, 400));

		////// setup the array and table data //////
		firstSetup();
		// System.out.println("after first setup: " + id);
	}

//////////////////////////////////////////////////////
	// Right FONCTIONS
	void tableAdd(Student stu) {
//		row[0] = data.get("name");
//		row[1] = data.get("address");
//		row[2] = data.get("gender");
//		row[3] = data.get("knowledge");
//		row[4] = data.get("subject");

		row[0] = stu.getName();
		row[1] = stu.getAddress();
		row[2] = stu.getGender();
		row[3] = stu.getKnowledge();
		row[4] = stu.getSubject();

		model.addRow(row);
	}

	void tableUpdate(Student stu) {
		int i = table.getSelectedRow();
//		model.setValueAt(data.get("name"), i, 0);
//		model.setValueAt(data.get("address"), i, 1);
//		model.setValueAt(data.get("gender"), i, 2);
//		model.setValueAt(data.get("knowledge"), i, 3);
//		model.setValueAt(data.get("subject"), i, 4);

		model.setValueAt(stu.getName(), i, 0);
		model.setValueAt(stu.getAddress(), i, 1);
		model.setValueAt(stu.getGender(), i, 2);
		model.setValueAt(stu.getKnowledge(), i, 3);
		model.setValueAt(stu.getSubject(), i, 4);

	}

	void tableDelete() {
		int i = table.getSelectedRow();
		if (i >= 0) {
			model.removeRow(i);
		} else {
			JOptionPane.showMessageDialog(null, " No Row Selected !");
		}
	}

//////////////////////////////////////////////////////
	// Left FUNCTIONS
	public void resetForm() {
		areaAddress.setText("");
		areaName.setText("");
		chckbxJava.setSelected(false);
		chckbxPython.setSelected(false);
		rdbGender.clearSelection();
		comboBoxSubject.setSelectedIndex(0);
	}

//	public void setAreaName(String s) {
//		areaName.setText(s);
//	}

	public void settingForm(Hashtable<String, String> dataToForm) {

		areaName.setText(dataToForm.get("name"));
		areaAddress.setText(dataToForm.get("address"));

		// setting the checkbox value
		if (dataToForm.get("knowledge").equals("Java")) {
			chckbxJava.setSelected(true);
			chckbxPython.setSelected(false);
		} else if (dataToForm.get("knowledge").equals("Java and Python")) {
			chckbxJava.setSelected(true);
			chckbxPython.setSelected(true);
		} else if (dataToForm.get("knowledge").equals("Python")) {
			chckbxJava.setSelected(false);
			chckbxPython.setSelected(true);
		}

		// setting the radio button value
		if (dataToForm.get("gender").equals("Female")) {
			rdbtnFemale.setSelected(true);
		} else if (dataToForm.get("gender").equals("Male")) {
			rdbtnMale.setSelected(true);
		}

		int index = 0;
		while (!subjects.get(index).equals((String) dataToForm.get("subject"))) {
			index += 1;
			// System.out.println(dataToForm.get("subject") + index);
		}
		comboBoxSubject.setSelectedIndex(index);

	}

//	// might delete later
//	public void settingData() {
//		name = areaName.getText();
//		address = areaAddress.getText();
//
//		if (chckbxJava.isSelected()) {
//			Knowledge += 1;
//		}
//
//		if (chckbxPython.isSelected()) {
//			Knowledge += 2;
//		}
//
//		if (rdbtnMale.isSelected()) {
//			gender = "male";
//		}
//
//		if (rdbtnFemale.isSelected()) {
//			gender = "female";
//		}
//
//		subject = (String) comboBoxSubject.getSelectedItem();
//	}

	public static boolean containDigit(String str) {
		int n = str.length();
		for (int i = 0; i < n; i++) {
			if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				return true;
			}
		}
		return false;
	}

	public String checkIfValid() {
		String error = "";
		if (containDigit(areaName.getText().trim())) {
			error += "⨠your name cannot contain digits\n";
		}

		if (areaName.getText().trim().isEmpty()) {
			error += "⨠you need to enter your name\n";
		}

		if (areaAddress.getText().trim().isEmpty()) {
			error += "⨠you need to enter your address\n";
		}

		if ((String) comboBoxSubject.getSelectedItem() == "select a subject") {
			error += "⨠your need to choose a knowledge\n";
		}

		return error;

	}

	public String checkIfValidStu(Student stu) {
		String error = "";

		if (containDigit(stu.getName().trim())) {
			error += "⨠your name cannot contain digits\n";
		}

		if (stu.getName().trim().isEmpty()) {
			error += "⨠you need to enter your name\n";
		}

		if (stu.getAddress().trim().isEmpty()) {
			error += "⨠you need to enter your address\n";
		}

		if (!(stu.getSubject().equals(subjects.get(0)) || stu.getSubject().equals(subjects.get(1))
				|| stu.getSubject().equals(subjects.get(2)) || stu.getSubject().equals(subjects.get(3))
				|| stu.getSubject().equals(subjects.get(4)) || stu.getSubject().equals(subjects.get(5))
				|| stu.getSubject().equals(subjects.get(6)))) {

			error += "⨠Invalid knowledge\n";
		}

		if (!(stu.getGender().equals("Male") || stu.getGender().equals("Female"))) {
			error += "⨠Invalid Gender\n";
		}

		if (!(stu.getKnowledge().equals("Java") || stu.getKnowledge().equals("Python")
				|| stu.getKnowledge().equals("Java and Python"))) {
			error += "⨠Invalid Knowledge\n";
		}

		return error;
	}

	public void firstSetup() {
		// set database values to the array
		studentData = DAOStudent.getAllStudents();

		// display the whole array
		for (int j = 0; j < studentData.size(); j++) {
			tableAdd(studentData.get(j));
		}
		id = DAOStudent.getMaxId();
		// System.out.println("IN FIRST SETUP: " + id);
	}

//	public void settingTable() {
//
//	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnReset) {
			resetForm();
			table.clearSelection();
		}

		if (e.getSource() == btnSave) {
			String error = checkIfValid();

			if (!error.isEmpty()) {

				JOptionPane.showMessageDialog(null, error);

				// custom dialogue box

//				 ErrorBox errorBox = new ErrorBox();
//				 errorBox.setErrorText("!!! ERROR !!!\n" + error);

			} else {
				// setting a value for knowledge
				String knowledge = "";
				if (chckbxJava.isSelected()) {
					knowledge = "Java";
				}
				if (chckbxPython.isSelected()) {
					if (knowledge.equals("Java")) {
						knowledge += " and Python";
					} else {
						knowledge = "Python";
					}
				}

				// setting a value for gender
				String gender = "";
				if (rdbtnMale.isSelected()) {
					gender = "Male";
				}
				if (rdbtnFemale.isSelected()) {
					gender = "Female";

				}

				// putting dataToForm in a class to send them

//				data.put("name", areaName.getText());
//				data.put("address", areaAddress.getText());
//				data.put("gender", gender);
//				data.put("knowledge", knowledge);
//				data.put("subject", (String) comboBoxSubject.getSelectedItem());

				if (table.getSelectedRow() < 0) {
					id += 1;
					Student stu = new Student(id, areaName.getText(), areaAddress.getText(), gender, knowledge,
							(String) comboBoxSubject.getSelectedItem());
					tableAdd(stu);
					DAOStudent.insertStudent(stu);

					// inserting into array
					studentData.add(stu);
				} else {
					id = studentData.get(selectedRow).getId();
					Student stu = new Student(id, areaName.getText(), areaAddress.getText(), gender, knowledge,
							(String) comboBoxSubject.getSelectedItem());

					tableUpdate(stu);
					DAOStudent.updateStudent(stu);

					// updating array
					studentData.set(selectedRow, stu);

				}
//				try {
//					daoStudents.insertAuthor(data);
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}

				// resetting form
				// TO ENABLE
				resetForm();
				table.clearSelection();
			}
		}

		if (e.getSource() == btnDelete) {
			// DELETE DATA
			tableDelete();

			// System.out.println("deleting id: " + studentData.get(selectedRow).getId());

			DAOStudent.DeleteStudent(studentData.get(selectedRow).getId());

			// removing from array
			studentData.remove(selectedRow);

			// resetting form
			// TO ENABLE
			resetForm();
			table.clearSelection();
		}
	}
}
