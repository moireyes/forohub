package com.proyecto.forohub.domain.service;

import com.proyecto.forohub.domain.dto.RespuestaTopicoDTO;
import com.proyecto.forohub.domain.dto.TopicoDTO;
import com.proyecto.forohub.domain.model.Topico;
import com.proyecto.forohub.domain.repository.TopicoRepository;
import com.proyecto.forohub.domain.repository.UsuarioRepository;
import com.proyecto.forohub.infra.error.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public RespuestaTopicoDTO topicoCreado(TopicoDTO topicoDTO){
        if (!usuarioRepository.findById(topicoDTO.usuario_Id()).isPresent()){
            throw new ValidacionDeIntegridad("Este ID de usuario no está registrado en la base de datos.");
        }
        var title= topicoDTO.title();
        if (title != null && topicoRepository.existsByTitleIgnoreCase(title)){
            throw new ValidacionDeIntegridad("Este título ya está presente en la base de datos. Por favor revise el tópico existente.");
        }
        String message = topicoDTO.message();
        if (message != null && topicoRepository.existsByMessageIgnoreCase(message)){
            throw new ValidacionDeIntegridad("Este mensaje ya está presente en la base de datos. Por favor revise el tópico existente.");
        }
        var usuario = usuarioRepository.findById(topicoDTO.usuario_Id()).get();
        var topicoId= new Topico(null,title,message,topicoDTO.date(),topicoDTO.status(),usuario,topicoDTO.curso());
        topicoRepository.save(topicoId);
        return new RespuestaTopicoDTO(topicoId);
    }
}