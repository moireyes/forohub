package com.proyecto.forohub.domain.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record RespuestaActualizadaDTO(
        @NotNull Long id,
        String solution,
        @NotNull Long usuario_Id,
        @NotNull Long topico_Id,
        LocalDateTime creationDate
) {
}