package fr.dpeynot.mimir.utilities.mappers;


import fr.dpeynot.mimir.domain.PlayerEntity;
import fr.dpeynot.mimir.dtos.players_dtos.PlayerGetOutputDto;
import fr.dpeynot.mimir.dtos.players_dtos.PlayerRegisterInputDto;
import fr.dpeynot.mimir.dtos.players_dtos.PlayerRegisterOutputDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

    PlayerGetOutputDto toPlayerGetDto(PlayerEntity playerEntity);

    PlayerEntity toPlayerEntity(PlayerRegisterInputDto playerRegisterInputDto);

    PlayerRegisterOutputDto toPlayerRegisterOutputDto(PlayerEntity playerEntity);
}
