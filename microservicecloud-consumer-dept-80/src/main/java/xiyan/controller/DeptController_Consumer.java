package xiyan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import xiyan.entities.Dept;

@RestController
public class DeptController_Consumer {
	
	//原始 写死地址 private static final String REST_URL_PREFIX="http://localhost:8001";
	// 微服务写法
	private static final String REST_URL_PREFIX="http://MICROSERVICECLOUD-DEPT";
	/**
	 * 使用restTemplate 访问restful接口十分简单
	 * (URL,requestMap,ResponseBean.class)
	 * REST请求地址，请求参数，HTTP响应转换被转换成的类型
	 */
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value="/consumer/dept/add")
	public boolean add(Dept dept){
		return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add", dept, boolean.class);
	}
	
	@RequestMapping(value="/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id){
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id, Dept.class);
	}
	
	@RequestMapping(value="/consumer/dept/list")
	public List<Dept> list(){
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
	}
	/**
	 * 测试消费的 调用服务发现
	 * @return
	 */
	@GetMapping(value="/consumer/dept/discovery")
	public Object discovery(){
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/discovery",Object.class);
	}
}
