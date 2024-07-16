package com.proyecto.forohub.domain.dto;

import com.proyecto.forohub.domain.model.Respuesta;

import java.time.LocalDateTime;

public record RespuestaCreadaDTO(
        Long id,
        String solution,
        Long usuario_Id,
        Long topico_Id,
        LocalDateTime creationDate
) {
    public RespuestaCreadaDTO(Respuesta rVerified) {
        this(rVerified.getId(),rVerified.getSolution(),rVerified.getAuthor().getId(),rVerified.getTopico().getId(),rVerified.getCreationDate());
    }
}