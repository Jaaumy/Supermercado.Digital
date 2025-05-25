package Produtos;

public class Bebida extends Produto {
    private double volumeLitros;
    private boolean alcoolica;

    // ESTE É O CONSTRUTOR CORRETO COM 5 PARÂMETROS
    public Bebida(String nome, double preco, int quantidade, double volumeLitros, boolean alcoolica) {
        super(nome, preco, quantidade);
        this.volumeLitros = volumeLitros;
        this.alcoolica = alcoolica;
    }

    public double getVolumeLitros() {
        return volumeLitros;
    }

    public void setVolumeLitros(double volumeLitros) {
        if (volumeLitros > 0) {
            this.volumeLitros = volumeLitros;
        }
    }

    public boolean isAlcoolica() {
        return alcoolica;
    }

    public void setAlcoolica(boolean alcoolica) {
        this.alcoolica = alcoolica;
    }

    @Override
    public String toString() {
        return super.toString() + ", Volume: " + String.format("%.3f", volumeLitros) + "L, Alcoólica: " + (alcoolica ? "Sim" : "Não");
    }
}