# Jogo da Forca
Projeto do segundo período do curso de Engenharia de Software - IFPB Campus João Pessoa

## Descrição
O jogador pode errar apenas 5 vezes, para adivinhar as letras de uma palavra, baseando-se apenas no seu tamanho e em uma dica.

• A cada tentativa correta, o jogador descobre as ocorrências da letra dentro da palavra.

• A cada tentativa errada, o jogador recebe uma penalidade crescente (1 - “perdeu primeira perna”, 2 - “perdeu segunda perna”, 3 -”perdeu primeiro braço”, 4 -”perdeu segundo braço”, 5 -”perdeu tronco” e 6 -”perdeu cabeça”). Iniciando-se em 0 - “sem penalidades”.

O jogador vence, quando adivinhar todas as letras da palavra, e perde, quando atinge a penalidade 6.

## Funcionalidades
- Navegação Intuitiva
- Layout Responsivo

## Tecnologias Utilizadas
- Frontend: Java
- Backend: Java
- Armazenamento: CSV

## Como Executar

### Pré-requisitos
- JDK 26

### Instalação
1. Clone o repositório
   git clone https://github.com/GuilhermeMeloRoxo/Projeto1-JogoDaForca.git
2. Execute o projeto
   java TelaJogo.java

## Testes
cd src/
java Teste.java

## Estrutura do Projeto

      Projeto1-JogoDaForca/
      └── src/
          ├── dados/		        # Armazenamento
          |   └──  palavras.csv
          ├── imagens/		        # Imagens do jogo
          |   ├── 0.png
          |   ├── 1.png
          |   ├── 2.png
          |   ├── 3.png
          |   ├── 4.png
          |   ├── 5.png
          |   └── 6.png
          ├── JogodaForca.java      # Lógica principal
          ├── TelaJogo.java	    # Interface Gráfica
          └── Teste.java		    # Teste

## Autores
- **Guilherme Mélo** - Desenvolvimento Full Stack - 
[@GuilhermeMelo](https://github.com/GuilhermeMeloRoxo)
- **Yasmin Marinho** - Desenvolvimento Full Stack - [@YasminMarinho](https://github.com/Yasmin-Marinho1)
