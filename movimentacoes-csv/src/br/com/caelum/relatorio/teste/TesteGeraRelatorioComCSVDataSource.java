package br.com.caelum.relatorio.teste;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import br.com.caelum.relatorio.GeradorRelatorio;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRCsvDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;

public class TesteGeraRelatorioComCSVDataSource {

	public static void main(String[] args) throws SQLException, JRException, FileNotFoundException {

		//JasperCompileManager.compileReportToFile("movimentacoes.jrxml"); 

		Map<String, Object> parametros = new HashMap<String, Object>();

		//� preciso initializar a datasource para ler um arquivo movimentacoes.csv
		JRCsvDataSource dataSource = new JRCsvDataSource("movimentacoes.csv");
		dataSource.setColumnNames(new String[]{"id","data","descricao","tipoMovimentacao","valor"});
		dataSource.setDatePattern("yyyy-MM-dd");
		
		GeradorRelatorio geradorRelatorio = new GeradorRelatorio("movimentacoes.jasper", parametros, dataSource);
		geradorRelatorio.geraPDFPara(new FileOutputStream("movimentacoes.pdf"));
	}

}
