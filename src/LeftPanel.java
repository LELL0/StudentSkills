//import java.awt.Color;
//import java.awt.Font;
//import java.awt.SystemColor;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.sql.SQLException;
//import java.util.Hashtable;
//
//import javax.swing.BorderFactory;
//import javax.swing.ButtonGroup;
//import javax.swing.DefaultComboBoxModel;
//import javax.swing.JButton;
//import javax.swing.JCheckBox;
//import javax.swing.JComboBox;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JRadioButton;
//import javax.swing.JTextArea;
//import javax.swing.JTextField;
//
//public class LeftPanel extends JPanel implements ActionListener {
//	static LeftPanel leftPanel = new LeftPanel();
//
//	//DAOStudents daoStudents = DAOStudents.getDAOStudents();
//
//	RightPanel rightPanel = RightPanel.getRightPanel();
//
//	private JTextField textName, textAddress, textGender, textKnowledge, textSubject;
//	private JTextArea areaAddress, areaName;
//	private JButton btnSave, btnReset, btnDelete;
//	private JCheckBox chckbxJava, chckbxPython;
//	private JRadioButton rdbtnFemale, rdbtnMale;
//	private ButtonGroup rdbGender;
//	private JComboBox comboBoxSubject;
//	private String name, address, gender, subject;
//	private int Knowledge;
//	private JPanel panel;
//
//	private Hashtable<String, String> data = new Hashtable<String, String>();
//	private Hashtable<Integer, String> subjects = new Hashtable<Integer, String>();
//
//	public static LeftPanel getLeftPanel() {
//		return leftPanel;
//	}
//
//	/**
//	 * Create the panel.
//	 */
//	private LeftPanel() {
//		setLayout(null);
//		// The PANEL
//		JPanel panel = new JPanel();
//		panel.setLayout(null);
//		// panel.setPreferredSize(new Dimension(350, 190));
//		panel.setBackground(SystemColor.controlDkShadow);
//		panel.setBounds(0, 0, 345, 400);
//		add(panel);
//
//		// TextFields
//		textName = new JTextField();
//		textName.setBackground(SystemColor.controlDkShadow);
//		textName.setFont(new Font("Arial", Font.BOLD, 14));
//		textName.setText("Name:");
//		textName.setEditable(false);
//		textName.setColumns(10);
//		textName.setBounds(23, 33, 86, 20);
//		textName.setBorder(BorderFactory.createLineBorder(SystemColor.controlDkShadow));
//		panel.add(textName);
//
//		textAddress = new JTextField();
//		textAddress.setBackground(SystemColor.controlDkShadow);
//		textAddress.setFont(new Font("Arial", Font.BOLD, 14));
//		textAddress.setText("Address");
//		textAddress.setEditable(false);
//		textAddress.setColumns(10);
//		textAddress.setBounds(23, 82, 86, 20);
//		textAddress.setBorder(BorderFactory.createLineBorder(SystemColor.controlDkShadow));
//		panel.add(textAddress);
//
//		textGender = new JTextField();
//		textGender.setBackground(SystemColor.controlDkShadow);
//		textGender.setFont(new Font("Arial", Font.BOLD, 14));
//		textGender.setText("Gender");
//		textGender.setEditable(false);
//		textGender.setColumns(10);
//		textGender.setBounds(23, 151, 86, 20);
//		textGender.setBorder(BorderFactory.createLineBorder(SystemColor.controlDkShadow));
//		panel.add(textGender);
//
//		textKnowledge = new JTextField();
//		textKnowledge.setBackground(SystemColor.controlDkShadow);
//		textKnowledge.setFont(new Font("Arial", Font.BOLD, 14));
//		textKnowledge.setText("Knowledge");
//		textKnowledge.setEditable(false);
//		textKnowledge.setColumns(10);
//		textKnowledge.setBounds(23, 200, 86, 20);
//		textKnowledge.setBorder(BorderFactory.createLineBorder(SystemColor.controlDkShadow));
//		panel.add(textKnowledge);
//
//		textSubject = new JTextField();
//		textSubject.setBackground(SystemColor.controlDkShadow);
//		textSubject.setFont(new Font("Arial", Font.BOLD, 14));
//		textSubject.setText("Subject");
//		textSubject.setEditable(false);
//		textSubject.setColumns(10);
//		textSubject.setBounds(23, 276, 86, 20);
//		textSubject.setBorder(BorderFactory.createLineBorder(SystemColor.controlDkShadow));
//		panel.add(textSubject);
//
//		// buttons
//		btnSave = new JButton("Save");
//		btnSave.setBackground(new Color(153, 153, 153));
//		btnSave.addActionListener(this);
//		btnSave.setFont(new Font("Arial", Font.BOLD, 12));
//		btnSave.setBounds(19, 345, 89, 23);
//		btnSave.setBorder(BorderFactory.createLineBorder(SystemColor.controlDkShadow));
//		panel.add(btnSave);
//
//		btnReset = new JButton("Reset");
//		btnReset.setBackground(new Color(153, 153, 153));
//		btnReset.addActionListener(this);
//		btnReset.setFont(new Font("Arial", Font.BOLD, 12));
//		btnReset.setBounds(127, 345, 89, 23);
//		btnReset.setBorder(BorderFactory.createLineBorder(SystemColor.controlDkShadow));
//		panel.add(btnReset);
//
//		btnDelete = new JButton("Delete");
//		btnDelete.setFont(new Font("Arial", Font.BOLD, 12));
//		btnDelete.addActionListener(this);
//		btnDelete.setBorder(BorderFactory.createLineBorder(SystemColor.controlDkShadow));
//		btnDelete.setBackground(new Color(153, 153, 153));
//		btnDelete.setBounds(235, 345, 89, 23);
//		panel.add(btnDelete);
//
//		// TextAreas
//		areaName = new JTextArea();
//		areaName.setFont(new Font("Arial", Font.PLAIN, 14));
//		areaName.setBackground(new Color(153, 153, 153));
//		areaName.setBounds(148, 33, 161, 20);
//		panel.add(areaName);
//
//		areaAddress = new JTextArea();
//		areaAddress.setFont(new Font("Arial", Font.PLAIN, 14));
//		areaAddress.setBackground(new Color(153, 153, 153));
//		areaAddress.setBounds(148, 82, 161, 20);
//		panel.add(areaAddress);
//
//		// Radio Buttons
//		rdbtnMale = new JRadioButton("Male");
//		rdbtnMale.setBackground(SystemColor.controlDkShadow);
//		rdbtnMale.setFont(new Font("Arial", Font.BOLD, 11));
//		rdbtnMale.setBounds(150, 150, 60, 23);
//		panel.add(rdbtnMale);
//
//		rdbtnFemale = new JRadioButton("Female");
//		rdbtnFemale.setBackground(SystemColor.controlDkShadow);
//		rdbtnFemale.setFont(new Font("Arial", Font.BOLD, 11));
//		rdbtnFemale.setBounds(235, 151, 75, 20);
//		panel.add(rdbtnFemale);
//
//		rdbGender = new ButtonGroup();
//		rdbGender.add(rdbtnMale);
//		rdbGender.add(rdbtnFemale);
//
//		// CheckBoxes
//		chckbxJava = new JCheckBox("Java");
//		chckbxJava.setBackground(SystemColor.controlDkShadow);
//		chckbxJava.setFont(new Font("Arial", Font.BOLD, 11));
//		chckbxJava.setBounds(150, 199, 60, 23);
//		panel.add(chckbxJava);
//
//		chckbxPython = new JCheckBox("Python");
//		chckbxPython.setBackground(SystemColor.controlDkShadow);
//		chckbxPython.setFont(new Font("Arial", Font.BOLD, 11));
//		chckbxPython.setBounds(235, 200, 75, 20);
//		panel.add(chckbxPython);
//
//		// ComboBox
//		comboBoxSubject = new JComboBox();
//		comboBoxSubject.setFont(new Font("Arial", Font.BOLD, 12));
//		comboBoxSubject.setBackground(new Color(153, 153, 153));
//		comboBoxSubject.setModel(
//				new DefaultComboBoxModel(new String[] { "select a subject", "Cyber Security", "Artificial intelligence",
//						"Data Science", "Big Data", "Software Engineering", "Network Administration" }));
//		comboBoxSubject.setBounds(129, 276, 180, 20);
//		comboBoxSubject.setBorder(BorderFactory.createLineBorder(SystemColor.controlDkShadow));
//		panel.add(comboBoxSubject);
//
//		textName.setBorder(BorderFactory.createLineBorder(SystemColor.controlDkShadow));
//
//		// setting up the array
//		subjects.put(0, "select a subject");
//		subjects.put(1, "Cyber Security");
//		subjects.put(2, "Artificial intelligence");
//		subjects.put(3, "Data Science");
//		subjects.put(4, "Software Engineering");
//		subjects.put(5, "Network Administration");
//
//	}
//
//	public void resetForm() {
//		areaAddress.setText("");
//		areaName.setText("");
//		chckbxJava.setSelected(false);
//		chckbxPython.setSelected(false);
//		rdbGender.clearSelection();
//		comboBoxSubject.setSelectedIndex(0);
//	}
//
//	public void setAreaName(String s) {
//		areaName.setText(s);
//	}
//
//	public void settingForm(Hashtable<String, String> dataToForm) {
//		new Thread(new Runnable() {
//			@Override
//			synchronized public void run() {
//				System.out.println("check 2");
//
//				areaName.setText(dataToForm.get("name"));
//				areaAddress.setText(dataToForm.get("address"));
//
//				// setting the checkbox value
//				if (dataToForm.get("knowledge") == "Java") {
//					chckbxJava.setSelected(true);
//					chckbxPython.setSelected(false);
//				} else if (dataToForm.get("knowledge") == "Java and Python") {
//					chckbxJava.setSelected(true);
//					chckbxPython.setSelected(true);
//				} else if (dataToForm.get("knowledge") == "Python") {
//					chckbxJava.setSelected(false);
//					chckbxPython.setSelected(true);
//				}
//
//				// setting the radio button value
//				if (dataToForm.get("gender") == "Female") {
//					rdbtnFemale.setSelected(true);
//				} else if (dataToForm.get("gender") == "Male") {
//					rdbtnMale.setSelected(true);
//				}
//
//				System.out.println("check3");
//
//				int index = 0;
//				for (int j = 0; j <= 5; j++) {
//					if (subjects.get(j) == dataToForm.get("Subject")) {
//						index = j;
//					}
//				}
//				comboBoxSubject.setSelectedIndex(index);
//			}
//		}).start();
//	}
//
////	// might delete later
////	public void settingData() {
////		name = areaName.getText();
////		address = areaAddress.getText();
////
////		if (chckbxJava.isSelected()) {
////			Knowledge += 1;
////		}
////
////		if (chckbxPython.isSelected()) {
////			Knowledge += 2;
////		}
////
////		if (rdbtnMale.isSelected()) {
////			gender = "male";
////		}
////
////		if (rdbtnFemale.isSelected()) {
////			gender = "female";
////		}
////
////		subject = (String) comboBoxSubject.getSelectedItem();
////	}
//
//	public static boolean containDigit(String str) {
//		int n = str.length();
//		for (int i = 0; i < n; i++) {
//			if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
//				return true;
//			}
//		}
//		return false;
//	}
//
//	public String checkIfValid() {
//		String error = "";
//		if (containDigit(areaName.getText().trim())) {
//			error += "⨠your name cannot contain digits\n";
//		}
//
//		if (areaName.getText().trim().isEmpty()) {
//			error += "⨠you need to enter your name\n";
//		}
//
//		if (areaAddress.getText().trim().isEmpty()) {
//			error += "⨠you need to enter your address\n";
//		}
//
//		if ((String) comboBoxSubject.getSelectedItem() == "select a subject") {
//			error += "⨠your need to choose a knowledge\n";
//		}
//
//		return error;
//
//	}
//
//	public void actionPerformed(ActionEvent e) {
//		if (e.getSource() == btnReset) {
//			resetForm();
//		}
//
//		if (e.getSource() == btnSave) {
//			String error = checkIfValid();
//
//			if (!error.isEmpty()) {
//
//				JOptionPane.showMessageDialog(null, error);
//
//				// custom dialogue box
//
////				 ErrorBox errorBox = new ErrorBox();
////				 errorBox.setErrorText("!!! ERROR !!!\n" + error);
//
//			} else {
//				// setting a value for knowledge
//				String knowledge = "";
//				if (chckbxJava.isSelected()) {
//					knowledge = "Java";
//				}
//				if (chckbxPython.isSelected()) {
//					if (knowledge == "Java") {
//						knowledge += " and Python";
//					} else {
//						knowledge = "Python";
//					}
//				}
//
//				// setting a value for gender
//				String gender = "";
//				if (rdbtnMale.isSelected()) {
//					gender = "Male";
//				}
//				if (rdbtnFemale.isSelected()) {
//					gender = "Female";
//
//				}
//
//				// putting dataToForm in a array to send them
//				data.put("name", areaName.getText());
//				data.put("address", areaAddress.getText());
//				data.put("gender", gender);
//				data.put("knowledge", knowledge);
//				data.put("subject", (String) comboBoxSubject.getSelectedItem());
//
//				rightPanel.tableAdd(data);
//
////				try {
////					daoStudents.insertAuthor(data);
////				} catch (SQLException e1) {
////					// TODO Auto-generated catch block
////					e1.printStackTrace();
////				}
//
//				// resetting form
//				resetForm();
//			}
//		}
//
//		if (e.getSource() == btnDelete) {
//			// DELETE DATA
//			rightPanel.tableDelete();
//		}
//	}
//}