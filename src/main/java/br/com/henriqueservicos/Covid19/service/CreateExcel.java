package br.com.henriqueservicos.Covid19.service;

import br.com.henriqueservicos.Covid19.model.CountryData;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class CreateExcel {
    private final String filePath = "C:\\Users\\Henri\\Documents\\apache-poi\\";

    public String generateExcel(List<CountryData> countryData, CountryData data) {
        int rowNum = 0;
        int cellNum = 0;

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Dados Covid19");

        Row row = sheet.createRow(rowNum++);

        Cell nomePais = row.createCell(cellNum++);
        showNomePaisLabel(nomePais, workbook);

        Cell totalContagios = row.createCell(cellNum++);
        showTotalContagiosLabel(totalContagios, workbook);

        Cell diaEMaiorContagio = row.createCell(cellNum++);
        showDiaEMaiorNumeroLabel(diaEMaiorContagio, workbook);

        Cell sequenciaCrescente = row.createCell(cellNum++);
        showSequenciaCrescenteLabel(sequenciaCrescente, workbook);

        if (data != null) {
            cellNum = 0;

            row = sheet.createRow(rowNum++);

            Cell cellNomePais = row.createCell(cellNum++);
            String countryName = getNomePais(data, cellNomePais);

            Cell cellTotalContagios = row.createCell(cellNum++);
            getTotalContagios(data, cellTotalContagios);

            Cell cellDiaEMaiorNumeroContagios = row.createCell(cellNum++);
            getDiaEMaiorContagio(data, cellDiaEMaiorNumeroContagios);

            Cell cellMaiorSequenciaCrescenteContagios = row.createCell(cellNum++);
            getMaiorSequenciaCrescenteContagios(data, cellMaiorSequenciaCrescenteContagios);

            try {
                FileOutputStream out = new FileOutputStream(filePath + "Covid19 Data (" + countryName + ").xlsx");
                workbook.write(out);
                out.close();
                System.out.println("Arquivo Excel criado com sucesso");
            } catch (FileNotFoundException e) {
                System.out.println("Arquivo não encontrado!");
            } catch (IOException e) {
                System.out.println("Erro na edição do arquivo!");
            }

            return "Arquivo gerado:\n" + filePath + "Covid19 Data (" + countryName + ").xlsx";
        } else {
            for (CountryData dataList : countryData) {
                cellNum = 0;

                row = sheet.createRow(rowNum++);

                Cell cellNomePais = row.createCell(cellNum++);
                getNomePais(dataList, cellNomePais);

                Cell cellTotalContagios = row.createCell(cellNum++);
                getTotalContagios(dataList, cellTotalContagios);

                Cell cellDiaEMaiorNumeroContagios = row.createCell(cellNum++);
                getDiaEMaiorContagio(dataList, cellDiaEMaiorNumeroContagios);

                Cell cellMaiorSequenciaCrescenteContagios = row.createCell(cellNum++);
                getMaiorSequenciaCrescenteContagios(dataList, cellMaiorSequenciaCrescenteContagios);
            }

            try {
                FileOutputStream out = new FileOutputStream(filePath + "Covid19 Data (All Country).xlsx");
                workbook.write(out);
                out.close();
                System.out.println("Arquivo Excel criado com sucesso");
            } catch (FileNotFoundException e) {
                System.out.println("Arquivo não encontrado!");
            } catch (IOException e) {
                System.out.println("Erro na edição do arquivo!");
            }

            return "Arquivo gerado:\n" + filePath + "Covid19 Data (All Country).xlsx";
        }
    }

    public String generateExcel(CountryData data) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Dados Covid19");

        int rowNum = 0;
        int cellNum = 0;

        Row row = sheet.createRow(rowNum++);

        Cell nomePais = row.createCell(cellNum++);
        showNomePaisLabel(nomePais, workbook);

        Cell totalContagios = row.createCell(cellNum++);
        showTotalContagiosLabel(totalContagios, workbook);

        Cell diaEMaiorContagio = row.createCell(cellNum++);
        showDiaEMaiorNumeroLabel(diaEMaiorContagio, workbook);

        Cell sequenciaCrescente = row.createCell(cellNum++);
        showSequenciaCrescenteLabel(sequenciaCrescente, workbook);

        cellNum = 0;

        row = sheet.createRow(rowNum++);

        Cell cellNomePais = row.createCell(cellNum++);
        String countryName = getNomePais(data, cellNomePais);

        Cell cellTotalContagios = row.createCell(cellNum++);
        getTotalContagios(data, cellTotalContagios);

        Cell cellDiaEMaiorNumeroContagios = row.createCell(cellNum++);
        getDiaEMaiorContagio(data, cellDiaEMaiorNumeroContagios);

        Cell cellMaiorSequenciaCrescenteContagios = row.createCell(cellNum++);
        getMaiorSequenciaCrescenteContagios(data, cellMaiorSequenciaCrescenteContagios);

        try {
            FileOutputStream out = new FileOutputStream(filePath + "Covid19 Data (" + countryName + ").xlsx");
            workbook.write(out);
            out.close();
            System.out.println("Arquivo Excel criado com sucesso");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
        } catch (IOException e) {
            System.out.println("Erro na edição do arquivo!");
        }

        return "Arquivo gerado:\n" + filePath + "Covid19 Data (" + countryName + ").xlsx";
    }

    public String generateExcel(List<CountryData> countryData) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Dados Covid19");

        int rowNum = 0;
        int cellNum = 0;

        Row row = sheet.createRow(rowNum++);

        Cell nomePais = row.createCell(cellNum++);
        showNomePaisLabel(nomePais, workbook);

        Cell totalContagios = row.createCell(cellNum++);
        showTotalContagiosLabel(totalContagios, workbook);

        Cell diaEMaiorContagio = row.createCell(cellNum++);
        showDiaEMaiorNumeroLabel(diaEMaiorContagio, workbook);

        Cell sequenciaCrescente = row.createCell(cellNum++);
        showSequenciaCrescenteLabel(sequenciaCrescente, workbook);

        for (CountryData data : countryData) {
            cellNum = 0;

            row = sheet.createRow(rowNum++);

            Cell cellNomePais = row.createCell(cellNum++);
            getNomePais(data, cellNomePais);

            Cell cellTotalContagios = row.createCell(cellNum++);
            getTotalContagios(data, cellTotalContagios);

            Cell cellDiaEMaiorNumeroContagios = row.createCell(cellNum++);
            getDiaEMaiorContagio(data, cellDiaEMaiorNumeroContagios);

            Cell cellMaiorSequenciaCrescenteContagios = row.createCell(cellNum++);
            getMaiorSequenciaCrescenteContagios(data, cellMaiorSequenciaCrescenteContagios);
        }

        try {
            FileOutputStream out = new FileOutputStream(filePath + "Covid19 Data (All Country).xlsx");
            workbook.write(out);
            out.close();
            System.out.println("Arquivo Excel criado com sucesso");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
        } catch (IOException e) {
            System.out.println("Erro na edição do arquivo!");
        }

        return "Arquivo gerado:\n" + filePath + "Covid19 Data (All Country).xlsx";
    }

    public void showNomePaisLabel(Cell nomePais, XSSFWorkbook workbook) {
        nomePais.setCellValue("Nome País");
        nomePais.setCellStyle(setBoldStyle(workbook));
    }

    public void showTotalContagiosLabel(Cell totalContagios, XSSFWorkbook workbook) {
        totalContagios.setCellValue("Total de Contágios");
        totalContagios.setCellStyle(setBoldStyle(workbook));
    }

    public void showDiaEMaiorNumeroLabel(Cell diaEMaiorContagio, XSSFWorkbook workbook) {
        diaEMaiorContagio.setCellValue("Dia e Maior Número de Contágio");
        diaEMaiorContagio.setCellStyle(setBoldStyle(workbook));
    }

    public void showSequenciaCrescenteLabel(Cell sequenciaCrescente, XSSFWorkbook workbook) {
        sequenciaCrescente.setCellValue("Maior sequência crescente");
        sequenciaCrescente.setCellStyle(setBoldStyle(workbook));
    }

    public CellStyle setBoldStyle(XSSFWorkbook workbook) {
        CellStyle boldCellStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        boldCellStyle.setFont(font);
        return boldCellStyle;
    }

    public String getNomePais(CountryData data, Cell cellNomePais) {
        var countryName = data.getCountryName();
        cellNomePais.setCellValue(countryName);
        return countryName;
    }

    public void getTotalContagios(CountryData data, Cell cellTotalContagios) {
        cellTotalContagios.setCellValue(data.getTotalContagios());
    }

    public void getDiaEMaiorContagio(CountryData data,  Cell cellDiaEMaiorNumeroContagios) {
        cellDiaEMaiorNumeroContagios.setCellValue(data.getDiaEMaiorNumeroContagios());
    }

    public void getMaiorSequenciaCrescenteContagios(CountryData data, Cell cellMaiorSequenciaCrescenteContagios) {
        cellMaiorSequenciaCrescenteContagios.setCellValue(data.getMaiorSequenciaCrescenteContagios());
    }
}
