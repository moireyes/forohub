package com.proyecto.forohub.domain.dto;

import com.proyecto.forohub.domain.model.Status;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record TopicoActualizadoDTO(
        @NotNull Long id,
        String title,
        String message,
        Status status,
        @NotNull Long usuario_Id,
        String curso,
        LocalDateTime date
) {
}
