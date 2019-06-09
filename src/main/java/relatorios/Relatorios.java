package relatorios;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Local;
import javax.ejb.Stateless;

import org.jboss.logging.Logger;

import enums.StatusSolicitacao;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Local
@Stateless
public class Relatorios {
	
	private Logger log = Logger.getLogger(Relatorios.class);


	public ByteArrayInputStream relatorioExpedicao(List<SolicitacaoRel> listaSolicitacoes, StatusSolicitacao status) {

		try {


			//parâmetros
			//ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			//InputStream inputStream = ec.getResourceAsStream("/resources/images/topoRelatorioValid.jpg");
			Map<String, Object> parametros = new HashMap<String, Object>();
			//parametros.put("logo", inputStream);
			parametros.put("nmSistema", "Logística Logitech");
			
			String statusDescricao = status == null ? "Todos": status.getDescricao();
			
			parametros.put("tipoRelatorio", "Relatório de OS " + statusDescricao);
			
//			String caminhoJasper = getFile("/relatorios/relatorio-expedicao.jasper").getAbsolutePath();
		    InputStream caminhoJasper = this.getClass().getClassLoader().getResourceAsStream("relatorios/relatorio-expedicao.jasper");

			JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(listaSolicitacoes);
			JasperPrint arquivo = JasperFillManager.fillReport(caminhoJasper, parametros, ds);

		    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		    JasperExportManager.exportReportToPdfStream(arquivo, outputStream);
			
			return new ByteArrayInputStream(outputStream.toByteArray());

		} catch (Exception e) {
			log.error("Erro ao gerar relatório");
		}
		
		return null;

	}
	
	public ByteArrayInputStream relatorioTeste() {
		
		try {
			
			
			List<AvaliacaoDesempenhoRelatorio> listaSolicitacoes = listaSolicitacoes();
			
			//parâmetros
			//ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			//InputStream inputStream = ec.getResourceAsStream("/resources/images/topoRelatorioValid.jpg");
			Map<String, Object> parametros = new HashMap<String, Object>();
			//parametros.put("logo", inputStream);
			parametros.put("nmSistema", "Logística Logitech");
			
			String statusDescricao = "Todos";
			
			parametros.put("tipoRelatorio", "Relatório de OS " + statusDescricao);
			
//			String caminhoJasper = getFile("/relatorios/relatorio-expedicao.jasper").getAbsolutePath();
			InputStream caminhoJasper = this.getClass().getClassLoader().getResourceAsStream("relatorios/avaliacaoDesempenho.jasper");
			
			JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(listaSolicitacoes);
			JasperPrint arquivo = JasperFillManager.fillReport(caminhoJasper, parametros, ds);
			
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			JasperExportManager.exportReportToPdfStream(arquivo, outputStream);
			
			return new ByteArrayInputStream(outputStream.toByteArray());
			
		} catch (Exception e) {
			log.error("Erro ao gerar relatório");
		}
		
		return null;
		
	}
	
	private List<AvaliacaoDesempenhoRelatorio> listaSolicitacoes() {
		
		List<AvaliacaoDesempenhoRelatorio> listaSolicitacoes = new ArrayList<>();
		listaSolicitacoes.add(new AvaliacaoDesempenhoRelatorio("Teste1", 100));
		listaSolicitacoes.add(new AvaliacaoDesempenhoRelatorio("Teste2", 50));
		
		return listaSolicitacoes;
	}
	
	private static File getFile(String fileName) {

		ClassLoader classLoader = Relatorios.class.getClassLoader();

		
		return  new File(classLoader.getResource(fileName).getFile());

	}
	
}
