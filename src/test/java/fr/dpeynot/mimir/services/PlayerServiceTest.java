package fr.dpeynot.mimir.services;

import fr.dpeynot.mimir.domain.PlayerEntity;
import fr.dpeynot.mimir.dtos.players_dtos.PlayerRegisterInputDto;
import fr.dpeynot.mimir.exceptions.DuplicateResourceException;
import fr.dpeynot.mimir.exceptions.ResourceNotFoundException;
import fr.dpeynot.mimir.services.interfaces.internals.PlayerInternalService;
import fr.dpeynot.mimir.services.interfaces.publics.PlayerPublicService;
import jakarta.validation.ConstraintViolationException;
import lombok.AllArgsConstructor;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AllArgsConstructor(onConstructor_ = @Autowired)
public class PlayerServiceTest {
    private final PlayerInternalService playerService;
    private final PlayerPublicService playerPublicService;

    @Test
    @Transactional
    public void register_Success(){
        PlayerRegisterInputDto player = new PlayerRegisterInputDto("Player",123456789);

        Assert.assertNotNull(playerService.register(player).id());
    }

    @Test
    @Transactional
    public void register_Failure_DuplicateResourceException(){
        PlayerRegisterInputDto player = new PlayerRegisterInputDto("Player",123456789);

        playerService.register(player);

        Assert.assertThrows(DuplicateResourceException.class, () -> playerService.register(player));
    }

    @Test
    @Transactional
    public void register_Failure_NullParameter(){
        Assert.assertThrows(ConstraintViolationException.class, () -> playerService.register(null));
    }

    @Test
    @Transactional
    public void getByDiscordId_Success(){
        PlayerRegisterInputDto player = new PlayerRegisterInputDto("Player",123456789);

        playerService.register(player);

        Assert.assertNotNull(playerPublicService.getByDiscordId(123456789));
    }

    @Test
    @Transactional
    public void getByDiscordId_Failure_EqualsZero(){
        Assert.assertThrows(ConstraintViolationException.class, () -> playerPublicService.getByDiscordId(0));
    }

    @Test
    @Transactional
    public void getByDiscordId_Failure_ResourceNotFoundException(){
        Assert.assertThrows(ResourceNotFoundException.class, () -> playerPublicService.getByDiscordId(1));

    }
}
