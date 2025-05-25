package Menus;

import Produtos.Esporte;
import Produtos.Produto;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuEsportes {
    private ArrayList<Esporte> produtosEsportes = new ArrayList<>();
    private Scanner scanner;

    public MenuEsportes(Scanner scanner) {
        this.scanner = scanner;
        // Produtos de exemplo atualizados
        produtosEsportes.add(new Esporte("Bola de Futebol Campo Oficial", 89.90, 30, "Futebol", "Adulto/Profissional"));
        produtosEsportes.add(new Esporte("Corda de Pular Ajustável", 25.00, 50, "Fitness", "Adulto"));
        produtosEsportes.add(new Esporte("Luva de Boxe 12oz", 150.00, 15, "Luta", "Adulto"));
        produtosEsportes.add(new Esporte("Raquete de Tênis Iniciante", 120.00, 20, "Tênis", "Iniciante"));
        produtosEsportes.add(new Esporte("Óculos de Natação", 65.00, 25, "Natação", "Adulto/Infantil"));
    }

    public ArrayList<Esporte> getProdutos() {
        return produtosEsportes;
    }

    public Produto selecionarProdutoParaCarrinho() {
        System.out.println("\n--- ESPORTES ---");
        if (produtosEsportes.isEmpty()) {
            System.out.println("Nenhum produto de esportes cadastrado.");
            return null;
        }
        for (int i = 0; i < produtosEsportes.size(); i++) {
            System.out.println((i + 1) + ". " + produtosEsportes.get(i));
        }
        System.out.print("Escolha o produto pelo número (0 para cancelar): ");
        int escolha = -1;
        if (scanner.hasNextInt()) {
            escolha = scanner.nextInt();
        }
        scanner.nextLine();

        if (escolha > 0 && escolha <= produtosEsportes.size()) {
            return produtosEsportes.get(escolha - 1);
        }
        System.out.println("Seleção cancelada ou inválida.");
        return null;
    }
}