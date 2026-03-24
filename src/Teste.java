import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Teste {
	private String letraDigitada; // letra lida do teclado
	private ArrayList<Integer> ocorrencias; // posicoes adivinhadas
	private JogoDaForca jogo = new JogoDaForca();

	public Teste() {
		JOptionPane.showMessageDialog(null, "Bem-vindo ao Jogo da Forca! \nTente adivinhar a palavra secreta. ");
		jogo.iniciar();
		do {
			letraDigitada = JOptionPane.showInputDialog(null, "dica: " + jogo.getDica() + "\ndigite uma letra: ");
			try {
				ocorrencias = jogo.getOcorrencias(letraDigitada);
				if (ocorrencias.size() > 0)
					JOptionPane.showMessageDialog(null,
							"voce acertou a letra =" + letraDigitada + "\n------------RESUMO-------------------"
									+ "\n palavra adivinhada=" + jogo.getPalavra() + "\n total de acertos = "
									+ jogo.getAcertos() + "\n penalidade = " + jogo.getCodigoPenalidade() + "-"
									+ jogo.getNomePenalidade() + "\n-------------------------------------");
				else
					JOptionPane.showMessageDialog(null,
							"voce errou a letra =" + letraDigitada + "\n------------RESUMO-------------------"
									+ "\n palavra adivinhada=" + jogo.getPalavra() + "\n total de acertos = "
									+ jogo.getAcertos() + "\n penalidade = " + jogo.getCodigoPenalidade() + "-"
									+ jogo.getNomePenalidade() + "\n-------------------------------------");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"mensagem="+ e.getMessage());
			}
		} while (!jogo.terminou());

		JOptionPane.showMessageDialog(null, "resultado final = " + jogo.getResultado());

	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		new Teste();
	}
}