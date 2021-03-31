package tn.kindergarten.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Comment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String Description;
	
	@Column(updatable = false, nullable = false)
    private Date creationDate;
	
    @Column(nullable = false)
    private Date lastUpdateDate;
	
    @JsonBackReference
	@ManyToOne 
	private Subject sub;
	
    @JsonBackReference
	@ManyToOne
	private User user;
	
	@JsonBackReference
	@OneToOne
	private Comment comment;
	
	public Comment () {}
	
	@PrePersist
    protected void onCreate() {
        this.creationDate = new Date();
        this.lastUpdateDate = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.lastUpdateDate = new Date();
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
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

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public Comment(int id, String description, Date creationDate, Date lastUpdateDate, Subject sub, User user,
			Comment comment) {
		super();
		this.id = id;
		Description = description;
		this.creationDate = creationDate;
		this.lastUpdateDate = lastUpdateDate;
		this.sub = sub;
		this.user = user;
		this.comment = comment;
	}

	public Comment(String description, Subject sub, User user, Comment comment) {
		super();
		Description = description;
		this.sub = sub;
		this.user = user;
		this.comment = comment;
	}

	
	

}
