package tn.kindergarten.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Subject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String Name;

	private String Description;

	private String Photo;

	private boolean isApproved;

	@Column(updatable = false, nullable = false)
	private Date creationDate;

	@Column(nullable = false)
	private Date lastUpdateDate;

	@JsonManagedReference
	@OneToMany(mappedBy = "sub")
	private List<LikesSub> likes_sub;

	@JsonBackReference
	@ManyToOne
	private User user;

	@JsonManagedReference
	@OneToMany(mappedBy = "sub")
	private List<Comment> comments;

	public Subject() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getPhoto() {
		return Photo;
	}

	public void setPhoto(String photo) {
		Photo = photo;
	}

	@PrePersist
	protected void onCreate() {
		this.creationDate = new Date();
		this.lastUpdateDate = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.lastUpdateDate = new Date();
	}

	public List<LikesSub> getLikes_sub() {
		return likes_sub;
	}

	public void setLikes_sub(List<LikesSub> likes_sub) {
		this.likes_sub = likes_sub;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
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

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	public Subject(int id, String name, String description, String photo, boolean isApproved, Date creationDate,
			Date lastUpdateDate, List<LikesSub> likes_sub, User user, List<Comment> comments) {
		super();
		this.id = id;
		Name = name;
		Description = description;
		Photo = photo;
		this.isApproved = isApproved;
		this.creationDate = creationDate;
		this.lastUpdateDate = lastUpdateDate;
		this.likes_sub = likes_sub;
		this.user = user;
		this.comments = comments;
	}

	public Subject(String name, String description, String photo) {
		super();
		Name = name;
		Description = description;
		Photo = photo;
	}

}
