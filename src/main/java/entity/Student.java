package entity;

/**
 * @author DarryYang
 *
 */
public class Student {

	private Integer sid;
	private String sname;
	private String sphone;
	private int sage;
	private String ssex;
	private String sclass;
	private String scollege;
	private String simg;

	public Student() {
		super();
	}

	public Student(Integer sid, String sname, String sphone, int sage, String ssex, String sclass, String scollege,
			String simg) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sphone = sphone;
		this.sage = sage;
		this.ssex = ssex;
		this.sclass = sclass;
		this.scollege = scollege;
		this.simg = simg;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSphone() {
		return sphone;
	}

	public void setSphone(String sphone) {
		this.sphone = sphone;
	}

	public int getSage() {
		return sage;
	}

	public void setSage(int sage) {
		this.sage = sage;
	}

	public String getSsex() {
		return ssex;
	}

	public void setSsex(String ssex) {
		this.ssex = ssex;
	}

	public String getSclass() {
		return sclass;
	}

	public void setSclass(String sclass) {
		this.sclass = sclass;
	}

	public String getScollege() {
		return scollege;
	}

	public void setScollege(String scollege) {
		this.scollege = scollege;
	}

	public String getSimg() {
		return simg;
	}

	public void setSimg(String simg) {
		this.simg = simg;
	}

}
