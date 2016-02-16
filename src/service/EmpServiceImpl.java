package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import po.Dept;
import po.Emp;
import dao.EmpDAO;
@Service(value="empService")
@Transactional
public class EmpServiceImpl implements EmpService{

	@Autowired
	private EmpDAO empDAO;
	@Override
	public void addEmp(Emp emp) {
		// TODO Auto-generated method stub
		empDAO.addEmp(emp);
	}

	@Override
	public void updateEmp(Emp emp) {
		// TODO Auto-generated method stub
		empDAO.updateEmp(emp);
	}

	@Override
	
	public void deleteEmp(Emp emp) {
		// TODO Auto-generated method stub
		empDAO.deleteEmp(emp);
	}

	@Override
	public Emp getById(int eid) {
		// TODO Auto-generated method stub
		return empDAO.getById(eid);
	}
	
	@Override
	public List<Emp> getAll(){
		// TODO Auto-generated method stub
		return empDAO.getAll();
	}
	public List<Dept> getAllDept(){
		return empDAO.getAllDept();
	}

	@Override
	public List<Emp> getByName(String name) {
		// TODO Auto-generated method stub
		return empDAO.getByName(name);
	}

	@Override
	public List<Emp> getBys(int s_privilege) {
		// TODO Auto-generated method stub
		return empDAO.getBys(s_privilege);
	}

	@Override
	public List<Emp> getByLimit(int m, int n) {
		// TODO Auto-generated method stub
		return empDAO.getByLimit(m, n);
	}

	@Override
	public List<Emp> getByEname(String name) {
		// TODO Auto-generated method stub
		return empDAO.getByEname(name);
	}

	@Override
	public List<Emp> getByNameLimit(String names, int m) {
		// TODO Auto-generated method stub
		return empDAO.getByNameLimit(names, m);
	}

	@Override
	public List<Emp> getByENameLimit(String ename, int m) {
		// TODO Auto-generated method stub
		return empDAO.getByEnameLimit(ename, m);
	}

	@Override
	public List<Emp> getBySLimit(int s_privilege, int m) {
		// TODO Auto-generated method stub
		return empDAO.getBySLimit(s_privilege, m);
	}

	@Override
	public List<Emp> getByDid(int did) {
		// TODO Auto-generated method stub
		return empDAO.getByDept(did);
	}
}
