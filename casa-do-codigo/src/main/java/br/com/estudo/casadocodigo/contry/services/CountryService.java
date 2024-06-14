package br.com.estudo.casadocodigo.contry.services;

import static br.com.estudo.casadocodigo.common.UUIDFunction.getUUID;

import br.com.estudo.casadocodigo.book.repositories.CountryRepository;
import br.com.estudo.casadocodigo.contry.errors.CountryNotFoundException;
import br.com.estudo.casadocodigo.contry.model.Country;
import br.com.estudo.casadocodigo.contry.model.CountryCreateDto;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CountryService {
    private final CountryRepository countryRepository;


    public Country create(CountryCreateDto countryCreateDto) {
        Country country = new Country(countryCreateDto.getName());
        return save(country);
    }

    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    public Country findById(String id) {
        return Optional.ofNullable(id)
                .flatMap(getUUID)
                .flatMap(countryRepository::findById)
                .orElseThrow(() -> new CountryNotFoundException("Country not found"));
    }

    public boolean existsByName(String name) {
        return countryRepository.existsByName(name);
    }

    private Country save(Country country) {
        return countryRepository.save(country);
    }
}
