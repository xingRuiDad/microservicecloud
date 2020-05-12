package xiyan;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;

import com.netflix.ribbon.proxy.annotation.ClientProperties;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages="xiyan")
@ComponentScan("xiyan")
public class DeptConsumer80_feign_app {
	
	
	public static void main(String[] arge){
		SpringApplication.run(DeptConsumer80_feign_app.class, arge);
	}

}
