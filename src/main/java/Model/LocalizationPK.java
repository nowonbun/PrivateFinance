package Model;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class LocalizationPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="`KEY`")
	private String key;

	@Column(insertable=false, updatable=false)
	private String type;

	public LocalizationPK() {
	}
	public String getKey() {
		return this.key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LocalizationPK)) {
			return false;
		}
		LocalizationPK castOther = (LocalizationPK)other;
		return 
			this.key.equals(castOther.key)
			&& this.type.equals(castOther.type);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.key.hashCode();
		hash = hash * prime + this.type.hashCode();
		
		return hash;
	}
}