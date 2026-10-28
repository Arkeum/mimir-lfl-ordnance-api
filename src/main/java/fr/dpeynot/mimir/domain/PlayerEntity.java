package fr.dpeynot.mimir.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Primary;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "players")
@Getter
@Setter
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String name;

    @Column
    private long discordId;

    @Column
    private LocalDateTime registrationDate;

    @Column
    private LocalDateTime lastSeen;
}
