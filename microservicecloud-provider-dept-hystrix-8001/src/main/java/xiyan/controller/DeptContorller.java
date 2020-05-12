package xiyan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import xiyan.entities.Dept;
import xiyan.service.DeptService;

@RestController
public class DeptContorller {

	@Autowired
	private DeptService service;
	
	@Autowired
	private DiscoveryClient client;
	
	@RequestMapping(value="/dept/add",method=RequestMethod.POST)
	public boolean add(@RequestBody Dept dept){
		return service.add(dept);
	}
	
	@RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
	//调用服务出现错误 会转向调用fallbackMethod 中的方法
	@HystrixCommand(fallbackMethod="processHystrix_Get")
	public Dept get(@PathVariable("id") Long id){
		System.out.println("正确进入了该方法service"+id);
		Dept dept=service.get(id);
		if(dept==null){
			throw new RuntimeException("不想说话");
		}
		return dept;
	}
	
	@RequestMapping(value="/dept/list",method=RequestMethod.GET)
	public List<Dept> list(){
		return service.list();
	}
	
	@GetMapping(value="/dept/discovery")
	public Object discovery(){
		List<String> list=client.getServices();
		System.out.println("*************"+list);
		
		List<ServiceInstance> srvList=client.getInstances("MICROSERVICECLOUD-DEPT");
		for(ServiceInstance element:srvList){
			System.out.println(element.getServiceId()+"\t"+element.getHost()+"\t"+element.getPort()+"\t"+element.getUri());
		}
		return this.client;
	}
	public Dept processHystrix_Get(@PathVariable("id") Long id){
		System.out.println("正确进入了该方法"+id);
		return new Dept().setDeptno(id).setDname("ID:"+id+"无法找到对应的内容").setDb_source("no this database mysql");
	}
	
}
