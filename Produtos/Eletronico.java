package Produtos;

public class Eletronico extends Produto {
    private String marca;
    private int garantiaMeses; // Tempo de garantia em meses
    private String voltagem; // Ex: 110V, 220V, Bivolt

    public Eletronico(String nome, double preco, int quantidade, String marca, int garantiaMeses, String voltagem) {
        super(nome, preco, quantidade);
        this.marca = marca;
        this.garantiaMeses = garantiaMeses;
        this.voltagem = voltagem;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getGarantiaMeses() {
        return garantiaMeses;
    }

    public void setGarantiaMeses(int garantiaMeses) {
        if (garantiaMeses >= 0) {
            this.garantiaMeses = garantiaMeses;
        }
    }

    public String getVoltagem() {
        return voltagem;
    }

    public void setVoltagem(String voltagem) {
        this.voltagem = voltagem;
    }

    @Override
    public String toString() {
        return super.toString() + ", Marca: " + marca + ", Garantia: " + garantiaMeses + " meses, Voltagem: " + voltagem;
    }
}