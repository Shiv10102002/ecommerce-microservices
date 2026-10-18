package com.github.hvalmer.icompras.orders.client.representation;

public record CustomerRepresentation(
        Long codigo,
        String nome,
        String cpf,
        String logradouro,
        String numero,
        String bairro,
        String email,
        String telefone
) {
}
