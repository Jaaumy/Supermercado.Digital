package Menus;

import Produtos.Hortifruti;
import Produtos.Produto; // Necessário para o tipo de retorno de selecionarProdutoParaCarrinho

import java.util.ArrayList;
import java.util.Scanner;

public class MenuHortifruti {
    private ArrayList<Hortifruti> produtosHortifruti = new ArrayList<>();
    private Scanner scanner;

    public MenuHortifruti(Scanner scanner) {
        this.scanner = scanner;
        // Produtos de exemplo atualizados com novos construtores
        produtosHortifruti.add(new Hortifruti("Maçã Gala KG", 7.99, 50, "Fruta", "Nacional"));
        produtosHortifruti.add(new Hortifruti("Alface Crespa Un", 3.50, 30, "Verdura", "Local"));
        produtosHortifruti.add(new Hortifruti("Batata Inglesa KG", 5.20, 100, "Legume", "Nacional"));
        produtosHortifruti.add(new Hortifruti("Banana Prata Dúzia", 6.50, 40, "Fruta", "Nacional"));
        produtosHortifruti.add(new Hortifruti("Cenoura KG", 4.80, 60, "Legume", "Local"));
    }

    public ArrayList<Hortifruti> getProdutos() {
        return produtosHortifruti;
    }

    public Produto selecionarProdutoParaCarrinho() {
        System.out.println("\n--- HORTIFRUTI ---");
        if (produtosHortifruti.isEmpty()) {
            System.out.println("Nenhum produto de hortifruti cadastrado.");
            return null;
        }
        for (int i = 0; i < produtosHortifruti.size(); i++) {
            System.out.println((i + 1) + ". " + produtosHortifruti.get(i));
        }
        System.out.print("Escolha o produto pelo número (0 para cancelar): ");
        int escolha = -1;
        if (scanner.hasNextInt()) {
            escolha = scanner.nextInt();
        }
        scanner.nextLine(); // Consumir nova linha ou entrada inválida

        if (escolha > 0 && escolha <= produtosHortifruti.size()) {
            return produtosHortifruti.get(escolha - 1);
        }
        System.out.println("Seleção cancelada ou inválida.");
        return null;
    }
}