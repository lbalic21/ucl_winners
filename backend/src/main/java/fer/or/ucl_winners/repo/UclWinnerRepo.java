package fer.or.ucl_winners.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fer.or.ucl_winners.model.Coach;
import fer.or.ucl_winners.model.Player;
import fer.or.ucl_winners.model.UclWinner;

public interface UclWinnerRepo extends JpaRepository<UclWinner, Integer> {
    public void deleteUclWinnerById(Integer id);
    public Optional<UclWinner> findUclWinnerById(Integer id);
    public List<UclWinner> findByClubContainingIgnoreCase(String value);
    public List<UclWinner> findByCityContainingIgnoreCase(String value);
    public List<UclWinner> findByCountryContainingIgnoreCase(String value);
    //public List<UclWinner> findByYearContainingIgnoreCase(Integer value);
    public List<UclWinner> findByFinalStadiumContainingIgnoreCase(String value);
    public List<UclWinner> findByFinalMatchupContainingIgnoreCase(String value);
    public List<UclWinner> findByResultContainingIgnoreCase(String value);
    //public List<UclWinner> findByAttendanceContainingIgnoreCase(Integer value);
    public List<UclWinner> findByHeadCoach(Coach head_coach);
    public List<UclWinner> findByCaptain(Player captain);
    public List<UclWinner> findByScorers(Player scorer);
}