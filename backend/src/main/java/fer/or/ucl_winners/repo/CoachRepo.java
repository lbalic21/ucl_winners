package fer.or.ucl_winners.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fer.or.ucl_winners.model.Coach;

public interface CoachRepo extends JpaRepository<Coach, Integer> {
    public void deleteCoachById(Integer id);
    public Optional<Coach> findCoachById(Integer id);
    public List<Coach> findByNameContainingIgnoreCase(String name);
}