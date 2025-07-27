package com.gamershall.api.model.input;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JogoIdInput {

    @NotNull
    private Long id;
}
