package br.com.estudo.casadocodigo.contry.services;


import static br.com.estudo.casadocodigo.common.UUIDFunction.getUUID;

import br.com.estudo.casadocodigo.book.repositories.StatesRepository;
import br.com.estudo.casadocodigo.contry.model.Country;
import br.com.estudo.casadocodigo.contry.model.States;
import br.com.estudo.casadocodigo.contry.model.StatesCreateDTO;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatesService {
    private final StatesRepository statesRepository;
    private final CountryService countryService;

    public States create(String countryID, StatesCreateDTO statesDto) {
        var country = getCountry(countryID);
        var state = new States(statesDto, country);
        return save(state);
    }

    private Country getCountry(String country) {
        return countryService.findById(country);
    }

    private States save(States states) {
        return statesRepository.save(states);
    }

    public List<States> findAllByCountry(String country) {
        return Optional.ofNullable(country)
                .flatMap(getUUID)
                .flatMap(statesRepository::findByCountry_Id)
                .orElseThrow(() -> new RuntimeException("States not found"));
    }

    public States findById(String id) {
        return Optional.ofNullable(id)
                .flatMap(getUUID)
                .flatMap(statesRepository::findById)
                .orElseThrow(() -> new RuntimeException("States not found"));
    }
}
