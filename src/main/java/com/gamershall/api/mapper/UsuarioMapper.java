package com.gamershall.api.mapper;

import com.gamershall.api.model.UsuarioModel;
import com.gamershall.api.model.input.UsuarioInput;
import com.gamershall.domain.model.Usuario;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class UsuarioMapper {

    private final ModelMapper modelMapper;

    public UsuarioModel toModel(Usuario usuario){
        return modelMapper.map(usuario, UsuarioModel.class);
    }

    public Usuario toEntity(UsuarioInput usuarioInput){
        return modelMapper.map(usuarioInput, Usuario.class);
    }

    public List<UsuarioModel> toModelList(List<Usuario> usuarios){
        return usuarios.stream()
                .map(usuario -> modelMapper.map(usuario, UsuarioModel.class))
                .toList();
    }
}
