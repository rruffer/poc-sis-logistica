/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.jar.Manifest;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.annotation.FacesConfig.Version;
import javax.faces.context.FacesContext;

/**
 *
 * @author hantsy
 */
@FacesConfig(
	// Activates CDI build-in beans
	version = Version.JSF_2_3 
)
@ApplicationScoped
public class ConfigurationBean {
	
    private Manifest manifest = null;
    public Manifest getManifest() {
        return manifest;
    }
    @PostConstruct
    public void init() {
        File manifestFile = null;
        try {
            String home = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
            manifestFile = new File(home, "META-INF/MANIFEST.MF");
            manifest = new Manifest();
            manifest.read(new FileInputStream(manifestFile));
        } catch (IOException ioe) {
           System.out.println("Unable to read the Manifest file from '"+manifestFile.getAbsolutePath()+"'" + ioe);
        }
    }

}
