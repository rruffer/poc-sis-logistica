package config;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.annotation.FacesConfig.Version;
import javax.inject.Named;

/**
 *
 * @author rruffer
 */
@FacesConfig(
	// Activates CDI build-in beans
	version = Version.JSF_2_3 
)
@Named("configBean")
@ApplicationScoped
public class ConfigurationBean {
	
	private String version;
	private String dateCompile;
	
    @PostConstruct
    public void init() {

    	Properties properties = new Properties();
    	try {
			properties.load(getClass().getResourceAsStream("/pom.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	version = properties.getProperty("version");
    	String artifactId = properties.getProperty("artifactId");
    	String groupId = properties.getProperty("groupId");
    	dateCompile = properties.getProperty("dateCompile");
    	
    	System.out.printf("Versão: %s, Id: %s, Group: %s", version, artifactId, groupId);
    	
    }

	public String getVersion() {
		return version;
	}
	
	public String getVersionAndDateCompile() {
		return String.format("%s (Compilação: %s)", version, dateCompile);
	}

}
