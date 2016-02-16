package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import po.Dept;
import po.Emp;
@Repository(value="empDAO")

public class EmpImpl implements EmpDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public Session  getCurrentSessionFactory() {
		return sessionFactory.getCurrentSession();
	}
	
	public void addEmp(Emp emp){
		 Session session =  this.getCurrentSessionFactory();
		 session.save(emp);

	}
	public void updateEmp(Emp emp){
		 Session session =  this.getCurrentSessionFactory();
		 session.update(emp);
	}
	public void deleteEmp(Emp emp){
		 Session session = this.getCurrentSessionFactory();
		 session.delete(emp);
	}
	public Emp getById(int eid){
		 Session session = this.getCurrentSessionFactory();
	    return	(Emp) session.get(Emp.class, eid);
	}
	public List<Emp> getAll(){ 
		Session session =  this.getCurrentSessionFactory();
		List<Emp> li = session.createQuery("from Emp").list();
		return li;	
	}
	
	public List<Dept> getAllDept(){
		Session session =  this.getCurrentSessionFactory();
		List<Dept> li = session.createQuery("from Dept").list();
		return li;
	
	}

	@Override
	public List<Emp> getByName(String name) {
		Session session =  this.getCurrentSessionFactory();
		List<Emp> list = session.createQuery("from Emp where names = '"+name +"'").list();
		return list;
	}

	@Override
	public List<Emp> getBys(int s_privilege) {
		Session session =  this.getCurrentSessionFactory();
		List<Emp> li = session.createQuery("from Emp where s_privilege = " + s_privilege).list();
		return li;
	}

	@Override
	public List<Emp> getByLimit(int m, int n) {
		Session session =  this.getCurrentSessionFactory();
		Query query = session.createQuery("from Emp");
		query.setFirstResult(m);
		query.setMaxResults(n);
		return query.list();
	}

	@Override
	public List<Emp> getByEname(String name) {
		Session session =  this.getCurrentSessionFactory();
		List<Emp> list = session.createQuery("from Emp where ename = '"+name +"'").list();
		return list;
	}

	@Override
	public List<Emp> getByNameLimit(String names, int m) {
		Session session =  this.getCurrentSessionFactory();
		Query query = session.createQuery("from Emp where names = '" + names + "'");
		query.setFirstResult(m);
		query.setMaxResults(10);
		return query.list();
	}

	@Override
	public List<Emp> getByEnameLimit(String ename, int m) {
		Session session =  this.getCurrentSessionFactory();
		Query query = session.createQuery("from Emp where ename = '" + ename + "'");
		query.setFirstResult(m);
		query.setMaxResults(10);
		return query.list();
	}

	@Override
	public List<Emp> getBySLimit(int s_privilege, int m) {
		Session session =  this.getCurrentSessionFactory();
		Query query = session.createQuery("from Emp where s_privilege =" + s_privilege);
		query.setFirstResult(m);
		query.setMaxResults(10);
		return query.list();
	}

	@Override
	public List<Emp> getByDept(int did) {
		Session session =  this.getCurrentSessionFactory();
		List<Emp> list = session.createQuery("from Emp where did = "+ did +"").list();
		return list;
	}
}
