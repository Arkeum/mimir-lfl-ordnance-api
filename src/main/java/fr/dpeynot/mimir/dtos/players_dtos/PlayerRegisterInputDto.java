package fr.dpeynot.mimir.dtos.players_dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record PlayerRegisterInputDto(
        @NotBlank
        String name,

        @Positive
        long discordId
) {
}
