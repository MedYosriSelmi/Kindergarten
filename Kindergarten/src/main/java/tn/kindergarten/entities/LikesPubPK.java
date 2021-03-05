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
		
	private int idLikesPub;

	public LikesPubPK() {
		super();
	}

	public LikesPubPK(int idUser, int idLikesPub) {
		super();
		this.idUser = idUser;
		this.idLikesPub = idLikesPub;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdLikesPub() {
		return idLikesPub;
	}

	public void setIdLikesPub(int idLikesPub) {
		this.idLikesPub = idLikesPub;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idLikesPub;
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
		if (idLikesPub != other.idLikesPub)
			return false;
		if (idUser != other.idUser)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LikesPubPK [idUser=" + idUser + ", idLikesPub=" + idLikesPub + "]";
	}
	
	

}
