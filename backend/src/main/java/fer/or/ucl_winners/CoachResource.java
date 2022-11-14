package fer.or.ucl_winners;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fer.or.ucl_winners.model.Coach;
import fer.or.ucl_winners.service.CoachService;

@RestController
@RequestMapping("/coach")
public class CoachResource {
    private final CoachService coachService;

    public CoachResource(CoachService coachService) {
        this.coachService = coachService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Coach>> getAllCoachses () {
        List<Coach> coaches = coachService.findAllCoaches();
        return new ResponseEntity<>(coaches, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Coach> getCoachById(@PathVariable("id") Integer id) {
        Coach coach = coachService.findCoachById(id);
        return new ResponseEntity<>(coach, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Coach> addCoach(@RequestBody Coach coach) {
        Coach newCoach = coachService.addCoach(coach);
        return new ResponseEntity<>(newCoach, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Coach> updateCoach(@RequestBody Coach coach) {
        Coach updateCoach = coachService.updateCoach(coach);
        return new ResponseEntity<>(updateCoach, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCoach(@PathVariable("id") Integer id) {
        coachService.deleteCoach(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
