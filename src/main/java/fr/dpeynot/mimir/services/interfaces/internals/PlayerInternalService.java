package fr.dpeynot.mimir.services.interfaces.internals;

import fr.dpeynot.mimir.dtos.players_dtos.PlayerRegisterInputDto;
import fr.dpeynot.mimir.dtos.players_dtos.PlayerRegisterOutputDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

public interface PlayerInternalService {
    PlayerRegisterOutputDto register(@NotNull @Valid PlayerRegisterInputDto playerRegisterInputDto);
}
