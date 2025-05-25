package Produtos;

public class Hortifruti extends Produto {
    private String tipo; // Ex: Fruta, Verdura, Legume
    private String origem; // Ex: Nacional, Importado

    public Hortifruti(String nome, double preco, int quantidade, String tipo, String origem) {
        super(nome, preco, quantidade);
        this.tipo = tipo;
        this.origem = origem;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipo: " + tipo + ", Origem: " + origem;
    }
}