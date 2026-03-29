import java.awt.EventQueue;

import javax.swing.JFrame;

public class TelaJogo {

	private JFrame frame;
	private String letraDigitada;
	private JogoDaForca jogo = new JogoDaForca();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaJogo window = new TelaJogo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaJogo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Jogo da Forca");
		frame.setResizable(false);
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 11));
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	}
}
