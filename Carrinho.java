import Produtos.Produto; // Assuming Produto class is in a package named 'Produtos'

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List; // For ordered display

public class Carrinho {
    // Usaremos um Map para armazenar o produto (como chave) e sua quantidade no carrinho (como valor)
    private Map<Produto, Integer> itens;

    public Carrinho() {
        this.itens = new HashMap<>();
        System.out.println("Carrinho de compras inicializado.");
    }

    /**
     * Adiciona uma quantidade de um produto ao carrinho.
     * Se o produto já existir, sua quantidade é incrementada.
     * Verifica o estoque antes de adicionar.
     *
     * @param produto O produto a ser adicionado.
     * @param quantidadeDesejada A quantidade do produto a ser adicionada.
     */
    public void adicionarItem(Produto produto, int quantidadeDesejada) {
        if (produto == null) {
            System.out.println("Erro: Não é possível adicionar um produto nulo ao carrinho.");
            return;
        }
        if (quantidadeDesejada <= 0) {
            System.out.println("Quantidade deve ser positiva para adicionar ao carrinho.");
            return;
        }

        // Verifica se a quantidade desejada (total no carrinho) excede o estoque
        int quantidadeJaNoCarrinho = this.itens.getOrDefault(produto, 0);
        int quantidadeTotalConsiderada = quantidadeJaNoCarrinho + quantidadeDesejada;

        if (produto.getQuantidade() < quantidadeTotalConsiderada) {
            System.out.println("Estoque insuficiente para '" + produto.getNome() + "'.");
            System.out.println("Disponível em estoque: " + produto.getQuantidade() + ". No carrinho já tem: " + quantidadeJaNoCarrinho + ". Tentando adicionar: " + quantidadeDesejada);
            return;
        }

        this.itens.put(produto, quantidadeTotalConsiderada);
        System.out.println(quantidadeDesejada + " x " + produto.getNome() + " adicionado(s) ao carrinho. Total no carrinho: " + quantidadeTotalConsiderada);
    }

    /**
     * Atualiza a quantidade de um item específico no carrinho para um novo total.
     * Se a nova quantidade for 0 ou menor, o item é removido.
     * Verifica o estoque para a nova quantidade.
     *
     * @param produto O produto cuja quantidade será atualizada.
     * @param novaQuantidadeTotal A nova quantidade total para o produto no carrinho.
     */
    public void atualizarQuantidadeItem(Produto produto, int novaQuantidadeTotal) {
        if (!this.itens.containsKey(produto)) {
            System.out.println("Produto '" + (produto != null ? produto.getNome() : "desconhecido") + "' não encontrado no carrinho para atualização.");
            return;
        }

        if (novaQuantidadeTotal <= 0) {
            removerItemPorCompleto(produto); // Remove se a nova quantidade for zero ou negativa
            return;
        }

        if (produto.getQuantidade() < novaQuantidadeTotal) {
            System.out.println("Estoque insuficiente para atualizar '" + produto.getNome() + "' para " + novaQuantidadeTotal + " unidades.");
            System.out.println("Disponível em estoque: " + produto.getQuantidade());
            return;
        }

        this.itens.put(produto, novaQuantidadeTotal);
        System.out.println("Quantidade de '" + produto.getNome() + "' atualizada para " + novaQuantidadeTotal + " no carrinho.");
    }

    /**
     * Remove uma certa quantidade de unidades de um produto do carrinho.
     * Se a quantidade a remover for maior ou igual à quantidade no carrinho, o produto é removido completamente.
     *
     * @param produto O produto do qual remover unidades.
     * @param quantidadeARemover A quantidade de unidades a serem removidas.
     */
    public void removerUnidadesItem(Produto produto, int quantidadeARemover) {
        if (!this.itens.containsKey(produto)) {
            System.out.println("Produto '" + (produto != null ? produto.getNome() : "desconhecido") + "' não encontrado no carrinho.");
            return;
        }
        if (quantidadeARemover <= 0) {
            System.out.println("Quantidade a remover deve ser positiva.");
            return;
        }

        int quantidadeAtual = this.itens.get(produto);
        if (quantidadeARemover >= quantidadeAtual) {
            this.itens.remove(produto);
            System.out.println("Todas as unidades de '" + produto.getNome() + "' foram removidas do carrinho.");
        } else {
            this.itens.put(produto, quantidadeAtual - quantidadeARemover);
            System.out.println(quantidadeARemover + " unidade(s) de '" + produto.getNome() + "' removida(s) do carrinho. Restam: " + (quantidadeAtual - quantidadeARemover));
        }
    }

    /**
     * Remove um produto completamente do carrinho, independentemente da sua quantidade.
     *
     * @param produto O produto a ser removido.
     */
    public void removerItemPorCompleto(Produto produto) {
        if (this.itens.remove(produto) != null) {
            System.out.println("Produto '" + produto.getNome() + "' removido completamente do carrinho.");
        } else {
            System.out.println("Produto '" + (produto != null ? produto.getNome() : "desconhecido") + "' não encontrado no carrinho para remoção completa.");
        }
    }

