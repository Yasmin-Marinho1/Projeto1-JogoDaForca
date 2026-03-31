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
    private ArrayList<String> resultadosAnteriores = new ArrayList<>();
	private ArrayList<String> letrasAnteriores = new ArrayList<>();
    private ArrayList<Integer> sorteiosAnteriores = new ArrayList<>();
	private ArrayList<Integer> reveladas = new ArrayList<>();
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
		} arquivo.close();
	}
	public void iniciar() {
		this.codigoPenalidade = 0;
		this.acertos = 0;
		this.reveladas.clear();
		this.letrasAnteriores.clear();
		if (palavrasForca.size() <= sorteiosAnteriores.size()) {
			sorteiosAnteriores.clear();
		}
		Random sorteio = new Random();
		int i;
		do {
			i = sorteio.nextInt(palavrasForca.size());
		} while (sorteiosAnteriores.contains(i));
		sorteiosAnteriores.add(i);
		this.palavra = palavrasForca.get(i).get(0);
		this.dica = palavrasForca.get(i).get(1);
	}
	public String getDica() {
		return this.dica;
	}
	public String getPalavra() {
		String revelacao = new String();
		/* Verifica quais índices da palavra foram revelados e adiciona * ou a letra revelada. */
		for (int i = 0; i < this.palavra.length(); i++) {
			if (this.reveladas.contains(i)) {
				revelacao += this.palavra.substring(i, i+1).toUpperCase();
			} else {
				revelacao += "*";
			}
		} return revelacao;
	}
	public ArrayList<String> getResultados() {
		if (this.terminou()) {
			resultadosAnteriores.add(this.palavra + " => " + this.getResultado());
		} return this.resultadosAnteriores;
	}
	public ArrayList<Integer> getOcorrencias(String letra) throws Exception {
		
		/* Verificando exceções */
		if (letra.length() != 1) {
			throw new Exception("Digite uma letra");
		}
		letra = letra.toUpperCase();

		if (!letra.matches("[A-Z]")) {
			throw new Exception("Digite uma letra válida");
		} else if (this.letrasAnteriores.contains(letra)) {
			throw new Exception("Letra já digitada anteriormente!");
		} else {
			letrasAnteriores.add(letra); /* Adicionando a letra digitada no array de letras anteriores */
		}


		/* Verificando se a letra está contida na palavra e guardando o índice caso esteja */
		ArrayList<Integer> ocorrencias = new ArrayList<>();
		for (int i = 0; i < this.palavra.length(); i++) {
			if (palavra.substring(i, i+1).equals(letra)) {
				ocorrencias.add(i);
			}
		}
		/* Verifica se o array gerado tem índices dentro ou se está vazio para adicionar acertos ou penalidades */
		if (ocorrencias.isEmpty()) {
			this.codigoPenalidade += 1;
		} else {
			this.acertos += ocorrencias.size();
			for (Integer indice: ocorrencias) {
				this.reveladas.add(indice);
			}
		}
		return ocorrencias;
	}
	public boolean terminou() {
		if (getAcertos() == this.palavra.length() || getCodigoPenalidade() == 6) {
			return true;
		} else {
			return false;
		}
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
		} return this.resultado;
	}
}