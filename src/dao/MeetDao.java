package dao;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import po.Dept;
import po.Emp;
import po.Meet;
import po.Room;

@Repository(value="meetDao")
public class MeetDao implements MeetDaoInter {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session  getCurrentSessionFactory() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void add(Meet meet) {
		// TODO Auto-generated method stub
		Session session = this.getCurrentSessionFactory();
		session.save(meet);
		
	}

	@Override
	public void delete(Meet meet) {
		// TODO Auto-generated method stub
		Session session = this.getCurrentSessionFactory();
		session.delete(meet);
	}
	
	@Override
	public void update(Meet meet) {
		// TODO Auto-generated method stub
		Session session = this.getCurrentSessionFactory();
		session.update(meet);
	}


	@Override
	public Meet getByName(String mname) {
		// TODO Auto-generated method stub
		Session session = this.getCurrentSessionFactory();
		return (Meet) session.get(Meet.class, mname) ;
	}

	@Override
	public List<Meet> getAll() {
		// TODO Auto-generated method stub
		Session session = this.getCurrentSessionFactory();
		return session.createQuery("from Meet").list();
	}

	@Override
	public List<Room> getAllRoom() {
		// TODO Auto-generated method stub
		Session session = this.getCurrentSessionFactory();
		return session.createQuery("from Room").list();
	}

	@Override
	public List<Emp> getAllEmp() {
		// TODO Auto-generated method stub
		Session session = this.getCurrentSessionFactory();
		return session.createQuery("from Emp").list();
	}

	@Override
	public List<Dept> getAllDept() {
		Session session = this.getCurrentSessionFactory();
		return session.createQuery("from Dept").list();
	}

	@Override
	public List<Emp> getEmpbyDept(Dept dept) {
		// TODO Auto-generated method stub
		Session session = this.getCurrentSessionFactory();
	//	Query query = (Query) 
		int did = dept.getDid();
		return session.createQuery("from Emp where dept.did ='"+did+"'").list();
		//.setString("dept",dept);
	}

	@Override
	public List<Meet> getMeetLimit(int m, int n) {
		// TODO Auto-generated method stub
		Session session =  this.getCurrentSessionFactory();
		Query query = session.createQuery("from Meet");
		query.setFirstResult(m);
		query.setMaxResults(n);
		return query.list();
	}

	@Override
	public List<Meet> getByEmp(Emp emp) {
		// TODO Auto-generated method stub
				Session session = this.getCurrentSessionFactory();
			//	Query query = (Query) 
				int eid =emp.getEid();
				return session.createQuery("from Meet where emp.eid ='"+eid+"'").list();
				//.setString("dept",dept);
	}

	@Override
	public List<Meet> getbyRoom(Room room) {
		Session session = this.getCurrentSessionFactory();
		String rid =room.getRid();
		return session.createQuery("from Meet where room.rid ='"+rid+"'").list();
	}

	@Override
	public List<Meet> getByTime() {
		Timestamp starttime = new Timestamp(System.currentTimeMillis());
		
		Date now = new Date();
		
		String str1 = DateFormat.getDateInstance().format(now);
		
		Timestamp zonetime = Timestamp.valueOf(str1 +" 23:59:59");
		
		Date date = new Date(zonetime.getTime());
		
		DateFormat Calender;
		
		Calendar cal = Calendar.getInstance();
		
		cal.setTime(date);
		
		cal.add(Calendar.DAY_OF_MONTH,7);
		
		Date date1=cal.getTime();
		
		Timestamp endtime = new Timestamp(date1.getTime());
		
		Session session = this.getCurrentSessionFactory();
		
		String hql = "from Meet where mstate=1 and mstarttime between ? and ?";
		
	    Query query = session.createQuery(hql);
	    
		query.setDate(0,starttime);	
		
		query.setDate(1,endtime);
		
		return query.list();
	}


	@Override
	public List<Meet> getByState() {
		
		Session session = this.getCurrentSessionFactory();
		Timestamp starttime = new Timestamp(System.currentTimeMillis());
		return session.createQuery("from Meet where mstarttime > '"+ starttime +"' and mstate = -1").list();
	}

	@Override
	public List<Meet> getByEid(int eid) {
		// TODO Auto-generated method stub
		Session session = this.getCurrentSessionFactory();
		Timestamp starttime = new Timestamp(System.currentTimeMillis());
		return session.createQuery("from Meet where mstarttime > '"+ starttime +"' and mstate = 1 and appointmentid = " + eid ).list();
	}

	@Override
	public List<Meet> getRealTimeLimit(Timestamp mstarttimes,
			Timestamp mendtimes) {
		Session session = this.getCurrentSessionFactory();
		
		String hql = "from Meet where mstarttime >= ? and mendtime<=?";
		
	    Query query = session.createQuery(hql);
	    
		query.setDate(0,mstarttimes);	
		
		query.setDate(1,mendtimes);
		
		return query.list();
	}

	@Override
	public List<Meet> getAppointTimeLimit(Timestamp appointstarts,
			Timestamp appointends) {
Session session = this.getCurrentSessionFactory();
		
		String hql = "from Meet where appointtime between ? and ?";
		
	    Query query = session.createQuery(hql);
	    
		query.setDate(0,appointstarts);	
		
		query.setDate(1,appointends);
		
		return query.list();
	}
}
