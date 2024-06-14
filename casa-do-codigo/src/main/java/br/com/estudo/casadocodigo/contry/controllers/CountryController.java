package br.com.estudo.casadocodigo.contry.controllers;


import br.com.estudo.casadocodigo.contry.model.Country;
import br.com.estudo.casadocodigo.contry.model.CountryCreateDto;
import br.com.estudo.casadocodigo.contry.services.CountryService;
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
@RequestMapping("/country")
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @GetMapping("/")
    public ResponseEntity<List<Country>> findAll() {
        return ResponseEntity.ok(countryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> findById(@PathVariable String id) {
        return ResponseEntity.ok(countryService.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Country> create( @Valid @RequestBody CountryCreateDto countryCreateDto) {
        return ResponseEntity.ok(countryService.create(countryCreateDto));
    }
}
