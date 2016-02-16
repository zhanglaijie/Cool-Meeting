package dao;

import java.util.List;

import po.Dept;
import po.Emp;

public interface EmpDAO {
	public void addEmp(Emp emp);
	public void updateEmp(Emp emp);
	public void deleteEmp(Emp emp);
	public Emp getById(int eid);
	public List<Emp> getBys(int s_privilege);
	public List<Emp> getAll();
	public List<Emp> getByName(String name);
	public List<Emp> getByLimit(int m , int n);
	public List<Dept> getAllDept();
	public List<Emp> getByEname(String name);
	public List<Emp> getByNameLimit(String names , int m);
	public List<Emp> getByEnameLimit(String ename ,int m);
	public List<Emp> getBySLimit(int s_privilege , int m);
	public List<Emp> getByDept(int did);
 }
