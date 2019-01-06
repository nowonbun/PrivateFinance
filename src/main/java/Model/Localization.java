package Model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "mst_localization")
@NamedQuery(name = "Localization.findAll", query = "SELECT l FROM Localization l where l.isactive = true")
public class Localization implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LocalizationPK id;

	private boolean isactive;

	private String value;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TYPE")
	private LanguageType languaueType;

	public Localization() {
	}

	public LocalizationPK getId() {
		return this.id;
	}

	public void setId(LocalizationPK id) {
		this.id = id;
	}

	public boolean getIsactive() {
		return this.isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public LanguageType getLanguaueType() {
		return this.languaueType;
	}

	public void setLanguaueType(LanguageType languaueType) {
		this.languaueType = languaueType;
	}

}