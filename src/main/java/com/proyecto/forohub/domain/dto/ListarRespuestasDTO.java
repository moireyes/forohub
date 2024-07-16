package com.proyecto.forohub.domain.dto;

import com.proyecto.forohub.domain.model.Respuesta;

import java.time.LocalDateTime;

public record ListarRespuestasDTO(Long id,
                                String solution,
                                Long usuario_Id,
                                Long topico_Id,
                                LocalDateTime creationDate) {
    public ListarRespuestasDTO(Respuesta respuesta){
        this(respuesta.getId(),
                respuesta.getSolution(),
                respuesta.getAuthor().getId(),
                respuesta.getTopico().getId(),
                respuesta.getCreationDate());
    }
}
