package fr.dpeynot.mimir.dtos.players_dtos;


import fr.dpeynot.mimir.enumerations.PlayerStatusEnum;

import java.time.LocalDateTime;
import java.util.UUID;

public record PlayerGetOutputDto(
        UUID id,
        String name,
        long discordId,
        PlayerStatusEnum status,
        LocalDateTime registrationDate,
        LocalDateTime lastSeen
){};
