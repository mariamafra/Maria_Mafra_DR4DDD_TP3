//package com.example.Maria_Mafra_DR4_TP3.controller;
//
//import com.example.Maria_Mafra_DR4_TP3.model.Pedido;
//import com.example.Maria_Mafra_DR4_TP3.service.PedidoQueryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//public class PedidoQueryController {
//
//    @Autowired
//    private PedidoQueryService pedidoQueryService;
//
//    @GetMapping("/pedidos/{id}/events")
//    public List<Object> getPedidoEvents(@PathVariable String id) {
//        return pedidoQueryService.getEventsForPedido(id);
//    }
//
//    @GetMapping("/pedidos/{id}")
//    public Pedido getPedidoById(@PathVariable String id) {
//        return pedidoQueryService.findPedidoById(id);
//    }
//}
