package xiyan;

import myRule.MyselfRule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
//加载我们自定义的Ribbon配置类 从而使配置失效
@RibbonClient(name="MICROSERVICECLOUD-DEPT",configuration=MyselfRule.class)
public class DeptConsumer80_app {
	
	
	public static void main(String[] arge){
		SpringApplication.run(DeptConsumer80_app.class, arge);
	}

}
