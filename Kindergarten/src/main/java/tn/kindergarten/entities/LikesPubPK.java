package tn.kindergarten.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class LikesPubPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private int idUser;
		
	private int idPub;

	public LikesPubPK() {
		super();
	}

	public LikesPubPK(int idUser, int idPub) {
		super();
		this.idUser = idUser;
		this.idPub = idPub;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdPub() {
		return idPub;
	}

	public void setIdPub(int idPub) {
		this.idPub = idPub;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idPub;
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
		LikesPubPK other = (LikesPubPK) obj;
		if (idPub != other.idPub)
			return false;
		if (idUser != other.idUser)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LikesPubPK [idUser=" + idUser + ", idPub=" + idPub + "]";
	}

	

	
	

	
	
	

}
