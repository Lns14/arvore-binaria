import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Ranking ranking = new Ranking();
        Scanner scanner = new Scanner(System.in);

        ranking.adicionaVilao(new SuperViloes("Coringa", 8));
        ranking.adicionaVilao(new SuperViloes("Duende Verde", 10));
        ranking.adicionaVilao(new SuperViloes("Loki", 6));
        ranking.adicionaVilao(new SuperViloes("Thanos", 10));
        ranking.adicionaVilao(new SuperViloes("Charada", 4));
        ranking.adicionaVilao(new SuperViloes("Doutor Destino", 7));
        ranking.adicionaVilao(new SuperViloes("Mística", 5));
        ranking.adicionaVilao(new SuperViloes("Magneto", 7));

        int opcao;
        do {
            System.out.println("\nEscolha uma ação:");
            System.out.println("1 - Mostrar vilão de maior nível de maldade");
            System.out.println("2 - Adicionar novo vilão");
            System.out.println("3 - Remover vilão");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    SuperViloes vilaoMaisMalvado = ranking.buscaMaiorNivelDeMaldade(ranking.getRaiz());
                    System.out.println("Vilão de maior nível de maldade: " + vilaoMaisMalvado.getNome());
                    break;
                case 2:
                    System.out.print("Nome do vilão: ");
                    String nome = scanner.nextLine();
                    System.out.print("Nível de maldade: ");
                    int nivel = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer
                    ranking.adicionaVilao(new SuperViloes(nome, nivel));
                    System.out.println("Vilão adicionado!");
                    break;
                case 3:
                    System.out.print("Nome do vilão a remover: ");
                    String nomeRemover = scanner.nextLine();
                    ranking.removeVilao(nomeRemover);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
