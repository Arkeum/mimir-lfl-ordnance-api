package fr.dpeynot.mimir.services;

import fr.dpeynot.mimir.domain.PlayerEntity;
import fr.dpeynot.mimir.dtos.players_dtos.PlayerGetOutputDto;
import fr.dpeynot.mimir.dtos.players_dtos.PlayerRegisterInputDto;
import fr.dpeynot.mimir.dtos.players_dtos.PlayerRegisterOutputDto;
import fr.dpeynot.mimir.exceptions.DuplicateResourceException;
import fr.dpeynot.mimir.exceptions.ResourceNotFoundException;
import fr.dpeynot.mimir.repositories.PlayerRepository;
import fr.dpeynot.mimir.services.interfaces.internals.PlayerInternalService;
import fr.dpeynot.mimir.services.interfaces.publics.PlayerPublicService;
import fr.dpeynot.mimir.utilities.mappers.PlayerMapper;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PlayerServiceImp implements PlayerPublicService, PlayerInternalService {
    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    @Transactional
    public PlayerRegisterOutputDto register(PlayerRegisterInputDto playerRegisterInputDto) {
        playerRepository.findByDiscordId((playerRegisterInputDto.discordId()))
                .ifPresent(player -> {
                    throw new DuplicateResourceException("Player "+player.getDiscordId()+" already exists");
                });

        PlayerEntity playerEntity = playerMapper.toPlayerEntity(playerRegisterInputDto);

        LocalDateTime transactionDateTime = LocalDateTime.now();
        playerEntity.setRegistrationDate(transactionDateTime);
        playerEntity.setLastSeen(transactionDateTime);

        playerRepository.save(playerEntity);

        return playerMapper.toPlayerRegisterOutputDto(playerEntity);
    }

    @Transactional
    public PlayerGetOutputDto getByDiscordId(long discordId) {
        PlayerEntity player = playerRepository.findByDiscordId(discordId)
                .orElseThrow(() -> new ResourceNotFoundException("Player not found"));

        return playerMapper.toPlayerGetDto(player);
    }

}
