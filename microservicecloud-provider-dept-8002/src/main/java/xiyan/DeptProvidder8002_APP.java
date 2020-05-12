package xiyan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class DeptProvidder8002_APP {

	public static void main(String[] args) {
			SpringApplication.run(DeptProvidder8002_APP.class, args);
	}

}
