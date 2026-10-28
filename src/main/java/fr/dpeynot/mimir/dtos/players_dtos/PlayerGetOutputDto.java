package fr.dpeynot.mimir.dtos.players_dtos;


import java.time.LocalDateTime;
import java.util.UUID;

public record PlayerGetOutputDto(
        UUID id,
        String name,
        long discordId,
        LocalDateTime registrationDate,
        LocalDateTime lastSeen
){};
