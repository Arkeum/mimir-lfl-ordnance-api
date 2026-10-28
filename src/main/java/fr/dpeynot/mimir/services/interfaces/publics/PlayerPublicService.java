package fr.dpeynot.mimir.services.interfaces.publics;

import fr.dpeynot.mimir.dtos.players_dtos.PlayerGetOutputDto;
import fr.dpeynot.mimir.dtos.players_dtos.PlayerRegisterInputDto;
import fr.dpeynot.mimir.dtos.players_dtos.PlayerRegisterOutputDto;

import java.util.UUID;

public interface PlayerPublicService {
    PlayerRegisterOutputDto register(PlayerRegisterInputDto playerRegisterInputDto);
    PlayerGetOutputDto getByDiscordId(long discordId);
}
