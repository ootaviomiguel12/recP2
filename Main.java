import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        listaDeInscritos();
        tabelaDoCampeonato();
    }

    public static void listaDeInscritos() {
        var scan = new Scanner(System.in);
        long[][] matriz = new long[10][3];

        final int CPF = 0, IDADE = 1, CURSO = 2;
        int somaDasIdades = 0;
        int ads = 0, gecom = 0, eventos = 0, rh = 0;
        double mediaIdadeDeInscritos;

        for (int i = 0; i < matriz.length; i++) {
            System.out.println("Digite o CPF do inscrito: ");
            long cpf = scan.nextLong();

            boolean cpfExiste = false;
            for (int j = 0; j < i; j++) {
                if (cpf == matriz[j][CPF]) {
                    cpfExiste = true;
                    System.out.println("CPF já cadastrado registro não inserido");
                    break;
                }
            }

            if (cpfExiste) {
                i--;
                continue;
            }

            System.out.println("Digite a idade do inscrito: ");
            int idade = scan.nextInt();


            int curso;

            do {
                System.out.println("Digite o curso do inscrito: ");
                System.out.println("1 - ADS");
                System.out.println("2 - GECOM");
                System.out.println("3 - Eventos");
                System.out.println("4 - RH");
                curso = scan.nextInt();

                if (curso < 1 || curso > 4) {
                    System.out.println("Digite um número válido.");
                }

            } while (curso < 1 || curso > 4);

            matriz[i][CPF] = cpf;
            matriz[i][IDADE] = idade;
            matriz[i][CURSO] = curso;

            somaDasIdades += idade;

            switch (curso) {
                case 1: {
                    ads++;
                    break;
                }
                case 2: {
                    gecom++;
                    break;
                }
                case 3: {
                    eventos++;
                    break;
                }
                case 4: {
                    rh++;
                    break;
                }
            }
        }
        System.out.println("Quantidade de inscritos no curso de ADS: " + ads);
        System.out.println("Quantidade de inscritos no curso de GECOM: " + gecom);
        System.out.println("Quantidade de inscritos no curso de EVENTOS: " + eventos);
        System.out.println("Quantidade de inscritos no curso de RH: " + rh);

        mediaIdadeDeInscritos = (double) somaDasIdades / matriz.length;
        System.out.println("Média das idades dos inscritos: " + mediaIdadeDeInscritos);
    }

    public static void tabelaDoCampeonato() {
        var scan = new Scanner(System.in);
        int[][] matriz = new int[10][4];

        final int VITORIAS = 0, EMPATES = 1, DERROTAS = 2, PONTUACAO = 3;

        for (int i = 0; i < matriz.length; i++) {
            System.out.println("Digite a quantidade de vitórias: ");
            matriz[i][VITORIAS] = scan.nextInt();

            System.out.println("Digite a quantidade de empates: ");
            matriz[i][EMPATES] = scan.nextInt();

            System.out.println("Digite a quantidade de derrotas: ");
            matriz[i][DERROTAS] = scan.nextInt();

            int pontuacaoVitorias = matriz[i][VITORIAS] * 3;
            int pontuacaoEmpates = matriz[i][EMPATES] * 1;
            int pontuacaoDerrotas = matriz[i][DERROTAS] * 0;

            int pontuacaoFinal = pontuacaoVitorias + pontuacaoDerrotas + pontuacaoEmpates;

            matriz[i][PONTUACAO] = pontuacaoFinal;
        }
        int maiorPontuacao = -1, segundoMaior = -1, terceiroMaior = -1;
        int time1 = -1, time2 = -1, time3 = -1;

        for (int j = 0; j < matriz.length; j++) {
            int pontosAtuais = matriz[j][PONTUACAO];
            int numeroDoTime = j + 1;

            if (pontosAtuais > maiorPontuacao) {
                terceiroMaior = segundoMaior;
                time3 = time2;

                segundoMaior = maiorPontuacao;
                time2 = time1;

                maiorPontuacao = pontosAtuais;
                time1 = numeroDoTime;
            } else if (pontosAtuais > segundoMaior) {
                terceiroMaior = segundoMaior;
                time3 = time2;

                segundoMaior = pontosAtuais;
                time2 = numeroDoTime;
            } else if (pontosAtuais > terceiroMaior) {
                terceiroMaior = pontosAtuais;
                time3 = numeroDoTime;
            }
        }
        System.out.println("Primeiro colocado: " + time1 + ". Pontuação: " + maiorPontuacao);
        System.out.println("Segundo colocado: " + time2 + ". Pontuação: " + segundoMaior);
        System.out.println("Terceiro colocado: " + time3 + ". Pontuação: " + terceiroMaior);
    }
}
