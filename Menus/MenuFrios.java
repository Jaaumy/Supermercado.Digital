package Menus;

import Produtos.Frios;
import Produtos.Produto;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuFrios {
    private ArrayList<Frios> produtosFrios = new ArrayList<>();
    private Scanner scanner;

    public MenuFrios(Scanner scanner) {
        this.scanner = scanner;
        // Produtos de exemplo atualizados
        // Para frios, a 'quantidade' pode ser em unidades de embalagem ou peso (ex: 1 para 100g se preço é por 100g)
        // Vamos assumir que o preço é por unidade/embalagem para simplificar o estoque em 'unidades'
        produtosFrios.add(new Frios("Queijo Mussarela Fatiado 200g", 12.90, 30, "Laticínios Aurora", true));
        produtosFrios.add(new Frios("Presunto Cozido Fatiado 200g", 9.50, 25, "Sadia", true));
        produtosFrios.add(new Frios("Peito de Peru Defumado Fatiado 150g", 15.00, 20, "Seara", true));
        produtosFrios.add(new Frios("Salame Italiano Peça ~300g", 25.00, 15, "Perdigão", false)); // Peça
        produtosFrios.add(new Frios("Requeijão Cremoso Copo 200g", 7.80, 40, "Vigor", false)); // Não é fatiado
    }

    public ArrayList<Frios> getProdutos() {
        return produtosFrios;
    }

    public Produto selecionarProdutoParaCarrinho() {
        System.out.println("\n--- FRIOS ---");
        if (produtosFrios.isEmpty()) {
            System.out.println("Nenhum produto de frios cadastrado.");
            return null;
        }
        for (int i = 0; i < produtosFrios.size(); i++) {
            System.out.println((i + 1) + ". " + produtosFrios.get(i));
        }
        System.out.print("Escolha o produto pelo número (0 para cancelar): ");
        int escolha = -1;
        if (scanner.hasNextInt()) {
            escolha = scanner.nextInt();
        }
        scanner.nextLine();

        if (escolha > 0 && escolha <= produtosFrios.size()) {
            return produtosFrios.get(escolha - 1);
        }
        System.out.println("Seleção cancelada ou inválida.");
        return null;
    }
}