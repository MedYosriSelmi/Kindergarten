package tn.kindergarten.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class LikesPub  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
    private LikesPubPK likespubPK;
	
	
	@ManyToOne
    @JoinColumn(name = "idPub", referencedColumnName = "id", insertable=false, updatable=false)
	private Publication pub;
	
	@ManyToOne
    @JoinColumn(name = "idUser", referencedColumnName = "id", insertable=false, updatable=false)
	private User user;

	@Temporal(TemporalType.DATE)
	private Date DateLikePub;

	public LikesPub() {
		super();
	}


	public LikesPubPK getLikespubPK() {
		return likespubPK;
	}


	public void setLikespubPK(LikesPubPK likespubPK) {
		this.likespubPK = likespubPK;
	}


	public Publication getPub() {
		return pub;
	}


	public void setPub(Publication pub) {
		this.pub = pub;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Date getDateLikePub() {
		return DateLikePub;
	}


	public void setDateLikePub(Date dateLikePub) {
		DateLikePub = dateLikePub;
	}

	

	
	
	
	


}
