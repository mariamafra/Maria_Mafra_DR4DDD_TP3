package com.example.Maria_Mafra_DR4_TP3.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@Entity
public class Pedido {
    @AggregateIdentifier
    @Id
    private String id;
    private String cliente;
    private double valorTotal;

    public Pedido() {}

    @CommandHandler
    public Pedido(CriarPedidoCommand command) {
        AggregateLifecycle.apply(new PedidoCriadoEvent(command.id, command.cliente, command.valorTotal));
    }

    @EventSourcingHandler
    protected void on(PedidoCriadoEvent event) {
        this.id = event.id;
        this.cliente = event.cliente;
        this.valorTotal = event.valorTotal;
    }
}
