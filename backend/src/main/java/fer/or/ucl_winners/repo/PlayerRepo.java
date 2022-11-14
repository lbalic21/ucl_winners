package fer.or.ucl_winners.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fer.or.ucl_winners.model.Player;

public interface PlayerRepo extends JpaRepository<Player, Integer> {
    public void deletePlayerById(Integer id);
    public Optional<Player> findPlayerById(Integer id);
    public List<Player> findByNameContainingIgnoreCase(String name);
}
