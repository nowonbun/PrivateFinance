package Model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="mst_menu")
@NamedQuery(name="Menu.findAll", query="SELECT m FROM Menu m where m.isactive = true")
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String code;

	private String icon;

	private boolean isactive;

	private String link;

	private String name;

	private int sequence;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="VIEWCODE")
	private Viewrole viewrole;

	public Menu() {
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public boolean getIsactive() {
		return this.isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSequence() {
		return this.sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public Viewrole getViewrole() {
		return this.viewrole;
	}

	public void setViewrole(Viewrole viewrole) {
		this.viewrole = viewrole;
	}

}