package relatorios;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import enums.StatusSolicitacao;
import model.Solicitacao;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import util.UtilJSF;

public class Relatorios {

	public static File relatorioExpedicao(List<SolicitacaoRel> listaSolicitacoes, String nomeArquivo, StatusSolicitacao status) {

		File file = null;
		
		try {


			//parâmetros
			//ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			//InputStream inputStream = ec.getResourceAsStream("/resources/images/topoRelatorioValid.jpg");
			Map<String, Object> parametros = new HashMap<String, Object>();
			//parametros.put("logo", inputStream);
			parametros.put("nmSistema", "Logística Logitech");
			
			String statusDescricao = status == null ? "Todos": status.getDescricao();
			
			parametros.put("tipoRelatorio", "Relatório de OS " + statusDescricao);
			
			file = new File(UtilJSF.pastaRaiz().getRealPath("///relatorios//"));
			
			if(!file.isDirectory()) {
				file.mkdir();
			}

			String caminhoRelatorio = UtilJSF.pastaRaiz().getRealPath("///relatorios//") + "//" +  nomeArquivo;
			file = new File(caminhoRelatorio);
			
			if(file.exists()) {
				file.delete();
			}
			
			String caminhoJasper = getFile("/relatorios/relatorio-expedicao.jasper").getAbsolutePath();
			JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(listaSolicitacoes);
			JasperPrint arquivo = JasperFillManager.fillReport(caminhoJasper, parametros, ds);

			JasperExportManager.exportReportToPdfFile(arquivo, caminhoRelatorio);
			
			file = new File(caminhoRelatorio);


		} catch (Exception e) {

			e.printStackTrace();

		}
		
		return file;

	}
	
	private static File getFile(String fileName) {

		ClassLoader classLoader = Relatorios.class.getClassLoader();

		
		return  new File(classLoader.getResource(fileName).getFile());

	}
	
}
