package com.example.Maria_Mafra_DR4_TP3.service;

import com.example.Maria_Mafra_DR4_TP3.model.CriarPedidoCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class PedidoCommandService {
    private final CommandGateway commandGateway;

    @Autowired
    public PedidoCommandService(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public CompletableFuture<String> criarPedido(String cliente, double valorTotal) {
        String id = UUID.randomUUID().toString();
        CriarPedidoCommand command = new CriarPedidoCommand(id, cliente, valorTotal);
        return commandGateway.send(command);
    }
}

