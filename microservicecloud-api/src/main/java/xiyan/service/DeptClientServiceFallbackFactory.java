package xiyan.service;


import java.util.List;

import org.springframework.stereotype.Component;

import xiyan.entities.Dept;
import feign.hystrix.FallbackFactory;

@Component   //该注解必须添加
public class DeptClientServiceFallbackFactory  implements FallbackFactory<DeptClientService>{

	@Override
	public DeptClientService create(Throwable arg0) {
		return new DeptClientService(){

			@Override
			public boolean add(Dept dept) {

				return false;
			}

			@Override
			public Dept get(Long id) {
				return new Dept().setDeptno(id).setDname("ID:"+id+"无法找到对应的内容").setDb_source("no this database mysql");
			}

			@Override
			public List<Dept> list() {

				return null;
			}
		};
	}

}
