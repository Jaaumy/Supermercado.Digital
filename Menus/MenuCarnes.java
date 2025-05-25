package Menus;

import Produtos.Carne;
import Produtos.Produto;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuCarnes {
    private ArrayList<Carne> produtosCarnes = new ArrayList<>();
    private Scanner scanner;

    public MenuCarnes(Scanner scanner) {
        this.scanner = scanner;
        // Produtos de exemplo atualizados
        // O 'nome' do produto já inclui o corte para clareza
        produtosCarnes.add(new Carne("Picanha Bovina KG", 79.90, 20, "Bovina", "Picanha"));
        produtosCarnes.add(new Carne("Filé de Frango KG", 22.50, 35, "Ave", "Filé de Peito"));
        produtosCarnes.add(new Carne("Costela Suína KG", 35.00, 25, "Suína", "Costela"));
        produtosCarnes.add(new Carne("Salmão Filé KG", 95.00, 15, "Peixe", "Filé"));
        produtosCarnes.add(new Carne("Linguiça Toscana KG", 28.00, 40, "Suína", "Linguiça"));
    }

    public ArrayList<Carne> getProdutos() {
        return produtosCarnes;
    }

    public Produto selecionarProdutoParaCarrinho() {
        System.out.println("\n--- CARNES ---");
        if (produtosCarnes.isEmpty()) {
            System.out.println("Nenhuma carne cadastrada.");
            return null;
        }
        for (int i = 0; i < produtosCarnes.size(); i++) {
            System.out.println((i + 1) + ". " + produtosCarnes.get(i));
        }
        System.out.print("Escolha o produto pelo número (0 para cancelar): ");
        int escolha = -1;
        if (scanner.hasNextInt()) {
            escolha = scanner.nextInt();
        }
        scanner.nextLine();

        if (escolha > 0 && escolha <= produtosCarnes.size()) {
            return produtosCarnes.get(escolha - 1);
        }
        System.out.println("Seleção cancelada ou inválida.");
        return null;
    }
}