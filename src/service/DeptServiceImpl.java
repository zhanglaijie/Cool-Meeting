package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.DeptDao;
import dao.EmpDAO;
import po.Dept;
import po.Emp;

@Service(value="deptService")
@Transactional
public class DeptServiceImpl implements DeptService{

	@Autowired
	private DeptDao deptDAO;
	
	
	@Override
	public void addDept(Dept dept) {
		deptDAO.addDept(dept);
		
	}

	@Override
	public void updateDept(Dept dept) {
		deptDAO.updateDept(dept);
	}

	@Override
	public void deleteDept(Dept dept) {
		deptDAO.deleteEmp(dept);
	}

	@Override
	public Dept getById(int did) {
		
		return deptDAO.getById(did);
	}

	@Override
	public List<Dept> getAll() {
		return deptDAO.getAll();
	}

	@Override
	public Dept getByName(String name) {
		// TODO Auto-generated method stub
		
		return deptDAO.getByName(name);
	}

}
