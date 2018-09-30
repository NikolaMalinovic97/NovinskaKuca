package novine;

import javax.swing.JFrame;

public class PretplataFrejm extends JFrame {

	private static final long serialVersionUID = 1L;

	public PretplataFrejm() {
		super("Unos pretplate");
		setVisible(true);
		setResizable(false);
		getContentPane().setLayout(null);
		setBounds(this.getWidth(), this.getHeight(), 300, 300);
	}
}
