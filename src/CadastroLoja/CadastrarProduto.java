package CadastroLoja;

import dominio.Produto;

import java.util.ArrayList;
import java.util.Scanner;

public class CadastrarProduto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Produto> produtos = new ArrayList<>();

        int opcao;

        // Loop do menu principal
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Cadastrar produto");
            System.out.println("2. Listar produtos");
            System.out.println("3. Remover produto");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar o \n do buffer

            switch (opcao) {
                case 1:
                    // Cadastro
                    System.out.print("Digite o nome do produto: ");
                    String nome = scanner.nextLine();

                    System.out.print("Digite o tipo do produto: ");
                    String tipo = scanner.nextLine();

                    System.out.print("Digite o preço do produto: ");
                    String precoTexto = scanner.nextLine().replace(",", ".");
                    double preco = Double.parseDouble(precoTexto);

                    Produto produto = new Produto(nome, tipo, preco);
                    produtos.add(produto);

                    System.out.println("✅ Produto cadastrado com sucesso!");
                    break;

                case 2:
                    // Listagem
                    System.out.println("\n===== LISTA DE PRODUTOS =====");
                    if (produtos.isEmpty()) {
                        System.out.println("Nenhum produto cadastrado.");
                    } else {
                        for (Produto p : produtos) {
                            System.out.println(p);
                        }
                    }
                    break;

                case 3:
                    System.out.println("\n===== REMOVER PRODUTO =====");
                    if (produtos.isEmpty()) {
                        System.out.println("Nenhum produto para remover.");
                        break;
                    }

                    for (int i = 0; i < produtos.size(); i++) {
                        System.out.println(i + " - " + produtos.get(i));
                    }

                    System.out.print("Digite o número do produto que deseja remover: ");
                    int indiceRemover = scanner.nextInt();
                    scanner.nextLine(); // limpar o \n

                    if (indiceRemover >= 0 && indiceRemover < produtos.size()) {
                        Produto removido = produtos.remove(indiceRemover);
                        System.out.println("✅ Produto removido: " + removido.nome);
                    } else {
                        System.out.println("❌ Índice inválido.");
                    }
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
