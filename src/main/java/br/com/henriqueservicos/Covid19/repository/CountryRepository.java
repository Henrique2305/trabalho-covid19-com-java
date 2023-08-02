package br.com.henriqueservicos.Covid19.repository;

import br.com.henriqueservicos.Covid19.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
