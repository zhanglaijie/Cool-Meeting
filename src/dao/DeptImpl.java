package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import po.Dept;
import po.Emp;

@Repository(value="DeptDAO")

public class DeptImpl implements DeptDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session  getCurrentSessionFactory() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addDept(Dept dept) {
		// TODO Auto-generated method stub
		 Session session =  this.getCurrentSessionFactory();
		 session.save(dept);
		
	}

	@Override
	public void updateDept(Dept dept) {
		// TODO Auto-generated method stub
		 Session session =  this.getCurrentSessionFactory();
		 session.update(dept);
	}

	@Override
	public void deleteEmp(Dept dept) {
		// TODO Auto-generated method stub
		 Session session =  this.getCurrentSessionFactory();
		 session.delete(dept);
	}

	@Override
	public Dept getById(int did) {
		// TODO Auto-generated method stub
		 Session session = this.getCurrentSessionFactory();
		 return	(Dept) session.get(Dept.class, did);
	}
	
	@Override
	public List<Dept> getAll() {
		Session session =  this.getCurrentSessionFactory();
		List<Dept> li = session.createQuery("from Dept").list();
		return li;
	}

	@Override
	public Dept getByName(String name) {
		// TODO Auto-generated method stub
		 Session session = this.getCurrentSessionFactory();
		 List<Dept> temp = session.createQuery("from Dept where dname = '"+ name + "'").list();
		 return temp.get(0); 
	}

}
