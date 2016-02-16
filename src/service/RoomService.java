package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import po.Room;
import dao.RoomDaoInter;
@Service(value="roomService")
@Transactional
public class RoomService implements RoomServiceInter {
	@Autowired
	private RoomDaoInter roomDao;
	@Override
	public void addRoom(Room room) {
		// TODO Auto-generated method stub
		roomDao.add(room);
	}

	@Override
	public void updateRoom(Room room) {
		// TODO Auto-generated method stub
		roomDao.update(room);
	}

	@Override
	public List<Room> getAllRoom() {
		// TODO Auto-generated method stub
		return roomDao.getAll();
	}

	@Override
	public Room getByIdRoom(String rid) {
		// TODO Auto-generated method stub
		return roomDao.getById(rid);
	}

	@Override
	public List<Room> getByRname(String rname) {
		// TODO Auto-generated method stub
		return roomDao.getByRname(rname);
	}

}
