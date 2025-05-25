package Produtos;

public class Carne extends Produto {
    private String tipoAnimal; // Ex: Bovina, Suína, Ave, Peixe
    private String corte; // Ex: Picanha, Alcatra, Filé de Peito

    public Carne(String nome, double preco, int quantidade, String tipoAnimal, String corte) {
        super(nome, preco, quantidade); // 'nome' aqui pode ser o nome específico do corte, ex: "Picanha Bovina"
        this.tipoAnimal = tipoAnimal;
        this.corte = corte;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public String getCorte() {
        return corte;
    }

    public void setCorte(String corte) {
        this.corte = corte;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipo: " + tipoAnimal + ", Corte: " + corte;
    }
}