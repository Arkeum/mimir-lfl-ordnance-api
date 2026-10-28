package fr.dpeynot.mimir.dtos.players_dtos;

import jakarta.validation.constraints.NotBlank;

public record PlayerRegisterInputDto(
        @NotBlank
        String name,

        @NotBlank
        long discordId
) {
}