    /**
     * Exibe os itens no carrinho, seus preços, quantidades, subtotais e o total geral.
     * Retorna uma lista dos produtos na ordem em que foram exibidos, para facilitar a seleção por índice no Main.
     */
    public List<Produto> verCarrinho() {
        System.out.println("\n🛒 --- SEU CARRINHO DE COMPRAS --- 🛒");
        if (itens.isEmpty()) {
            System.out.println("Seu carrinho está vazio.");
            System.out.println("------------------------------------");
            return new ArrayList<>(); // Retorna lista vazia
        }

        // Para exibir em uma ordem consistente e permitir seleção por índice
        List<Produto> produtosOrdenados = new ArrayList<>(itens.keySet());
        double totalCarrinho = 0;
        int itemIndex = 1;

        for (Produto p : produtosOrdenados) {
            Integer quantidadeNoCarrinho = itens.get(p);
            double subtotalItem = p.getPreco() * quantidadeNoCarrinho;
            System.out.printf("%d. %s%n", itemIndex++, p.getNome());
            System.out.printf("   ID: %d | Qtd: %d | Preço Unit.: R$%.2f | Subtotal: R$%.2f%n",
                    p.getId(), quantidadeNoCarrinho, p.getPreco(), subtotalItem);
            totalCarrinho += subtotalItem;
        }
        System.out.println("------------------------------------");
        System.out.printf("TOTAL DO CARRINHO: R$%.2f%n", totalCarrinho);
        System.out.println("------------------------------------");
        return produtosOrdenados;
    }

    /**
     * Remove todos os itens do carrinho.
     */
    public void limparCarrinho() {
        if (itens.isEmpty()) {
            System.out.println("O carrinho já está vazio.");
        } else {
            this.itens.clear();
            System.out.println("Todos os itens foram removidos do carrinho.");
        }
    }

    /**
     * Finaliza a compra, reduzindo o estoque dos produtos comprados e limpando o carrinho.
     */
    public void finalizarCompra() {
        System.out.println("\n🏁 --- FINALIZANDO COMPRA --- 🏁");
        if (itens.isEmpty()) {
            System.out.println("Carrinho vazio. Nada a finalizar.");
            return;
        }

        // Re-exibe o carrinho para confirmação final
        List<Produto> produtosParaComprar = verCarrinho();
        double totalFinal = 0;

        // Verifica estoque novamente e calcula total (embora verCarrinho já o faça)
        for (Produto p : produtosParaComprar) {
            Integer quantidadeComprada = itens.get(p);
            if (p.getQuantidade() < quantidadeComprada) {
                // Esta verificação é uma segurança adicional; o ideal é que o estoque já esteja validado.
                System.out.println("ALERTA: Estoque de '" + p.getNome() + "' tornou-se insuficiente ("+p.getQuantidade()+" disponíveis). Este item não será processado.");
                // Poderia remover o item do map 'itens' aqui ou marcar para não processar
                continue; // Pula este item
            }
            totalFinal += p.getPreco() * quantidadeComprada;
        }

        System.out.printf("Confirmar compra no valor total de R$%.2f? (S/N): ", totalFinal);
        // No ambiente real, aqui você pegaria a entrada do usuário.
        // Para este exemplo, vamos simular a confirmação.
        // Scanner scanner = new Scanner(System.in); String confirmacao = scanner.nextLine();
        // if (!confirmacao.equalsIgnoreCase("S")) { System.out.println("Compra cancelada."); return; }

        System.out.println("\nProcessando pagamento e atualizando estoque...");

        boolean compraBemSucedida = true;
        for (Produto p : produtosParaComprar) {
            Integer quantidadeComprada = itens.get(p); // Pega a quantidade do map original
            if (quantidadeComprada == null) continue; // Item pode ter sido removido devido à verificação de estoque acima

            if (!p.reduzirEstoque(quantidadeComprada)) {
                // Mensagem de erro já é impressa por reduzirEstoque()
                System.out.println("FALHA AO PROCESSAR: '" + p.getNome() + "'. A compra deste item não será concluída.");
                compraBemSucedida = false;
                // Aqui você decidiria como lidar com falhas parciais (ex: remover da cobrança, etc.)
            } else {
                System.out.println("'" + p.getNome() + "' (" + quantidadeComprada + " un.) processado com sucesso.");
            }
        }

        if (compraBemSucedida && totalFinal > 0) { // Se houve algum item processado com sucesso
            System.out.println("\n✅ Compra finalizada com sucesso!");
            System.out.printf("Valor total pago: R$%.2f%n", totalFinal); // Recalcular o total apenas dos itens processados seria mais preciso aqui
        } else if (totalFinal == 0 && !itens.isEmpty()){
            System.out.println("\n⚠️ Nenhum item pôde ser processado devido a problemas de estoque. Compra não realizada.");
        } else {
            System.out.println("\n⚠️ Compra finalizada com algumas falhas. Verifique os itens acima.");
        }

        itens.clear(); // Limpa o carrinho após a tentativa de compra
        System.out.println("Obrigado por comprar conosco.");
    }

    /**
     * Retorna o número de tipos de produtos diferentes no carrinho.
     * @return O número de chaves no mapa de itens.
     */
    public int getNumeroDeTiposDeItens() {
        return itens.size();
    }

    /**
     * Verifica se o carrinho está vazio.
     * @return true se o carrinho não contiver itens, false caso contrário.
     */
    public boolean isEmpty() {
        return itens.isEmpty();
    }
}