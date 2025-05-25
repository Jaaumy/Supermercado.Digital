package Menus;

import Produtos.Automobilismo;
import Produtos.Produto;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuAutomobilismo {
    private ArrayList<Automobilismo> produtosAutomobilismo = new ArrayList<>();
    private Scanner scanner;

    public MenuAutomobilismo(Scanner scanner) {
        this.scanner = scanner;
        // Produtos de exemplo atualizados
        produtosAutomobilismo.add(new Automobilismo("Óleo Motor 15W40 Semissintético 1L", 42.00, 50, "Lubrificante", "Universal"));
        produtosAutomobilismo.add(new Automobilismo("Pneu Aro 15 185/60", 350.00, 20, "Pneu", "Universal"));
        produtosAutomobilismo.add(new Automobilismo("Limpa Para-brisa Concentrado 100ml", 15.50, 40, "Aditivo", "Universal"));
        produtosAutomobilismo.add(new Automobilismo("Filtro de Óleo Motor X", 25.00, 30, "Filtro", "Fiat Palio 1.0"));
        produtosAutomobilismo.add(new Automobilismo("Cera Automotiva Limpadora", 35.00, 25, "Limpeza", "Universal"));
    }

    public ArrayList<Automobilismo> getProdutos() {
        return produtosAutomobilismo;
    }

    public Produto selecionarProdutoParaCarrinho() {
        System.out.println("\n--- AUTOMOBILISMO ---");
        if (produtosAutomobilismo.isEmpty()) {
            System.out.println("Nenhum produto de automobilismo cadastrado.");
            return null;
        }
        for (int i = 0; i < produtosAutomobilismo.size(); i++) {
            System.out.println((i + 1) + ". " + produtosAutomobilismo.get(i));
        }
        System.out.print("Escolha o produto pelo número (0 para cancelar): ");
        int escolha = -1;
        if (scanner.hasNextInt()) {
            escolha = scanner.nextInt();
        }
        scanner.nextLine();

        if (escolha > 0 && escolha <= produtosAutomobilismo.size()) {
            return produtosAutomobilismo.get(escolha - 1);
        }
        System.out.println("Seleção cancelada ou inválida.");
        return null;
    }
}