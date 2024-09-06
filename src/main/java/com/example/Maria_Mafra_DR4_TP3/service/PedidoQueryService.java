package com.example.Maria_Mafra_DR4_TP3.service;

import com.example.Maria_Mafra_DR4_TP3.model.Pedido;
import com.example.Maria_Mafra_DR4_TP3.repository.PedidoRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoQueryService {

    private final EventStore eventStore;

    @Autowired
    public PedidoQueryService(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    public List<Object> getEventsForPedido(String pedidoId) {
        return eventStore.readEvents(pedidoId)
                .asStream()
                .map(eventMessage -> eventMessage.getPayload())
                .collect(Collectors.toList());
    }

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido findPedidoById(String id) {
        return pedidoRepository.findById(id).orElse(null);
    }
}
