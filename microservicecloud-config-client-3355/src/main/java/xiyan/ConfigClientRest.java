package xiyan;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientRest {
	
	@Value("${spring.application.name}")
	private String applicationName;
	
	@Value("${eureka.client.service-url.defaultZone}")
	private String eurekaServers;
	
	@Value("${server.port}")
	private String port;
	
	@RequestMapping("/config")
	private String getConfig(){
		System.out.println(eurekaServers);
		return "applicationName:"+applicationName+"\t eurekaServers:"+eurekaServers+"\t port:"+port;	
	}
}
