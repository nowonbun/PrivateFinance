package Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="tsn_login_cookie")
@NamedQuery(name="LoginCookie.findAll", query="SELECT t FROM LoginCookie t")
public class LoginCookie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idx;

	private String cookiekey;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createddate;

	private boolean isdeleted;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="USERID")
	private User user;

	public LoginCookie() {
	}

	public int getIdx() {
		return this.idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getCookiekey() {
		return this.cookiekey;
	}

	public void setCookiekey(String cookiekey) {
		this.cookiekey = cookiekey;
	}

	public Date getCreateddate() {
		return this.createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public boolean getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(boolean isdeleted) {
		this.isdeleted = isdeleted;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}