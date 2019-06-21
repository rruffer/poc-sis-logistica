package rest.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * link https://www.youtube.com/watch?v=jjsd1UNbv2c link
 * https://github.com/ptitbob/swagger-ui-integration link
 * http://blog.caelum.com.br/documentando-uma-api-jax-rs-com-swagger/ link
 * https://carledwinj.wordpress.com/2017/10/29/como-criar-api-rest-com-swagger-crud-completo/
 * link
 * https://jmchung.github.io/blog/2013/12/14/integrating-swagger-into-jax-rs-with-java-ee-6-specification/
 * link https://gist.github.com/alexandreaquiles/b00ca3fdb35e45f0c53d
 * 
 * @author rruffer
 *
 */
@ApplicationPath("/api")
public class RestApplication extends Application {

	/*@Override
	public Set<Class<?>> getClasses() {

		Set<Class<?>> resources = new HashSet<>();

		// jackson
		resources.add(JacksonJavaTimeConfiguration.class);

		return resources;
	}*/

}