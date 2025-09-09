package com.example.sorveteria.dto;

import java.util.List;

public class PedidoDTO {
    private String cliente;
    private List<ItemDTO> itens;

    public static class ItemDTO {
        private Long sorveteId;
        private Integer quantidade;

        public Long getSorveteId() { return sorveteId; }
        public void setSorveteId(Long sorveteId) { this.sorveteId = sorveteId; }
        public Integer getQuantidade() { return quantidade; }
        public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }
    }

    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }
    public List<ItemDTO> getItens() { return itens; }
    public void setItens(List<ItemDTO> itens) { this.itens = itens; }
}
