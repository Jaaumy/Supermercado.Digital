import Produtos.Produto; // Necessário para o ArrayList<Produto> e para o retorno de selecionarProdutoParaCarrinho
import Menus.*;         // Importa todas as classes do pacote Menus
// Carrinho.java está na raiz, então não precisa de import de pacote se Main.java também estiver na raiz.

import java.util.ArrayList;
import java.util.List; // Para usar a lista retornada por carrinho.verCarrinho()
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Carrinho carrinho = new Carrinho();

    // Menus das categorias
    private static MenuHortifruti menuHortifruti = new MenuHortifruti(scanner);
    private static MenuBebidas menuBebidas = new MenuBebidas(scanner);
    private static MenuCarnes menuCarnes = new MenuCarnes(scanner);
    private static MenuFrios menuFrios = new MenuFrios(scanner);
    private static MenuAutomobilismo menuAutomobilismo = new MenuAutomobilismo(scanner);
    private static MenuEsportes menuEsportes = new MenuEsportes(scanner);
    private static MenuEletronicos menuEletronicos = new MenuEletronicos(scanner);

    // Menu de Estoque
    private static MenuEstoque menuEstoque;

    public static void main(String[] args) {
        // Coleta todos os produtos de todos os menus em uma única lista
        ArrayList<Produto> todosProdutos = new ArrayList<>();
        todosProdutos.addAll(menuHortifruti.getProdutos());
        todosProdutos.addAll(menuBebidas.getProdutos());
        todosProdutos.addAll(menuCarnes.getProdutos());
        todosProdutos.addAll(menuFrios.getProdutos());
        todosProdutos.addAll(menuAutomobilismo.getProdutos());
        todosProdutos.addAll(menuEsportes.getProdutos());
        todosProdutos.addAll(menuEletronicos.getProdutos());

        // Inicializa o MenuEstoque com a lista de todos os produtos
        menuEstoque = new MenuEstoque(todosProdutos, scanner);

        System.out.println("==============================================");
        System.out.println(" Bem-vindo ao Supra Mercado");
        System.out.println("==============================================");

        loopMenuPrincipal();

        scanner.close();
        System.out.println("\nObrigado por usar o sistema. Volte sempre!");
    }

    private static void loopMenuPrincipal() {
        boolean executando = true;
        while (executando) {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Ver Produtos de Hortifruti");
            System.out.println("2. Ver Produtos de Bebidas");
            System.out.println("3. Ver Produtos de Carnes");
            System.out.println("4. Ver Produtos de Frios");
            System.out.println("5. Ver Produtos de Automobilismo");
            System.out.println("6. Ver Produtos de Esportes");
            System.out.println("7. Ver Produtos Eletrônicos");
            System.out.println("--------------------------");
            System.out.println("8. Gerenciar Carrinho (" + carrinho.getNumeroDeTiposDeItens() + " tipo(s) de item(ns))");
            System.out.println("9. Gerenciar Estoque");
            System.out.println("10. Finalizar Compra");
            System.out.println("--------------------------");
            System.out.println("0. Sair do Sistema");
            System.out.print("Escolha uma opção: ");

            int opcaoPrincipal = lerOpcaoDoUsuario();

            switch (opcaoPrincipal) {
                case 1:
                    processarSelecaoDeMenu(menuHortifruti);
                    break;
                case 2:
                    processarSelecaoDeMenu(menuBebidas);
                    break;
                case 3:
                    processarSelecaoDeMenu(menuCarnes);
                    break;
                case 4:
                    processarSelecaoDeMenu(menuFrios);
                    break;
                case 5:
                    processarSelecaoDeMenu(menuAutomobilismo);
                    break;
                case 6:
                    processarSelecaoDeMenu(menuEsportes);
                    break;
                case 7:
                    processarSelecaoDeMenu(menuEletronicos);
                    break;
                case 8:
                    gerenciarCarrinho();
                    break;
                case 9:
                    menuEstoque.menu();
                    break;
                case 10:
                    carrinho.finalizarCompra();
                    break;
                case 0:
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        }
    }

    private static void processarSelecaoDeMenu(Object menuCategoria) {
        Produto produtoSelecionado = null;
        if (menuCategoria instanceof MenuHortifruti) {
            produtoSelecionado = ((MenuHortifruti) menuCategoria).selecionarProdutoParaCarrinho();
        } else if (menuCategoria instanceof MenuBebidas) {
            produtoSelecionado = ((MenuBebidas) menuCategoria).selecionarProdutoParaCarrinho();
        } else if (menuCategoria instanceof MenuCarnes) {
            produtoSelecionado = ((MenuCarnes) menuCategoria).selecionarProdutoParaCarrinho();
        } else if (menuCategoria instanceof MenuFrios) {
            produtoSelecionado = ((MenuFrios) menuCategoria).selecionarProdutoParaCarrinho();
        } else if (menuCategoria instanceof MenuAutomobilismo) {
            produtoSelecionado = ((MenuAutomobilismo) menuCategoria).selecionarProdutoParaCarrinho();
        } else if (menuCategoria instanceof MenuEsportes) {
            produtoSelecionado = ((MenuEsportes) menuCategoria).selecionarProdutoParaCarrinho();
        } else if (menuCategoria instanceof MenuEletronicos) {
            produtoSelecionado = ((MenuEletronicos) menuCategoria).selecionarProdutoParaCarrinho();
        }

        if (produtoSelecionado != null) {
            System.out.print("Digite a quantidade desejada para '" + produtoSelecionado.getNome() + "': ");
            int quantidadeDesejada = lerOpcaoDoUsuario();
            if (quantidadeDesejada > 0) {
                carrinho.adicionarItem(produtoSelecionado, quantidadeDesejada);
            } else if (quantidadeDesejada == 0) {
                System.out.println("Nenhuma unidade adicionada.");
            } else {
                System.out.println("Quantidade inválida.");
            }
        }
    }

    private static void gerenciarCarrinho() {
        boolean gerenciando = true;
        while (gerenciando) {
            System.out.println("\n--- GERENCIAR CARRINHO ---");
            List<Produto> produtosNoCarrinho = carrinho.verCarrinho(); // Mostra o carrinho e retorna a lista de produtos

            if (produtosNoCarrinho.isEmpty()) {
                System.out.println("Não há mais opções de gerenciamento pois o carrinho está vazio.");
                gerenciando = false; // Sai do loop de gerenciamento se o carrinho esvaziar
                break;
            }

            System.out.println("\nOpções de Gerenciamento:");
            System.out.println("1. Modificar quantidade de um item");
            System.out.println("2. Remover um item completamente");
            System.out.println("3. Remover unidades de um item");
            System.out.println("4. Limpar carrinho (remover todos os itens)");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            int opcaoGerenciamento = lerOpcaoDoUsuario();
            Produto produtoParaAlterar;
            int numeroItem;
            int novaQuantidade;
            int qtdRemover;

            switch (opcaoGerenciamento) {
                case 1: // Modificar quantidade
                    System.out.print("Digite o número do item que deseja modificar: ");
                    numeroItem = lerOpcaoDoUsuario();
                    if (numeroItem > 0 && numeroItem <= produtosNoCarrinho.size()) {
                        produtoParaAlterar = produtosNoCarrinho.get(numeroItem - 1);
                        System.out.print("Digite a NOVA quantidade total para '" + produtoParaAlterar.getNome() + "' (0 para remover): ");
                        novaQuantidade = lerOpcaoDoUsuario();
                        carrinho.atualizarQuantidadeItem(produtoParaAlterar, novaQuantidade);
                    } else {
                        System.out.println("Número do item inválido.");
                    }
                    break;
                case 2: // Remover item completamente
                    System.out.print("Digite o número do item que deseja remover completamente: ");
                    numeroItem = lerOpcaoDoUsuario();
                    if (numeroItem > 0 && numeroItem <= produtosNoCarrinho.size()) {
                        produtoParaAlterar = produtosNoCarrinho.get(numeroItem - 1);
                        carrinho.removerItemPorCompleto(produtoParaAlterar);
                    } else {
                        System.out.println("Número do item inválido.");
                    }
                    break;
                case 3: // Remover unidades de um item
                    System.out.print("Digite o número do item do qual deseja remover unidades: ");
                    numeroItem = lerOpcaoDoUsuario();
                    if (numeroItem > 0 && numeroItem <= produtosNoCarrinho.size()) {
                        produtoParaAlterar = produtosNoCarrinho.get(numeroItem - 1);
                        System.out.print("Digite a quantidade de unidades a remover de '" + produtoParaAlterar.getNome() + "': ");
                        qtdRemover = lerOpcaoDoUsuario();
                        carrinho.removerUnidadesItem(produtoParaAlterar, qtdRemover);
                    } else {
                        System.out.println("Número do item inválido.");
                    }
                    break;
                case 4: // Limpar carrinho
                    System.out.print("Tem certeza que deseja remover TODOS os itens do carrinho? (S/N): ");
                    String confirmacao = scanner.nextLine().trim();
                    if (confirmacao.equalsIgnoreCase("S")) {
                        carrinho.limparCarrinho();
                    } else {
                        System.out.println("Operação de limpeza cancelada.");
                    }
                    break;
                case 0: // Voltar
                    gerenciando = false;
                    break;
                default:
                    System.out.println("Opção de gerenciamento inválida.");
            }
            // Se o carrinho ficou vazio após uma operação, sair do loop de gerenciamento
            if (carrinho.isEmpty() && gerenciando) {
                System.out.println("O carrinho está vazio. Retornando ao Menu Principal.");
                gerenciando = false;
            }
        }
    }

    private static int lerOpcaoDoUsuario() {
        int opcao = -1; // Valor padrão para indicar entrada inválida
        if (scanner.hasNextInt()) {
            opcao = scanner.nextInt();
        }
        scanner.nextLine(); // Consome a nova linha ou a entrada inválida
        return opcao;
    }
}