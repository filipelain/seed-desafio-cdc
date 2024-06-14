package br.com.estudo.casadocodigo.contry.controllers;

import br.com.estudo.casadocodigo.contry.model.States;
import br.com.estudo.casadocodigo.contry.model.StatesCreateDTO;
import br.com.estudo.casadocodigo.contry.services.StatesService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/country/{country}/states")
@RequiredArgsConstructor
public class StatesController {
    private final StatesService statesService;

    @PostMapping("/")
    public ResponseEntity<States> create(
            @PathVariable String country,
            @Valid @RequestBody StatesCreateDTO statesCreateDTO
    ) {
        return ResponseEntity.ok(statesService.create(country, statesCreateDTO));
    }

    @GetMapping("/")
    public ResponseEntity<List<States>> findAll(@PathVariable String country) {
        return ResponseEntity.ok(statesService.findAllByCountry(country));
    }

    @GetMapping("/{id}")
    public ResponseEntity<States> findById(@PathVariable String country, @PathVariable String id) {
        return ResponseEntity.ok(statesService.findById(id));
    }
}
