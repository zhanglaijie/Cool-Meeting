package dao;

import java.util.List;
import po.Dept;
import po.Emp;

public interface DeptDao {
	public void addDept(Dept dept);
	public void updateDept(Dept dept);
	public void deleteEmp(Dept dept);
	public Dept getById(int did);
	public Dept getByName(String name);
	public List<Dept> getAll();
}
