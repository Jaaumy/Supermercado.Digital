package Produtos;

public class Esporte extends Produto {
    private String modalidade; // Ex: Futebol, Basquete, Natação, Fitness
    private String publicoAlvo; // Ex: Adulto, Infantil, Profissional

    public Esporte(String nome, double preco, int quantidade, String modalidade, String publicoAlvo) {
        super(nome, preco, quantidade);
        this.modalidade = modalidade;
        this.publicoAlvo = publicoAlvo;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getPublicoAlvo() {
        return publicoAlvo;
    }

    public void setPublicoAlvo(String publicoAlvo) {
        this.publicoAlvo = publicoAlvo;
    }

    @Override
    public String toString() {
        return super.toString() + ", Modalidade: " + modalidade + ", Público: " + publicoAlvo;
    }
}