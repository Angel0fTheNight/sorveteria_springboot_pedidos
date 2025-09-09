package com.example.sorveteria.model;

import jakarta.persistence.*;

@Entity
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Sorvete sorvete;

    @ManyToOne(optional = false)
    private Pedido pedido;

    private Integer quantidade;
    private Double subtotal;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Sorvete getSorvete() { return sorvete; }
    public void setSorvete(Sorvete sorvete) { this.sorvete = sorvete; }
    public Pedido getPedido() { return pedido; }
    public void setPedido(Pedido pedido) { this.pedido = pedido; }
    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }
    public Double getSubtotal() { return subtotal; }
    public void setSubtotal(Double subtotal) { this.subtotal = subtotal; }
}
