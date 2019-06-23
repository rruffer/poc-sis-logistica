package rest.config;

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
	

/*    public RestApplication(@Context ServletConfig servletConfig) {
        super();
        OpenAPI oas = new OpenAPI();
        Info info = new Info()
                .title("Swagger Sample App bootstrap code")
                .description("This is a sample server Petstore server.  You can find out more about Swagger " +
                        "at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/).  For this sample, " +
                        "you can use the api key `special-key` to test the authorization filters.")
                .termsOfService("http://swagger.io/terms/")
                .contact(new Contact()
                        .email("apiteam@swagger.io"))
                .license(new License()
                        .name("Apache 2.0")
                        .url("http://www.apache.org/licenses/LICENSE-2.0.html"));

        oas.info(info);
        
        Server server = new Server();
        server.url("http://localhost:8080/logistica/\"");
        server.description("Desenvolvimento");
        
        SecurityScheme s = new SecurityScheme();
        s.name("authorization");
        s.type(Type.APIKEY);
        s.in(In.HEADER);
        s.description("Autorização");
        
        Components components = new Components();
        components.addSecuritySchemes("AUT", s);
        oas.components(components);
        
        oas.addServersItem(server);
        
        SwaggerConfiguration oasConfig = new SwaggerConfiguration()
                .openAPI(oas)
                .prettyPrint(true)
                .readAllResources(true)
                .resourcePackages(Stream.of("rest.doc").collect(Collectors.toSet()));

        try {
            new JaxrsOpenApiContextBuilder()
                    .servletConfig(servletConfig)
                    .application(this)
                    .openApiConfiguration(oasConfig)
                    .buildContext(true);
        } catch (OpenApiConfigurationException e) {
            throw new RuntimeException(e.getMessage(), e);
        }

    }*/

}