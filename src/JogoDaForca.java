import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class JogoDaForca {

    private String palavra;
    private String dica;
    private int acertos;
    private int codigoPenalidade;
    private String nomePenalidade;
    private String resultado;
    private ArrayList<String> palavrasAnteriores;
    private ArrayList<Integer> ocorrencias;
    private ArrayList<ArrayList<String>> palavrasForca;
    
	public JogoDaForca() {
		this.palavrasForca = new ArrayList<>();
		InputStream stream = this.getClass().getResourceAsStream("/dados/palavras.csv");
		if (stream == null) {
			JOptionPane.showMessageDialog(null, "Arquivo de palavras inexistente!");
			System.exit(0);
		}
		Scanner arquivo = new Scanner(stream);
		String linha;
		while (arquivo.hasNextLine()) {
			linha = arquivo.nextLine();
			String[] lista = linha.split(";");
			ArrayList<String> palavras = new ArrayList<>();
			palavras.add(lista[0]);
			palavras.add(lista[1]);
			palavrasForca.add(palavras);
		}
		arquivo.close();
	}
	public void iniciar() {
		Random sorteio = new Random();
		int i = sorteio.nextInt(palavrasForca.size());
		this.palavra = palavrasForca.get(i).get(0);
		this.dica = palavrasForca.get(i).get(1);
	}
	public String getDica() {
		return this.dica;
	}
	public String getPalavra() {
		/* retorna a palavra sorteada, revelando as letras adivinhadas até 
		o momento e ocultando ("*") as letras ainda não adivinhadas. */
	}
	public ArrayList<String> getResultados() {
		/* retorna as palavras sorteadas anteriormente 
		com os respectivos resultados. */
	}
	public ArrayList<Integer> getOcorrencias(String letra) throws Exception {
		/*retorna uma lista com as posições (1 a N) da “letra” encontrada dentro da palavra sorteada ou, caso
		contrário, retorna uma lista vazia. Além disso, contabiliza um acerto, para cada ocorrência da “letra”
		encontrada, ou contabiliza uma penalidade, na sua ausência. Lança uma exceção verificada (classe
		Exception) se “letra” tiver 0 ou mais de 1 caractere. Considere que “letra” pode estar em maiúscula ou minúscula.*/
	}
	public boolean terminou() {
		// retorna true se o jogo terminou.
	}
	public int getAcertos() {
		return this.acertos;
	}
	public int getCodigoPenalidade() {
		return this.codigoPenalidade;
	}
	public String getNomePenalidade() {
		this.nomePenalidade = "sem penalidades";
		switch (this.getCodigoPenalidade()) {
			case 1:
				return this.nomePenalidade = "perdeu primeira perna";
			case 2:
				return this.nomePenalidade = "perdeu segunda perna";
			case 3:
				return this.nomePenalidade = "perdeu primeiro braço";
			case 4:
				return this.nomePenalidade = "perdeu segundo braço";
			case 5:
				return this.nomePenalidade = "perdeu tronco";
			case 6:
				return this.nomePenalidade = "perdeu cabeça";
			default: 
				return this.nomePenalidade;
		}
	}
	public String getResultado() {
		this.resultado = "em andamento";
		if (this.terminou()) {
			if (this.getCodigoPenalidade() == 6) { 
				this.resultado = "perdeu";
			} else {
				this.resultado = "venceu";
			}
		}
		return this.resultado;
	}
}