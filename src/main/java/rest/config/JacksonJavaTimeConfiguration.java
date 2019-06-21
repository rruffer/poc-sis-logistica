package rest.config;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * link https://github.com/FasterXML/jackson-modules-java8
 * @author rruffer
 *
 */
@Provider
public class JacksonJavaTimeConfiguration implements ContextResolver<ObjectMapper> {

	private final ObjectMapper mapper;
	
	public JacksonJavaTimeConfiguration() {
		mapper = new ObjectMapper();
		mapper.findAndRegisterModules();
	}
	
	@Override
	public ObjectMapper getContext(Class<?> type) {
		return mapper;
	}

}
