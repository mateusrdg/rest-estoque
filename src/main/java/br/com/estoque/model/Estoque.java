package br.com.estoque.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class Estoque {

    private String sku;
    private Integer quantidade;

    @JsonProperty(value = "em_estoque")
    private Boolean emEstoque;

    public Estoque() {
    }

    public Estoque(String sku, Integer quantidade, Boolean emEstoque) {
        this.sku = sku;
        this.quantidade = quantidade;
        this.emEstoque = emEstoque;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Boolean getEmEstoque() {
        return emEstoque;
    }

    public void setEmEstoque(Boolean emEstoque) {
        this.emEstoque = emEstoque;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estoque estoque = (Estoque) o;
        return Objects.equals(sku, estoque.sku);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Estoque{");
        sb.append("sku='").append(sku).append('\'');
        sb.append(", quantidade=").append(quantidade);
        sb.append(", emEstoque=").append(emEstoque);
        sb.append('}');
        return sb.toString();
    }
}
