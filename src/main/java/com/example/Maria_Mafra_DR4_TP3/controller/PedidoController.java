package com.example.Maria_Mafra_DR4_TP3.controller;

import com.example.Maria_Mafra_DR4_TP3.model.CriarPedidoCommand;
import com.example.Maria_Mafra_DR4_TP3.model.Pedido;
import com.example.Maria_Mafra_DR4_TP3.service.PedidoCommandService;
import com.example.Maria_Mafra_DR4_TP3.service.PedidoQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
public class PedidoController {

    private final PedidoCommandService pedidoCommandService;

    @Autowired
    public PedidoController(PedidoCommandService pedidoCommandService) {
        this.pedidoCommandService = pedidoCommandService;
    }

    @PostMapping("/pedidos")
    public CompletableFuture<String> criarPedido(@RequestBody CriarPedidoCommand command) {
        return pedidoCommandService.criarPedido(command.cliente, command.valorTotal);
    }

    @Autowired
    private PedidoQueryService pedidoQueryService;

    @GetMapping("/pedidos/{id}/events")
    public List<Object> getPedidoEvents(@PathVariable String id) {
        return pedidoQueryService.getEventsForPedido(id);
    }

    @GetMapping("/pedidos/{id}")
    public Pedido getPedidoById(@PathVariable String id) {
        return pedidoQueryService.findPedidoById(id);
    }
}
