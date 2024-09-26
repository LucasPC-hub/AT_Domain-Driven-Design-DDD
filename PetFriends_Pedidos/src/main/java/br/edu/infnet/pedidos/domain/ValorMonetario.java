package br.edu.infnet.pedidos.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ValorMonetario implements Serializable {

    private final BigDecimal quantia;

    @JsonCreator
    public ValorMonetario(@JsonProperty("quantia") BigDecimal quantia) {
        if (quantia == null) {
            throw new IllegalArgumentException("Quantia não pode ser nula");
        }
        this.quantia = quantia.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getQuantia() {
        return this.quantia;
    }

    public ValorMonetario somar(ValorMonetario outro) {
        if (outro == null) {
            throw new IllegalArgumentException("Outro valor não pode ser nulo");
        }
        return new ValorMonetario(this.quantia.add(outro.getQuantia()));
    }

    public ValorMonetario subtrair(ValorMonetario outro) {
        if (outro == null) {
            throw new IllegalArgumentException("Outro valor não pode ser nulo");
        }
        return new ValorMonetario(this.quantia.subtract(outro.getQuantia()));
    }

    @Override
    public boolean equals(Object objeto) {
        final ValorMonetario outro = (ValorMonetario) objeto;
        return Objects.equals(this.quantia, outro.getQuantia());
    }
}