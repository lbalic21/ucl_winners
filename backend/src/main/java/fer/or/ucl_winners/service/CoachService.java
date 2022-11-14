package fer.or.ucl_winners.service;

import java.util.List;
//import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fer.or.ucl_winners.repo.CoachRepo;
import fer.or.ucl_winners.exeption.PersonNotFoundExeption;
import fer.or.ucl_winners.model.Coach;

@Service
public class CoachService {
    private final CoachRepo coachRepo;

    @Autowired
    public CoachService(CoachRepo coachRepo) {
        this.coachRepo = coachRepo;
    }

    public Coach addCoach(Coach coach) {
        //coach.setId(Integer.valueOf(UUID.randomUUID()));
        return coachRepo.save(coach);
    }

    public List<Coach> findAllCoaches() {
        return coachRepo.findAll();
    }

    public Coach updateCoach(Coach coach) {
        return coachRepo.save(coach);
    }

    public Coach findCoachById(Integer id) {
        return (Coach) coachRepo.findCoachById(id).orElseThrow(() -> new PersonNotFoundExeption("coach by id " + id + " was not found."));
    }

    public void deleteCoach(Integer id) {
        coachRepo.deleteCoachById(id);
    }

    public List<Coach> findCoach(String value) {
        return coachRepo.findByNameContainingIgnoreCase(value.toLowerCase());
    }
}