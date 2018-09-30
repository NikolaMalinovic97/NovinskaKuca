package novine;

import javax.swing.JFrame;

public class IzdanjeFrejm extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public IzdanjeFrejm() {
		super("Unos izdanja");
		setVisible(true);
		setResizable(false);
		getContentPane().setLayout(null);
		setBounds(this.getWidth(), this.getHeight(), 300, 300);
	}

}
