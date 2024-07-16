package com.proyecto.forohub.domain.repository;

import com.proyecto.forohub.domain.dto.RegistroUsuarioDTO;

public interface ValidadorDeUsuario {

    public void validate(RegistroUsuarioDTO RegistroUsuarioDTO);
}