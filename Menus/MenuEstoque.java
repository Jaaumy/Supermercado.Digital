package Menus;

import Produtos.Produto;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuEstoque {
    private ArrayList<Produto> todosProdutos;
    private Scanner scanner;

    public MenuEstoque(ArrayList<Produto> todosProdutos, Scanner scanner) {
        this.todosProdutos = todosProdutos;
        this.scanner = scanner;
    }

    public void menu() {
        while (true) {
            System.out.println("\n--- MENU ESTOQUE ---");
            System.out.println("1. Listar todos os produtos e estoques");
            System.out.println("2. Adicionar quantidade ao estoque");
            System.out.println("3. Remover quantidade do estoque (simulação de venda/perda)");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            int opcao = -1;
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
            }
            scanner.nextLine(); // Consumir nova linha ou entrada inválida

            if (opcao == 0) {
                break;
            }

            switch (opcao) {
                case 1:
                    listarTodosProdutos();
                    break;
                case 2:
                    adicionarEstoque();
                    break;
                case 3:
                    removerEstoque();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void listarTodosProdutos() {
        System.out.println("\n--- LISTA DE PRODUTOS NO ESTOQUE ---");
        if (todosProdutos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado no sistema.");
            return;
        }
        for (Produto p : todosProdutos) {
            System.out.println(p); // Usa o toString() de cada produto específico
        }
    }

    private Produto encontrarProdutoPorId(int id) {
        for (Produto p : todosProdutos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    private void adicionarEstoque() {
        System.out.print("Digite o ID do produto para adicionar ao estoque: ");
        int id = -1;
        if (scanner.hasNextInt()) {
            id = scanner.nextInt();
        }
        scanner.nextLine();

        if (id == -1) {
            System.out.println("ID inválido.");
            return;
        }
        Produto produto = encontrarProdutoPorId(id);

        if (produto != null) {
            System.out.print("Digite a quantidade a ser adicionada: ");
            int quantidade = -1;
            if (scanner.hasNextInt()) {
                quantidade = scanner.nextInt();
            }
            scanner.nextLine();

            if (quantidade > 0) {
                produto.aumentarEstoque(quantidade);
                System.out.println("Estoque de '" + produto.getNome() + "' atualizado para: " + produto.getQuantidade());
            } else {
                System.out.println("Quantidade inválida ou não numérica.");
            }
        } else {
            System.out.println("Produto com ID " + id + " não encontrado.");
        }
    }

    private void removerEstoque() {
        System.out.print("Digite o ID do produto para remover do estoque: ");
        int id = -1;
        if (scanner.hasNextInt()) {
            id = scanner.nextInt();
        }
        scanner.nextLine();

        if (id == -1) {
            System.out.println("ID inválido.");
            return;
        }
        Produto produto = encontrarProdutoPorId(id);

        if (produto != null) {
            System.out.print("Digite a quantidade a ser removida: ");
            int quantidade = -1;
            if (scanner.hasNextInt()) {
                quantidade = scanner.nextInt();
            }
            scanner.nextLine();

            if (quantidade > 0) {
                if (produto.reduzirEstoque(quantidade)) {
                    System.out.println(quantidade + " unidade(s) de '" + produto.getNome() + "' removida(s). Estoque atual: " + produto.getQuantidade());
                } else {
                    // A mensagem de erro específica já é impressa pelo método reduzirEstoque()
                    // System.out.println("Não foi possível remover. Quantidade solicitada maior que o estoque ou inválida.");
                }
            } else {
                System.out.println("Quantidade inválida ou não numérica.");
            }
        } else {
            System.out.println("Produto com ID " + id + " não encontrado.");
        }
    }
}