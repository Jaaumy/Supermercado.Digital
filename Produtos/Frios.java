package Produtos;

public class Frios extends Produto {
    private String marca;
    private boolean fatiado; // Indica se o produto é vendido fatiado ou em peça

    public Frios(String nome, double preco, int quantidade, String marca, boolean fatiado) {
        super(nome, preco, quantidade); // 'quantidade' aqui pode ser em KG se o preço for por KG, ou unidades.
        this.marca = marca;
        this.fatiado = fatiado;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public boolean isFatiado() {
        return fatiado;
    }

    public void setFatiado(boolean fatiado) {
        this.fatiado = fatiado;
    }

    @Override
    public String toString() {
        // Se o preço for por KG, a quantidade em estoque pode representar o peso disponível.
        // A forma de exibir pode precisar de ajuste dependendo de como você gerencia o estoque (unidade vs peso)
        return super.toString() + ", Marca: " + marca + ", Fatiado: " + (fatiado ? "Sim" : "Não");
    }
}