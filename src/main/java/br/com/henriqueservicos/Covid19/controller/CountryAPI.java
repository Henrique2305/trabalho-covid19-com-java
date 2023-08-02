package br.com.henriqueservicos.Covid19.controller;

import br.com.henriqueservicos.Covid19.model.Country;
import br.com.henriqueservicos.Covid19.model.CountryData;
import br.com.henriqueservicos.Covid19.repository.CountryRepository;
import br.com.henriqueservicos.Covid19.service.CountryService;
import br.com.henriqueservicos.Covid19.service.CreateExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
@RestController
@RequestMapping(path = "/countries", produces = MediaType.APPLICATION_JSON_VALUE)
public class CountryAPI {

    @Autowired
    private CountryRepository repository;

    @Autowired
    private CountryService service;

    @Autowired
    private CreateExcel excelService;

    @GetMapping
    public List<Country> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Country getPaisPorId(@PathVariable long id) {
        Optional<Country> country = repository.findById(id);
        return country.get();
    }

    @PostMapping
    public Country createCountryData(@RequestBody Country country) {
        return repository.save(country);
    }

    @GetMapping("/data/{id}")
    public CountryData getCountryData(@PathVariable int id) {
        return service.countryData(getPaisPorId(id));
    }

    @GetMapping("/data")
    public List<CountryData> getListCountriesData() {
        return service.listCountriesData(getAll());
    }

    @GetMapping("/generate-excel/{id}")
    public String getExcel(@PathVariable int id) {
        return excelService.generateExcel(null, getCountryData(id));
    }

    @GetMapping("/generate-excel")
    public String getExcel() {
        return excelService.generateExcel(getListCountriesData(), null);
    }
}
