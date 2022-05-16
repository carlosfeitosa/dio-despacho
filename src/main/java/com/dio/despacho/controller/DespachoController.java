package com.dio.despacho.controller;

import java.util.UUID;

import com.dio.despacho.business.dto.DespachoResponseDTO;
import com.dio.despacho.business.dto.PedidoRequestDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@AllArgsConstructor
public final class DespachoController {

    private static final int TEMPO_PROCESSAMENTO = 5000;

    @PostMapping("v1/despacharPedido")
    public ResponseEntity<DespachoResponseDTO> despacharPedido(
            final @RequestBody PedidoRequestDTO pedido) {

        UUID despachoId = processar(pedido);

        DespachoResponseDTO response = new DespachoResponseDTO(despachoId.toString());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private UUID processar(PedidoRequestDTO pedido) {

        UUID idDespacho = UUID.randomUUID();

        try {

            log.info("Despachando pedido...");
            log.debug("Despacho: {}", idDespacho);
            log.debug("Pedido completo: {}", pedido.toString());

            log.info("Estado 9: Aguardando despacho");

            Thread.sleep(TEMPO_PROCESSAMENTO);

            log.info("Estado 10: Compra despachada");

        } catch (InterruptedException e) {

            log.warn("Interrupted!", e);

            Thread.currentThread().interrupt();
        }

        return idDespacho;
    }
}
