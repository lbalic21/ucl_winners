package fer.or.ucl_winners;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fer.or.ucl_winners.model.UclWinner;
import fer.or.ucl_winners.service.UclWinnerService;

@RestController
@RequestMapping("/uclWinner")
public class UclWinnerResource {
    private final UclWinnerService uclWinnerService;

    public UclWinnerResource(UclWinnerService uclWinnerService) {
        this.uclWinnerService = uclWinnerService;
    }
    @CrossOrigin("http://localhost:3000")
    @GetMapping("/all")
    public ResponseEntity<List<UclWinner>> getAllUclWinners (@RequestParam(required = false) String value, @RequestParam(required = false) String attribute) {
        List<UclWinner> uclWinners = uclWinnerService.findAllUclWinners(value, attribute);
        return new ResponseEntity<>(uclWinners, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<UclWinner> getUclWinnerById(@PathVariable("id") Integer id) {
        UclWinner uclWinner = uclWinnerService.findUclWinnerById(id);
        return new ResponseEntity<>(uclWinner, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<UclWinner> addUclWinner(@RequestBody UclWinner uclWinner) {
        UclWinner newUclWinner = uclWinnerService.addUclWinner(uclWinner);
        return new ResponseEntity<>(newUclWinner, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<UclWinner> updateUclWinner(@RequestBody UclWinner uclWinner) {
        UclWinner updateUclWinner = uclWinnerService.updateUclWinner(uclWinner);
        return new ResponseEntity<>(updateUclWinner, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUclWinner(@PathVariable("id") Integer id) {
        uclWinnerService.deleteUclWinner(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
