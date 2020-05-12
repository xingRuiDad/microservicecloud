package xiyan.service;

import java.util.List;

import xiyan.entities.Dept;

public interface DeptService {

	public boolean add(Dept dept);
	
	public Dept get(Long id);
	
	public List<Dept> list();
}
