package models;

public class Transacao {
        private String tipo; // "Receita" ou "Despesa"
        private String descricao;
        private double valor;

    public Transacao(String tipo, String descricao, double valor, double data) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Transacao(String tipo, String descricao, double valor, String data) {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
