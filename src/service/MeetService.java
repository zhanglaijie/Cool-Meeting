package service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import po.Dept;
import po.Emp;
import po.Meet;
import po.Room;
import dao.MeetDaoInter;

@Service(value="meetService")
@Transactional
public class MeetService implements MeetServiceInter {
	@Autowired
	MeetDaoInter meetDao;
	@Override
	public void addMeet(Meet meet) {
		// TODO Auto-generated method stub
			meetDao.add(meet);
	}

	@Override
	public void updateMeet(Meet meet) {
		// TODO Auto-generated method stub
		meetDao.update(meet);
	}

	@Override
	public void deleteMeet(Meet meet) {
		// TODO Auto-generated method stub
		meetDao.delete(meet);
	}

	@Override
	public Meet getByNameMeet(String mname) {
		// TODO Auto-generated method stub
		return meetDao.getByName(mname);
	}

	@Override
	public List<Meet> getAllMeet() {
		// TODO Auto-generated method stub
		return meetDao.getAll();
	}

	@Override
	public List<Room> getAllRoom() {
		// TODO Auto-generated method stub
		return meetDao.getAllRoom();
	}

	@Override
	public List<Emp> getAllEmp() {
		// TODO Auto-generated method stub
		return meetDao.getAllEmp();
	}

	@Override
	public List<Dept> getAllDept() {
		// TODO Auto-generated method stub
		return meetDao.getAllDept();
	}

	@Override
	public List<Emp> getEmpbyDept(Dept dept) {
		// TODO Auto-generated method stub
		return meetDao.getEmpbyDept(dept);
		
		
		
	}

	@Override
	public List<Meet> getMeetLimit(int n, int m) {
		// TODO Auto-generated method stub
		return meetDao.getMeetLimit(n, m);
	}

	@Override
	public List<Meet> getByEmp(Emp emp) {
		// TODO Auto-generated method stub
		return meetDao.getByEmp(emp);
	}

	@Override
	public List<Meet> getByRoom(Room room) {
		// TODO Auto-generated method stub
		return meetDao.getbyRoom(room);
	}
	@Override
	public List<Meet> getByTime() {
		// TODO Auto-generated method stub
		return meetDao.getByTime();
	}

	@Override
	public List<Meet> getByState() {
		// TODO Auto-generated method stub
		return meetDao.getByState();
	}

	@Override
	public List<Meet> getByeid(int eid) {
		// TODO Auto-generated method stub
		return meetDao.getByEid(eid);
	}

	@Override
	public List<Meet> getRealTimeLimit(Timestamp mstarttimes,
			Timestamp mendtimes) {
		// TODO Auto-generated method stub
		return meetDao.getRealTimeLimit(mstarttimes,mendtimes);
	}

	@Override
	public List<Meet> getAppointTimeLimit(Timestamp appointstarts,
			Timestamp appointends) {
		// TODO Auto-generated method stub
		return meetDao.getAppointTimeLimit(appointstarts,appointends);
	}



}
