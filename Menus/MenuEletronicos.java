package Menus;

import Produtos.Eletronico;
import Produtos.Produto;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuEletronicos {
    private ArrayList<Eletronico> produtosEletronicos = new ArrayList<>();
    private Scanner scanner;

    public MenuEletronicos(Scanner scanner) {
        this.scanner = scanner;
        // Produtos de exemplo atualizados
        produtosEletronicos.add(new Eletronico("Smartphone XYZ", 1350.00, 25, "MarcaX", 12, "Bivolt"));
        produtosEletronicos.add(new Eletronico("Notebook Pro", 4800.00, 10, "MarcaY", 24, "Bivolt"));
        produtosEletronicos.add(new Eletronico("Smartwatch Fit", 750.00, 30, "MarcaZ", 6, "N/A")); // N/A para voltagem se não aplicável
        produtosEletronicos.add(new Eletronico("Fone de Ouvido Bluetooth", 250.00, 40, "MarcaA", 12, "N/A"));
        produtosEletronicos.add(new Eletronico("TV LED 42 pol.", 2200.00, 15, "MarcaB", 12, "Bivolt"));
    }

    public ArrayList<Eletronico> getProdutos() {
        return produtosEletronicos;
    }

    public Produto selecionarProdutoParaCarrinho() {
        System.out.println("\n--- ELETRÔNICOS ---");
        if (produtosEletronicos.isEmpty()) {
            System.out.println("Nenhum produto eletrônico cadastrado.");
            return null;
        }
        for (int i = 0; i < produtosEletronicos.size(); i++) {
            System.out.println((i + 1) + ". " + produtosEletronicos.get(i));
        }
        System.out.print("Escolha o produto pelo número (0 para cancelar): ");
        int escolha = -1;
        if (scanner.hasNextInt()) {
            escolha = scanner.nextInt();
        }
        scanner.nextLine();

        if (escolha > 0 && escolha <= produtosEletronicos.size()) {
            return produtosEletronicos.get(escolha - 1);
        }
        System.out.println("Seleção cancelada ou inválida.");
        return null;
    }
}