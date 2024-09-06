package com.example.Maria_Mafra_DR4_TP3.model;

public class PedidoCriadoEvent extends BaseEvent<String> {
    public final String cliente;
    public final double valorTotal;

    public PedidoCriadoEvent(String id, String cliente, double valorTotal) {
        super(id);
        this.cliente = cliente;
        this.valorTotal = valorTotal;
    }
}

