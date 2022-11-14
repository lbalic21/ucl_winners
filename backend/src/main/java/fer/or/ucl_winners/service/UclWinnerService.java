package fer.or.ucl_winners.service;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fer.or.ucl_winners.repo.UclWinnerRepo;
import fer.or.ucl_winners.exeption.PersonNotFoundExeption;
import fer.or.ucl_winners.model.Coach;
import fer.or.ucl_winners.model.Player;
import fer.or.ucl_winners.model.UclWinner;

@Service
public class UclWinnerService {
    private final UclWinnerRepo uclWinnerRepo;
    private final CoachService coachService;
    private final PlayerService playerService;

    @Autowired
    public UclWinnerService(UclWinnerRepo uclWinnerRepo, CoachService coachService, PlayerService playerService) {
        this.uclWinnerRepo = uclWinnerRepo;
        this.coachService = coachService;
        this.playerService = playerService;
    }

    public UclWinner addUclWinner(UclWinner uclWinner) {
        //uclWinner.setId(Integer.valueOf(UUID.randomUUID()));
        return uclWinnerRepo.save(uclWinner);
    }

    public List<UclWinner> findAllUclWinners(String value, String attribute) {
        if(value == null || attribute == null || value.equals(""))
            return uclWinnerRepo.findAll();
        if(attribute.toLowerCase().equals("club"))
            return (List<UclWinner>) uclWinnerRepo.findByClubContainingIgnoreCase(value.toLowerCase());
        if(attribute.toLowerCase().equals("city"))
            return (List<UclWinner>) uclWinnerRepo.findByCityContainingIgnoreCase(value.toLowerCase());
        if(attribute.toLowerCase().equals("country"))
            return (List<UclWinner>) uclWinnerRepo.findByCountryContainingIgnoreCase(value.toLowerCase());
       // if(attribute.toLowerCase().equals("year"))
         //   return (List<UclWinner>) uclWinnerRepo.findByYearContainingIgnoreCase(Integer.parseInt(value));
        if(attribute.toLowerCase().equals("stadium"))
            return (List<UclWinner>) uclWinnerRepo.findByFinalStadiumContainingIgnoreCase(value.toLowerCase());
        if(attribute.toLowerCase().equals("match up"))
            return (List<UclWinner>) uclWinnerRepo.findByFinalMatchupContainingIgnoreCase(value.toLowerCase());
        if(attribute.toLowerCase().equals("result"))
            return (List<UclWinner>) uclWinnerRepo.findByResultContainingIgnoreCase(value.toLowerCase());    
        //if(attribute.toLowerCase().equals("attendance"))
        //    return (List<UclWinner>) uclWinnerRepo.findByAttendanceContainingIgnoreCase(Integer.parseInt(value));
        if(attribute.toLowerCase().equals("head coach")) {
            List<Coach> coaches = coachService.findCoach(value.toLowerCase());
            Set<UclWinner> set = new HashSet<>();
            if(coaches != null && coaches.size() != 0){
                for (Coach coach: coaches) {
                    set.addAll(uclWinnerRepo.findByHeadCoach(coach));
                }
            }
            return set.stream().toList();
        }
        if(attribute.toLowerCase().equals("player")) {
            List<Player> players = playerService.findPlayer(value.toLowerCase());
            Set<UclWinner> set = new HashSet<>();
            if(players != null && players.size() != 0){
                for (Player player: players) {
                    set.addAll(uclWinnerRepo.findByCaptain(player));
                    set.addAll(uclWinnerRepo.findByScorers(player));
                }
            }
            return set.stream().toList();
        }
        List<UclWinner> list = uclWinnerRepo.findAll();
        List<UclWinner> newList = new LinkedList<>();
        for (UclWinner uclWinner : list) {
            if (uclWinner.toString().contains(value)) 
                newList.add(uclWinner);
        }
        return newList;
    }

    public UclWinner updateUclWinner(UclWinner uclWinner) {
        return uclWinnerRepo.save(uclWinner);
    }

    public UclWinner findUclWinnerById(Integer id) {
       return uclWinnerRepo.findUclWinnerById(id).orElseThrow(() -> new PersonNotFoundExeption("UclWinner by id " + id + " was not found."));
    }   

    public void deleteUclWinner(Integer id) {
        uclWinnerRepo.deleteUclWinnerById(id);
    }
}