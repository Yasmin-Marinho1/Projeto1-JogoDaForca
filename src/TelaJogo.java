import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;

public class TelaJogo {

	private JFrame frame;
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
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton iniciar = new JButton("Iniciar");
		iniciar.setBounds(10, 11, 86, 23);
		frame.getContentPane().add(iniciar);
		
		JTextField textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setEnabled(false);
		textField.setToolTipText("Digite a letra que quer adivinhar!");
		textField.setBounds(10, 90, 42, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel dica = new JLabel("VAI FICAR A DICA AQUI");
		dica.setVisible(false);
		dica.setBounds(10, 46, 127, 33);
		frame.getContentPane().add(dica);
		
		JLabel resultado = new JLabel("Inicie o jogo!");
		resultado.setBounds(10, 181, 127, 50);
		frame.getContentPane().add(resultado);
		
		
		iniciar.addActionListener(sorteio -> {
			jogo.iniciar();
			textField.setEnabled(true);
			dica.setText(jogo.getDica());
			dica.setVisible(true);
			resultado.setVisible(false);
		});
		
		
		JButton adivinhar = new JButton("Adivinhar");
		adivinhar.setBounds(145, 87, 89, 33);
		frame.getContentPane().add(adivinhar);
		
		JLabel palavra = new JLabel("VAI FICAR A PALAVRA AQUI");
		palavra.setVisible(false);
		palavra.setBounds(10, 119, 127, 33);
		frame.getContentPane().add(palavra);
		

		adivinhar.addActionListener(e ->{
			try {
				String letra = textField.getText();
				textField.setText("");
				textField.requestFocus();
				if (!jogo.getOcorrencias(letra).isEmpty()) {
					resultado.setText("você acertou a letra " + letra.toUpperCase());
					frame.getContentPane().add(resultado);
				} else {
					resultado.setText("você errou a letra " + letra.toUpperCase());
					frame.getContentPane().add(resultado);
				}
				resultado.setVisible(true);
			}
			catch (Exception erro){
				JOptionPane.showMessageDialog(null, erro.getMessage());
			}
			palavra.setText("Palavra: " + jogo.getPalavra());
			palavra.setVisible(true);
			if (!jogo.getResultado().equals("em andamento")) {
				JOptionPane.showMessageDialog(null,  "Você " + jogo.getResultado() + " o jogo!");
				textField.setEnabled(false);
				dica.setVisible(false);
				palavra.setVisible(false);
				resultado.setText("Inicie outro jogo!");
			}
		});



	}
}
