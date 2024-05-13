package cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n02.controller;


import cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n02.model.domain.Flor;
import cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n02.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.diaz.dani.s05.t01.n02.model.services.FlorService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/webservice")
public class WebController {

    @Autowired
    FlorService florService;

    @Operation(summary = "Add new Flower",
            description = "This method is used to add a new flower. The name and country are necessary.")
    @PostMapping("/add")
    public ResponseEntity<?> addFlower(@RequestBody Flor flor) {
        FlorDTO florDTO = florService.addFlower(flor);
        return new ResponseEntity<>(florDTO, HttpStatus.CREATED);
    }

    @Operation(summary = "Update a Flower",
            description = "This method checks if the ID exists, if so, updates it. You need the whole body.")
    @PutMapping("/update")
    public ResponseEntity<?> updateFlower(@RequestBody Flor flor) {
        FlorDTO florDTO = florService.saveFlower(flor);
        return new ResponseEntity<>(florDTO, HttpStatus.OK);
    }

    @Operation(summary = "Delete one flower",
            description = "This method checks if the ID exists, if so, it deletes it.")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFlower(@PathVariable("id") Integer florId) {
        florService.deleteFlower(florId);
        return new ResponseEntity<>("Flower delete", HttpStatus.OK);
    }

    @Operation(summary = "Show one Flower",
            description = "This method checks if the ID exists, if so, it displays it.")
    @GetMapping("/getOne/{id}")
    public ResponseEntity<?> getOneFlower(@PathVariable("id") Integer flowerId) {
        FlorDTO florDTO = florService.getOneFlowerDTO(flowerId);
        return new ResponseEntity<>(florDTO, HttpStatus.FOUND);
    }

    @Operation(summary = "Show a list of flowers",
            description = "This method shows the complete list of flowers.")
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllFlowers() {
        List<FlorDTO> florDTOList = florService.getAllFlowers();
        return new ResponseEntity<>(florDTOList, HttpStatus.OK);
    }

}
