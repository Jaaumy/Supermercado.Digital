package Produtos;

public class Automobilismo extends Produto {
    private String aplicacao; // Ex: Óleo de Motor, Pneu, Aditivo
    private String marcaVeiculoCompativel; // Ex: "Universal", "Fiat", "Ford"

    public Automobilismo(String nome, double preco, int quantidade, String aplicacao, String marcaVeiculoCompativel) {
        super(nome, preco, quantidade);
        this.aplicacao = aplicacao;
        this.marcaVeiculoCompativel = marcaVeiculoCompativel;
    }

    public String getAplicacao() {
        return aplicacao;
    }

    public void setAplicacao(String aplicacao) {
        this.aplicacao = aplicacao;
    }

    public String getMarcaVeiculoCompativel() {
        return marcaVeiculoCompativel;
    }

    public void setMarcaVeiculoCompativel(String marcaVeiculoCompativel) {
        this.marcaVeiculoCompativel = marcaVeiculoCompativel;
    }

    @Override
    public String toString() {
        return super.toString() + ", Aplicação: " + aplicacao + ", Compatibilidade: " + marcaVeiculoCompativel;
    }
}