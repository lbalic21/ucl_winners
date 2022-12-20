package fer.or.ucl_winners;

import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import javax.persistence.Entity;
import javax.websocket.server.PathParam;

import org.apache.tomcat.util.json.JSONParser;
import org.json.simple.JSONArray;



import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.ClassPathResource;
import fer.or.ucl_winners.model.UclWinner;
import fer.or.ucl_winners.service.UclWinnerService;
import org.apache.commons.io.IOUtils;
import fer.or.ucl_winners.MyResponse;

@RestController
@RequestMapping("/uclWinner")
public class UclWinnerResource {
    private final UclWinnerService uclWinnerService;

    public UclWinnerResource(UclWinnerService uclWinnerService) {
        this.uclWinnerService = uclWinnerService;
    }
    @CrossOrigin("http://localhost:3000")
    @GetMapping("/all")
    public ResponseEntity<MyResponse> getAllUclWinners (@RequestParam(required = false) String value, @RequestParam(required = false) String attribute) {
        List<UclWinner> uclWinners = uclWinnerService.findAllUclWinners(value, attribute);
        MyResponse r = new MyResponse("OK","Fetched All UCL winners",uclWinners);
        return new ResponseEntity<>(r, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MyResponse> getUclWinnerById(@PathVariable("id") Integer id) {
        try{
            UclWinner uclWinner = uclWinnerService.findUclWinnerById(id);
            List<UclWinner> l = new LinkedList<UclWinner>();
            l.add(uclWinner);
            return new ResponseEntity<>(new MyResponse("OK", "Fetched UCL winner", l), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(new MyResponse("Not Found", "UCL winner with the provided ID doesn't exist", null), HttpStatus.NOT_FOUND);
        }
    }

    
    @GetMapping("/openapi")
    public ResponseEntity<Map<String, Object>> getRadarData() throws IOException {
        ClassPathResource staticDataResource = new ClassPathResource("openapi.json");
        String staticDataString = IOUtils.toString(staticDataResource.getInputStream(), StandardCharsets.UTF_8);

        return new ResponseEntity<>(new JSONObject(staticDataString).toMap(),HttpStatus.OK);
    }
       

    @PostMapping("/add")
    public ResponseEntity<MyResponse> addUclWinner(@RequestBody UclWinner uclWinner) {
        try{
            UclWinner newUclWinner = uclWinnerService.addUclWinner(uclWinner);
            List<UclWinner> l = new LinkedList<UclWinner>();
            l.add(newUclWinner);
            return new ResponseEntity<>(new MyResponse("Created", "UCL winner added to the database", l), HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(new MyResponse("Already exists", "UCL winner cannot be added twice", null), HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<MyResponse> updateUclWinner(@RequestBody UclWinner uclWinner) {
        try{
            UclWinner updateUclWinner = uclWinnerService.updateUclWinner(uclWinner);
            List<UclWinner> l = new LinkedList<UclWinner>();
            l.add(updateUclWinner);
            return new ResponseEntity<>(new MyResponse("OK", "Updated UCL winner", l), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(new MyResponse("Not Found", "UCL winner with the provided ID doesn't exist", null), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MyResponse> deleteUclWinner(@PathVariable("id") Integer id) {
        try{
            UclWinner w = uclWinnerService.deleteUclWinner(id);
            List<UclWinner> l = new LinkedList<UclWinner>();
            l.add(w);
            return new ResponseEntity<MyResponse>(new MyResponse("OK", "Deleted UCL winner", l), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(new MyResponse("Not Found", "UCL winner with the provided ID doesn't exist", null), HttpStatus.NOT_FOUND);
        }
    }

    @ExceptionHandler
    @ResponseStatus()
    public ResponseEntity<MyResponse> badRequest(){
        return new ResponseEntity<>(new MyResponse("Bad Request", "Bad Request", null), HttpStatus.BAD_REQUEST);
    }
    //@ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    public ResponseEntity<MyResponse> notImplemented(){
        return new ResponseEntity<>(new MyResponse("Not Implemented", "Method not implemented for requested resource", null), HttpStatus.BAD_REQUEST);
    }

}
