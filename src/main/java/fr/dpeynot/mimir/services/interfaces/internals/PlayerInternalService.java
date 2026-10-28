package fr.dpeynot.mimir.services.interfaces.internals;

import fr.dpeynot.mimir.dtos.players_dtos.PlayerRegisterInputDto;
import fr.dpeynot.mimir.dtos.players_dtos.PlayerRegisterOutputDto;

import java.util.UUID;

public interface PlayerInternalService {
    PlayerRegisterOutputDto register(PlayerRegisterInputDto playerRegisterInputDto);
}
