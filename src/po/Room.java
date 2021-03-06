package po;

// Generated 2015-7-10 15:44:41 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Room generated by hbm2java
 */
@Entity
@Table(name = "room", catalog = "meeting")
public class Room implements java.io.Serializable {

	private String rid;
	private String rname;
	private Integer maxnum;
	private Integer rstate;
	private String rremark;
	private Set<Meet> meets = new HashSet<Meet>();

	public Room() {
	}

	public Room(String rid) {
		this.rid = rid;
	}

	public Room(String rid, String rname, Integer maxnum, Integer rstate,
			String rremark, Set meets) {
		this.rid = rid;
		this.rname = rname;
		this.maxnum = maxnum;
		this.rstate = rstate;
		this.rremark = rremark;
		this.meets = meets;
	}

	@Id
	@Column(name = "rid", unique = true, nullable = false, length = 20)
	public String getRid() {
		return this.rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	@Column(name = "rname", length = 20)
	public String getRname() {
		return this.rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	@Column(name = "maxnum")
	public Integer getMaxnum() {
		return this.maxnum;
	}

	public void setMaxnum(Integer maxnum) {
		this.maxnum = maxnum;
	}

	@Column(name = "rstate")
	public Integer getRstate() {
		return this.rstate;
	}

	public void setRstate(Integer rstate) {
		this.rstate = rstate;
	}

	@Column(name = "rremark", length = 100)
	public String getRremark() {
		return this.rremark;
	}

	public void setRremark(String rremark) {
		this.rremark = rremark;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "room")
	public Set<Meet> getMeets() {
		return meets;
	}

	public void setMeets(Set<Meet> meets) {
		this.meets = meets;
	}
}
