package tn.kindergarten.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class LikesSubPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 private int idUser;
		
     private int idSub;

	public LikesSubPK() {
		super();
	}

	public LikesSubPK(int idUser, int idSub) {
		super();
		this.idUser = idUser;
		this.idSub = idSub;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdSub() {
		return idSub;
	}

	public void setIdSub(int idSub) {
		this.idSub = idSub;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idSub;
		result = prime * result + idUser;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LikesSubPK other = (LikesSubPK) obj;
		if (idSub != other.idSub)
			return false;
		if (idUser != other.idUser)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LikesSubPK [idUser=" + idUser + ", idSub=" + idSub + "]";
	}
     
     
 
	
}
