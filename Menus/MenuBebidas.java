package Menus;

import Produtos.Bebida;
import Produtos.Produto; // Necessário para o tipo de retorno de selecionarProdutoParaCarrinho

import java.util.ArrayList;
import java.util.Scanner;

public class MenuBebidas {
    private ArrayList<Bebida> produtosBebidas = new ArrayList<>();
    private Scanner scanner;

    public MenuBebidas(Scanner scanner) {
        this.scanner = scanner;
        // Produtos de exemplo, utilizando o construtor de Produtos.Bebida com 5 argumentos:
        // (String nome, double preco, int quantidade, double volumeLitros, boolean alcoolica)
        produtosBebidas.add(new Bebida("Refrigerante Cola Garrafa", 8.00, 40, 2.0, false));    // 2.0 Litros
        produtosBebidas.add(new Bebida("Cerveja Pilsen Lata", 4.50, 100, 0.350, true));      // 350ml (0.350 Litros)
        produtosBebidas.add(new Bebida("Água Mineral Sem Gás Garrafa", 2.50, 200, 0.500, false)); // 500ml (0.500 Litros)
        produtosBebidas.add(new Bebida("Suco de Laranja Integral Caixa", 12.00, 30, 1.0, false));  // 1.0 Litro
        produtosBebidas.add(new Bebida("Vinho Tinto Seco Garrafa", 45.00, 20, 0.750, true));    // 750ml (0.750 Litros)
        produtosBebidas.add(new Bebida("Energético Lata", 9.00, 50, 0.250, false));        // 250ml (0.250 Litros)
    }

    // Método para obter a lista de produtos deste menu (usado no Main para montar a lista geral)
    public ArrayList<Bebida> getProdutos() {
        return produtosBebidas;
    }

    // Método para o usuário selecionar um produto desta categoria para adicionar ao carrinho
    public Produto selecionarProdutoParaCarrinho() {
        System.out.println("\n--- BEBIDAS DISPONÍVEIS ---");
        if (produtosBebidas.isEmpty()) {
            System.out.println("Nenhuma bebida cadastrada no momento.");
            return null;
        }

        // Lista os produtos com um número para seleção
        for (int i = 0; i < produtosBebidas.size(); i++) {
            System.out.println((i + 1) + ". " + produtosBebidas.get(i)); // Utiliza o toString() de Produtos.Bebida
        }
        System.out.print("Escolha o produto pelo número (ou 0 para cancelar): ");

        int escolha = -1;
        if (scanner.hasNextInt()) {
            escolha = scanner.nextInt();
        }
        scanner.nextLine(); // Consome a nova linha restante ou a entrada inválida

        if (escolha > 0 && escolha <= produtosBebidas.size()) {
            // Retorna o produto selecionado (o objeto Bebida é um Produto)
            return produtosBebidas.get(escolha - 1);
        }

        if (escolha != 0) {
            System.out.println("Seleção inválida.");
        } else {
            System.out.println("Seleção cancelada.");
        }
        return null; // Retorna null se a escolha for inválida ou cancelada
    }
}