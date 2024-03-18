package br.senai.devtubarao.enums;

public enum Operacao {
    none(0), ADICIONAR(1), LISTAR(2), SAIR(3);

    private int valor;

    Operacao(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
