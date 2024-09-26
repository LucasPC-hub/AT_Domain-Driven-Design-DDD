package edu.infnet.petfrieds_almoxarifado.domain;

import edu.infnet.petfrieds_almoxarifado.domain.vo.DetalhesProduto;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Almoxarifado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String localizacao;

    @Embedded
    private DetalhesProduto detalhesProduto;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public DetalhesProduto getDetalhesProduto() {
        return detalhesProduto;
    }

    public void setDetalhesProduto(DetalhesProduto detalhesProduto) {
        this.detalhesProduto = detalhesProduto;
    }
}