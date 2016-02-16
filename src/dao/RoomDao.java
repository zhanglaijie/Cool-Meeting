package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import po.Emp;
import po.Room;


@Repository(value="roomDao")
public class RoomDao implements RoomDaoInter{

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session  getCurrentSessionFactory() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void add(Room room) {
		// TODO Auto-generated method stub
		Session session = this.getCurrentSessionFactory();
		session.save(room);
	}

	@Override
	public void update(Room room) {
		// TODO Auto-generated method stub
		Session session = this.getCurrentSessionFactory();
		session.update(room);
	}

	@Override
	public List<Room> getAll() {
		// TODO Auto-generated method stub
		Session session = this.getCurrentSessionFactory();
		return session.createQuery("from Room").list();
	}

	@Override
	public Room getById(String rid) {
		// TODO Auto-generated method stub
		Session session = this.getCurrentSessionFactory();
		return (Room) session.get(Room.class, rid) ;
	}
	public List<Room> getByRname(String rname)
	{
		Session session =  this.getCurrentSessionFactory();
		List<Room> li = session.createQuery("from Room where rname = '"+ rname + "'").list();
		return li;
	}
}
