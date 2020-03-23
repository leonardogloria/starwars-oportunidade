package com.leonardo.starwars.controller;

import com.leonardo.starwars.model.Planeta;
import com.leonardo.starwars.repository.PlanetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/planeta")
public class PlanetaController {
    @Autowired
    PlanetaRepository planetaRepository;
    @GetMapping
    public List<Planeta> getAll() {
      return (List<Planeta>) this.planetaRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        Optional<Planeta> byId = this.planetaRepository.findById(id);
        if (byId.isPresent()) {
            return ResponseEntity.ok().body(this.planetaRepository.findById(id));

        } else {
            return (ResponseEntity<?>) ResponseEntity.notFound();
        }
    }



    @PostMapping
    public void salvaPlaneta(@RequestBody  Planeta planeta){
        this.planetaRepository.save(planeta);

    }
    @DeleteMapping("/api/planeta/{id}")
    public void deletaPlaneta(@PathVariable  long id){
        Optional<Planeta> byId = this.planetaRepository.findById(id);
        this.planetaRepository.delete(byId.get());
    }


}
