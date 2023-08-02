package br.com.henriqueservicos.Covid19.service;

import br.com.henriqueservicos.Covid19.model.Country;
import br.com.henriqueservicos.Covid19.model.CountryData;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CountryService {

    public List<CountryData> listCountriesData(List<Country> countries) {
        List<CountryData> countriesData = new ArrayList<>();
        for (Country country : countries) {
            CountryData data = new CountryData(
                    country.getName(),
                    this.totalContagiosPorPais(country.getSamplingData(), country.getName()),
                    this.diaEMaiorNumeroContagiosPorPais(country.getSamplingData(), country.getName()),
                    this.maiorSequenciaCrescenteContagiosPorPais(country.getSamplingData().length,
                            country.getSamplingData(), country.getName()));
            countriesData.add(data);
        }
        return countriesData;
    }

    public CountryData countryData(Country country) {
        CountryData data = new CountryData(
                country.getName(),
                this.totalContagiosPorPais(country.getSamplingData(), country.getName()),
                this.diaEMaiorNumeroContagiosPorPais(country.getSamplingData(), country.getName()),
                this.maiorSequenciaCrescenteContagiosPorPais(country.getSamplingData().length,
                        country.getSamplingData(), country.getName()));
        return data;
    }

    public int totalContagiosPorPais(int[] data, String countryName) {
        int totalPerCountry = getTotalContagiosPorPais(data);
        return totalPerCountry;
    }

    private int getTotalContagiosPorPais(int[] data) {
        int soma = Arrays.stream(data).sum();
        return soma;
    }

    public String diaEMaiorNumeroContagiosPorPais(int[] data, String countryName) {
        int[] totalPerCountry = getDiaEMaiorNumeroContagiosPorPais(data);
        var result = """
                %d (%d)""".formatted(totalPerCountry[0], totalPerCountry[1]);
        return result;
    }

    private int[] getDiaEMaiorNumeroContagiosPorPais(int[] data) {
        int[] result = new int[2];
        int day = 0, maior = 0;

        for (int i = 0; i < data.length; i++) {
            if (data[i] > maior) {
                maior = data[i];
                day = i;
            }
        }

        result[0] = day + 1;
        result[1] = maior;
        return result;
    }

    public int maiorSequenciaCrescenteContagiosPorPais(int numDias, int[] matNumContagios, String countryName) {
        int sequence = maiorSequenciaCrescente(numDias, matNumContagios);
        return sequence;
    }

    public int maiorSequenciaCrescente(int numDias, int[] matNumContagios) {
        int maior = 1, atual = 1;

        for(int i = 0; i < numDias - 1; i++) {
            if (matNumContagios[i+1] > matNumContagios[i]) {
                atual++;

                if (atual > maior) {
                    maior = atual;
                }
            }else{
                atual = 1;
            }
        }
        return maior;
    }
}
