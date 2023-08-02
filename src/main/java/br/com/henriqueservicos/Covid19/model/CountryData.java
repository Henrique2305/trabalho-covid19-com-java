package br.com.henriqueservicos.Covid19.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class CountryData {
    private String countryName;
    private int totalContagios;
    private String diaEMaiorNumeroContagios;
    private int maiorSequenciaCrescenteContagios;

    public CountryData(String countryName, int totalContagios, String diaEMaiorNumeroContagios, int maiorSequenciaCrescenteContagios) {
        this.countryName = countryName;
        this.totalContagios = totalContagios;
        this.diaEMaiorNumeroContagios = diaEMaiorNumeroContagios;
        this.maiorSequenciaCrescenteContagios = maiorSequenciaCrescenteContagios;
    }
}
