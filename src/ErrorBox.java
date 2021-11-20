import java.awt.Color;
import java.awt.Font;
import java.awt.Window.Type;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextArea;

// custom error dialgue box
//disabled right now

public class ErrorBox {

	private ErrorBox window;
	private JFrame frmError;
	private JTextArea textArea;
	ImageIcon icon = new ImageIcon("Error.png");

	public ErrorBox() {
		initialize();
		frmError.setVisible(true);
	}

	private void initialize() {
		frmError = new JFrame();
		frmError.setResizable(false);
		frmError.getContentPane().setBackground(Color.GRAY);
		frmError.setIconImage(icon.getImage());
		frmError.setTitle(" !!! ERROR !!!");
		frmError.setAlwaysOnTop(true);
		frmError.setType(Type.POPUP);
		frmError.setBounds(100, 100, 333, 144);
		frmError.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmError.getContentPane().setLayout(null);

		textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		textArea.setFont(new Font("Arial", Font.BOLD, 18));
		textArea.setLineWrap(true);
		textArea.setForeground(Color.WHITE);
		textArea.setBackground(Color.GRAY);
		textArea.setBounds(10, 0, 307, 105);
		frmError.getContentPane().add(textArea);
	}

	public void setErrorText(String s) {
		textArea.setText(s);
	}
}
