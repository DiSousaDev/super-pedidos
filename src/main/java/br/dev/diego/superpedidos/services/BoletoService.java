package br.dev.diego.superpedidos.services;

import br.dev.diego.superpedidos.entities.PagamentoComBoleto;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
public class BoletoService {

    public void preencherPagamentoComBoleto(PagamentoComBoleto pgto, Instant instant) {
        instant.plus(7, ChronoUnit.DAYS);
        pgto.setDataVencimento(Date.from(instant));
    }

}
