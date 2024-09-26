package edu.infnet.petfrieds_almoxarifado.domain.vo;

import java.util.Objects;

public class DetalhesProduto {

    private final String descricao;
    private final int quantidade;
    private final double preco;

    public DetalhesProduto(String descricao, int quantidade, double preco) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetalhesProduto that = (DetalhesProduto) o;
        return quantidade == that.quantidade &&
                Double.compare(that.preco, preco) == 0 &&
                Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descricao, quantidade, preco);
    }

    @Override
    public String toString() {
        return "DetalhesProduto{" +
                "descricao='" + descricao + '\'' +
                ", quantidade=" + quantidade +
                ", preco=" + preco +
                '}';
    }
}