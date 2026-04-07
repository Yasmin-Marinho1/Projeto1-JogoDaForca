import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TelaJogo {

	private JFrame frame;
	private JButton buttonIniciar;
	private JLabel labelLetra;
	private JTextField textField;
	private JLabel labelDica;
	private JLabel labelResultado;
	private JButton buttonAdivinhar;
	private JLabel labelPalavra;
	private String letraDigitada;
	private JLabel labelAcertos;
	private JLabel labelPenalidades;
	private JLabel labelImagem;
	private JTextArea textAreaHistorico;
	private JScrollPane scrollPane;
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
		frame.setBounds(100, 100, 450, 300);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 11));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		buttonIniciar = new JButton("Iniciar");
		buttonIniciar.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonIniciar.setBounds(10, 12, 86, 24);
		frame.getContentPane().add(buttonIniciar);
		
		labelLetra = new JLabel("Letra:");
		labelLetra.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelLetra.setBounds(10, 80, 52, 24);
		frame.getContentPane().add(labelLetra);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setEnabled(false);
		textField.setToolTipText("Digite apenas uma letra!");
		textField.setBounds(51, 80, 52, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		labelDica = new JLabel("Dica: ");
		labelDica.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelDica.setVisible(false);
		labelDica.setBounds(10, 46, 301, 24);
		frame.getContentPane().add(labelDica);
		
		labelResultado = new JLabel("Inicie o jogo!");
		labelResultado.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelResultado.setBounds(10, 141, 232, 24);
		frame.getContentPane().add(labelResultado);
		
		buttonAdivinhar = new JButton("Adivinhar");
		buttonAdivinhar.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonAdivinhar.setBounds(113, 80, 96, 24);
		buttonAdivinhar.setEnabled(false);
		frame.getContentPane().add(buttonAdivinhar);
		
		labelPalavra = new JLabel("Palavra: ");
		labelPalavra.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelPalavra.setVisible(false);
		labelPalavra.setBounds(10, 114, 189, 24);
		frame.getContentPane().add(labelPalavra);
		
		labelAcertos = new JLabel("Acertos: 0");
		labelAcertos.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelAcertos.setVisible(false);
		labelAcertos.setForeground(new Color(0, 128, 0));
		labelAcertos.setBounds(121, 10, 78, 24);
		frame.getContentPane().add(labelAcertos);
		
		labelPenalidades = new JLabel("Penalidade 0: sem penalidadades");
		labelPenalidades.setForeground(new Color(128, 0, 0));
		labelPenalidades.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelPenalidades.setVisible(false);
		labelPenalidades.setBounds(197, 8, 229, 28);
		frame.getContentPane().add(labelPenalidades);
		
		labelImagem = new JLabel();
		labelImagem.setIcon(new ImageIcon(TelaJogo.class.getResource("/imagens/6.png")));
		labelImagem.setBounds(252, 80, 150, 149);
		frame.getContentPane().add(labelImagem);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 172, 163, 81);
		frame.getContentPane().add(scrollPane);
		textAreaHistorico = new JTextArea("Histórico Vazio!");
		scrollPane.setViewportView(textAreaHistorico);
		textAreaHistorico.setEditable(false);
		textAreaHistorico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaHistorico.setDisabledTextColor(new Color(0, 0, 0));
		textAreaHistorico.setEnabled(false);
		
		buttonIniciar.addActionListener(sorteio -> {
			jogo.iniciar();
			labelResultado.setText("Jogo Iniciado - Digite uma letra");
			textField.setEnabled(true);
			buttonAdivinhar.setEnabled(true);
			labelDica.setText("Dica: " + jogo.getDica());
			labelDica.setVisible(true);
			labelPalavra.setText("Palavra: " + jogo.getPalavra());
			labelPalavra.setVisible(true);
			labelAcertos.setVisible(true);
			labelAcertos.setText("Acertos: " + jogo.getAcertos());
			labelPenalidades.setVisible(true);
			labelPenalidades.setText("Penalidade " + jogo.getCodigoPenalidade() + ": " + jogo.getNomePenalidade());
			textField.requestFocus();
			labelImagem.setIcon(new ImageIcon(TelaJogo.class.getResource("/imagens/0.png")));
		});
		

		buttonAdivinhar.addActionListener(e ->{
			try {
				letraDigitada = textField.getText();
				textField.setText("");
				textField.requestFocus();
				if (!jogo.getOcorrencias(letraDigitada).isEmpty()) {
					labelResultado.setText("Você acertou a letra " + letraDigitada.toUpperCase());
				} else {
					labelResultado.setText("Você errou a letra " + letraDigitada.toUpperCase());
				}
			}
			catch (Exception erro){
				JOptionPane.showMessageDialog(frame, erro.getMessage());
			}
			labelPalavra.setText("Palavra: " + jogo.getPalavra());
			labelAcertos.setText("Acertos: " + jogo.getAcertos());
			labelPenalidades.setText("Penalidade " + jogo.getCodigoPenalidade() + ": " + jogo.getNomePenalidade());
			int i = jogo.getCodigoPenalidade();
			String foto = String.format("/imagens/%d.png", i);
			labelImagem.setIcon(new ImageIcon(TelaJogo.class.getResource(foto)));
			if (jogo.terminou()) {
				labelResultado.setText("Você " + jogo.getResultado() + " - Inicie outro jogo!");
				textField.setEnabled(false);
				buttonAdivinhar.setEnabled(false);
				if (textAreaHistorico.getText().equals("Histórico Vazio!")) {
					textAreaHistorico.setText(jogo.getResultados().getLast());
				} else {
					textAreaHistorico.append("\n" + jogo.getResultados().getLast());
				}
			}
		});



	}
}
