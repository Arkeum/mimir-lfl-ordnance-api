package fr.dpeynot.mimir.controllers;

import fr.dpeynot.mimir.dtos.players_dtos.PlayerGetOutputDto;
import fr.dpeynot.mimir.dtos.players_dtos.PlayerRegisterInputDto;
import fr.dpeynot.mimir.dtos.players_dtos.PlayerRegisterOutputDto;
import fr.dpeynot.mimir.services.interfaces.publics.PlayerPublicService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class PlayerController {

    private final PlayerPublicService playerService;

    @GetMapping("/players/discord_id/{discord_id}")
    public ResponseEntity<PlayerGetOutputDto> getPlayerByDiscordId(@PathVariable Long discord_id) {
        return ResponseEntity.ok(playerService.getByDiscordId(discord_id));
    }

//    @PostMapping("/players")
//    public ResponseEntity<PlayerRegisterOutputDto> registerPlayer(@RequestBody PlayerRegisterInputDto playerRegisterInputDto) {
//        return ResponseEntity.ok(playerService.register(playerRegisterInputDto));
//    }

}
