package tn.kindergarten.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class LikesSub  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
    private LikesSubPK likessubPK;
	
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "idSub", referencedColumnName = "id", insertable=false, updatable=false)
	private Subject sub;
	
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "idUser", referencedColumnName = "id", insertable=false, updatable=false)
	private User user;
	
	@JsonIgnore
	@Temporal(TemporalType.DATE)
	private Date DateLikeSub;

	public LikesSubPK getLikessubPK() {
		return likessubPK;
	}

	public void setLikessubPK(LikesSubPK likessubPK) {
		this.likessubPK = likessubPK;
	}

	public Subject getSub() {
		return sub;
	}

	public void setSub(Subject sub) {
		this.sub = sub;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDateLikeSub() {
		return DateLikeSub;
	}

	public void setDateLikeSub(Date dateLikeSub) {
		DateLikeSub = dateLikeSub;
	}

	
	

	
}
