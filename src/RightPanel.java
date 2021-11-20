//import java.awt.SystemColor;
//import java.util.Hashtable;
//
//import javax.swing.JFrame;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.table.DefaultTableModel;
//import java.awt.Font;
//import java.awt.Color;
//import javax.swing.ScrollPaneConstants;
//import javax.swing.border.MatteBorder;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//
//public class RightPanel extends JPanel {
//
//	static RightPanel rightPanel = new RightPanel();
//	LeftPanel leftPanel = LeftPanel.getLeftPanel();
//
//	//DAOStudents DAOStudent = DAOStudents.getDAOStudents();
//
//	private JPanel panel;
//	private JTable table;
//	private DefaultTableModel model;
//	private final Object[] row;
//	private Object[] column = { "Name", "Address", "Gender", "Knowledge", "Subject" };
//
//	static RightPanel getRightPanel() {
//		return rightPanel;
//	}
//
//	private RightPanel() {
//		setLayout(null);
//		panel = new JPanel();
//		panel.setBackground(SystemColor.controlDkShadow);
//		panel.setBounds(0, 0, 650, 400);
//		add(panel);
//		panel.setLayout(null);
//
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
//		scrollPane.setBounds(0, 0, 650, 400);
//		panel.add(scrollPane);
//
//		table = new JTable();
//		table.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				int i = table.getSelectedRow();
//				Hashtable<String, String> data = new Hashtable<String, String>();
//
////				System.out.println(model.getValueAt(i, 0).toString());
////				System.out.println(model.getValueAt(i, 1).toString());
////				System.out.println(model.getValueAt(i, 2).toString());
////				System.out.println(model.getValueAt(i, 3).toString());
////				System.out.println(model.getValueAt(i, 4).toString());
//
//				// leftPanel.setAreaName(model.getValueAt(i, 0).toString());
//
//				data.put("name", model.getValueAt(i, 0).toString());
//				data.put("address", model.getValueAt(i, 1).toString());
//				data.put("gender", model.getValueAt(i, 2).toString());
//				data.put("knowledge", model.getValueAt(i, 3).toString());
//				data.put("subject", model.getValueAt(i, 4).toString());
//
//				 leftPanel.settingForm(data);
//
//			}
//		});
//		table.setBorder(null);
//		table.setGridColor(Color.DARK_GRAY);
//
//		model = new DefaultTableModel();
//		row = new Object[5];
//		model.setColumnIdentifiers(column);
//		table.setModel(model);
//
//		table.setBackground(Color.GRAY);
//		table.setFont(new Font("Arial", Font.BOLD, 12));
//		scrollPane.setViewportView(table);
//
//	}
//
//	void tableAdd(Hashtable<String, String> data) {
//		row[0] = data.get("name");
//		row[1] = data.get("address");
//		row[2] = data.get("gender");
//		row[3] = data.get("knowledge");
//		row[4] = data.get("subject");
//		model.addRow(row);
//	}
//
//	void tableUpdate(Hashtable<String, String> data) {
////		row[0] = data.get("name");
////		row[1] = data.get("address");
////		row[2] = data.get("gender");
////		row[3] = data.get("knowledge");
////		row[4] = data.get("subject");
////		model.addRow(row);
//	}
//
//	void tableDelete() {
//		int i = table.getSelectedRow();
//		if (i >= 0) {
//			model.removeRow(i);
//		} else {
//			JOptionPane.showMessageDialog(null, " No Row Selected !");
//		}
//	}
//
//	// end of the class
//}