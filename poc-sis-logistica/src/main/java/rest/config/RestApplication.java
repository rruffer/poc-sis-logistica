package rest.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import rest.ServiceAluno;
import rest.ServiceMotorista;
import rest.ServiceSolicitacao;

/**
 * link https://www.youtube.com/watch?v=jjsd1UNbv2c
 * link https://github.com/ptitbob/swagger-ui-integration
 * link http://blog.caelum.com.br/documentando-uma-api-jax-rs-com-swagger/
 * link https://carledwinj.wordpress.com/2017/10/29/como-criar-api-rest-com-swagger-crud-completo/
 * link https://jmchung.github.io/blog/2013/12/14/integrating-swagger-into-jax-rs-with-java-ee-6-specification/
 * link https://gist.github.com/alexandreaquiles/b00ca3fdb35e45f0c53d
 * @author rruffer
 *
 */
@ApplicationPath("/api")
public class RestApplication extends Application {
	
	public RestApplication() {
	    BeanConfig conf = new BeanConfig();
	    conf.setTitle("Logistica Logitech");
	    conf.setDescription("Serviços da empresa");
	    conf.setVersion("1.0.0");
	    conf.setHost("localhost:8080");
	    conf.setBasePath("/logistica/api");
	    conf.setSchemes(new String[] { "http" });
	    conf.setResourcePackage("rest");
	    conf.setScan(true);
	}
	
	@Override
	  public Set<Class<?>> getClasses() {
	      Set<Class<?>> resources = new HashSet<>();
	      resources.add(ServiceAluno.class);
	      resources.add(ServiceSolicitacao.class);
	      resources.add(ServiceMotorista.class);
	      
	      //jackson
	      resources.add(JacksonJavaTimeConfiguration.class);

	      //classes do swagger...
	      resources.add(ApiListingResource.class);
	      resources.add(SwaggerSerializers.class);
	      return resources;
	}
	
}