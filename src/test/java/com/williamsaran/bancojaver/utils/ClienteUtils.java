package com.williamsaran.bancojaver.utils;

import com.williamsaran.bancojaver.model.ClienteDTO;

public class ClienteUtils {
    public static final Long ID = 1L;
    public static final String NOME = "Fulano";
    public static final String TELEFONE = "11999999999";
    public static final Boolean CORRENTISTA = true;
    public static final Float SCORE_CREDITO = 800F;
    public static final Float SALDO = 1000F;

    public static ClienteDTO criarDTOMock() {
        var cliente = new ClienteDTO();

        cliente.setId(ID);
        cliente.setNome(NOME);
        cliente.setTelefone(TELEFONE);
        cliente.setCorrentista(CORRENTISTA);
        cliente.setScoreCredito(SCORE_CREDITO);
        cliente.setSaldo(SALDO);

        return cliente;
    }
}
