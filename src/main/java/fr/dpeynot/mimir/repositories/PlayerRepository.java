package fr.dpeynot.mimir.repositories;

import fr.dpeynot.mimir.domain.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, UUID> {

    Optional<PlayerEntity> findByDiscordId(long discordId);
}
