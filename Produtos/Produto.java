package Produtos;

public class Produto {
    private static int proximoId = 1; // Contador estático para IDs únicos
    protected int id;
    protected String nome;
    protected double preco;
    protected int quantidade; // Quantidade em estoque

    public Produto(String nome, double preco, int quantidade) {
        this.id = proximoId++;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    // Setters (opcional, mas útil para gerenciamento)
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        if (preco >= 0) {
            this.preco = preco;
        } else {
            System.out.println("Preço não pode ser negativo.");
        }
    }

    // Métodos para gerenciamento de estoque
    public void aumentarEstoque(int quantidadeAdicional) {
        if (quantidadeAdicional > 0) {
            this.quantidade += quantidadeAdicional;
        } else {
            System.out.println("Quantidade a adicionar deve ser positiva.");
        }
    }

    public boolean reduzirEstoque(int quantidadeRemover) {
        if (quantidadeRemover <= 0) {
            System.out.println("Quantidade a remover deve ser positiva.");
            return false;
        }
        if (this.quantidade >= quantidadeRemover) {
            this.quantidade -= quantidadeRemover;
            return true; // Remoção bem-sucedida
        } else {
            System.out.println("Estoque insuficiente para remover " + quantidadeRemover + " unidades de " + this.nome + ". Disponível: " + this.quantidade);
            return false; // Estoque insuficiente
        }
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Preço: R$" + String.format("%.2f", preco) + ", Estoque: " + quantidade;
    }
}