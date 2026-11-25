package fr.dpeynot.mimir.services.interfaces.publics;

import fr.dpeynot.mimir.dtos.players_dtos.PlayerGetOutputDto;
import fr.dpeynot.mimir.dtos.players_dtos.PlayerRegisterInputDto;
import fr.dpeynot.mimir.dtos.players_dtos.PlayerRegisterOutputDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Validated
public interface PlayerPublicService {
    PlayerGetOutputDto getByDiscordId(@Positive long discordId);
    //PlayerRegisterOutputDto register(@NotNull @Valid PlayerRegisterInputDto playerRegisterInputDto);

}
