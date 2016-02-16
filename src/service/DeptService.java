package service;

import java.util.List;

import po.Dept;
import po.Emp;

public interface DeptService {
	public void addDept(Dept dept);
	public void updateDept(Dept dept);
	public void deleteDept(Dept dept);
	public Dept getById(int did);
	public Dept getByName(String name);
	public List<Dept> getAll();
}
