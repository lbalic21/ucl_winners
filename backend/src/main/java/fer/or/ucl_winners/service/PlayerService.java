package fer.or.ucl_winners.service;

import java.util.List;
//import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fer.or.ucl_winners.repo.PlayerRepo;
import fer.or.ucl_winners.exeption.PersonNotFoundExeption;
import fer.or.ucl_winners.model.Player;

@Service
public class PlayerService {
    private final PlayerRepo playerRepo;

    @Autowired
    public PlayerService(PlayerRepo playerRepo) {
        this.playerRepo = playerRepo;
    }

    public Player addPlayer(Player player) {
        //player.setId(Integer.valueOf(UUID.randomUUID()));
        return playerRepo.save(player);
    }

    public List<Player> findAllPlayers() {
        return playerRepo.findAll();
    }

    public Player updatePlayer(Player player) {
        return playerRepo.save(player);
    }

    public Player findPlayerById(Integer id) {
        return (Player) playerRepo.findPlayerById(id).orElseThrow(() -> new PersonNotFoundExeption("Player by id " + id + " was not found."));
    }

    public void deletePlayer(Integer id) {
        playerRepo.deletePlayerById(id);
    }

    public List<Player> findPlayer(String value) {
        return playerRepo.findByNameContainingIgnoreCase(value.toLowerCase());
    }
}