package tn.kindergarten.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class LikesSub  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonBackReference
	@EmbeddedId
    private LikesSubPK likessubPK;
	
	@JsonBackReference
	@ManyToOne
    @JoinColumn(name = "idSub", referencedColumnName = "id", insertable=false, updatable=false)
	private Subject sub;
	
	@JsonBackReference
	@ManyToOne
    @JoinColumn(name = "idUser", referencedColumnName = "id", insertable=false, updatable=false)
	private User user;
	
	
	@Column(updatable = false, nullable = false)
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

	@PrePersist
    protected void onCreate() {
	        this.DateLikeSub = new Date();
	}

	    
	

	
}
