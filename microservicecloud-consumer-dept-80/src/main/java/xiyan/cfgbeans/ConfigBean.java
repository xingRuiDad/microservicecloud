package xiyan.cfgbeans;

import java.util.Random;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import com.netflix.loadbalancer.ZoneAvoidanceRule;

@Configuration
public class ConfigBean {// boot --> 等同于 applicationContext.xml

	@Bean
	@LoadBalanced  //Spring Cloud Ribbon 是基于Netflix Ribbon 实现的一套客户端 负载均衡工具
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
	/**
	 * 手动声明 负责均衡 Ribbon的 轮询算法
	 * RoundRobinRule轮询算法
	 * RandomRule 随机算法
	 * AvailabilityFilteringRule 过滤故障跳闸的服务 还有并发的连接数量超过阈值的服务  过滤掉那些高并发的的后端server
	 * WeightedResponseTimeRule  计算权重  根据相应时间分配一个weight，相应时间越长，weight越小，被选中的可能性越低
	 * RetryRule            按照RoundRobinRule获取服务 如果获取服务失败则重新获取
	 * ZoneAvoidanceRule    复合判断server所在区域的性能和server的可用性选择server
	 * BestAvailableRule  先过滤多次访问故障处于跳闸状态的服务再选择一个最小的并发请求的server
	 * 
	 * @return
	 */
	@Bean
	public IRule myRule(){
		return new BestAvailableRule();
	}
}
