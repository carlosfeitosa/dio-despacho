package com.dio.despacho.servicebus;

import com.dio.despacho.business.dto.PedidoRequestDTO;
import com.dio.despacho.controller.DespachoController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@AllArgsConstructor
public class QueueConsumer {

    private DespachoController controller;

    @RabbitListener(queues = { "${queue.name.despacho}" })
    public void receive(@Payload String payload) {

        ObjectMapper objectMapper = new ObjectMapper();

        PedidoRequestDTO pedido = new PedidoRequestDTO();

        try {

            pedido = objectMapper.readValue(payload, PedidoRequestDTO.class);

        } catch (JsonProcessingException e) {

            e.printStackTrace();
        }

        controller.despacharPedido(pedido);
    }
}
