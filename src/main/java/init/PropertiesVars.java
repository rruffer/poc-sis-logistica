package init;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServletRequest;

/**
 * Classe respons�vel por iniciar os par�metros globais da aplica��o
 * utilizando o arquivo printValid.properties
 * @author rodolfo.ruffer
 *
 */
public class PropertiesVars implements ServletContextListener {

	@Override
	public void contextInitialized(final ServletContextEvent event) {

/*		String path = "D:\\Biblioteca\\Documents\\Projetos\\Projetos_Trabalhos\\Valid\\PrintValid\\printValidWeb\\printValid.properties";
	//	String path = "/home/tomcat/tomcat8/webapps/printValid.properties";
		System.out.println(path);
		File file = new File(path);
		final Properties propsFromFile = new Properties();

		try {
//			propsFromFile.load(getClass().getResourceAsStream(file.getAbsolutePath()));
			propsFromFile.load(new FileInputStream(file));
		} catch (final IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (String prop : propsFromFile.stringPropertyNames()) {
			if (System.getProperty(prop) == null) {
				System.setProperty(prop, propsFromFile.getProperty(prop));
			}
		}*/

	}
	
	@Override
	public void contextDestroyed(final ServletContextEvent event) {
	}

}
