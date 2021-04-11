package tn.kindergarten.entities;


import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;



//import com.sun.istack.NotNull;







@Entity
@Table(	name = "users",
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "username"),
			@UniqueConstraint(columnNames = "email") 
		})
public class User implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	@Size(max = 20)
	private String username;

	@NotBlank
	@Size(max = 20)
	private String FirstName;
	
	@NotBlank
	@Size(max = 20)
	private String LastName;
	
	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	private boolean active = false;
	
	@NotBlank
	@Size(max = 120)
	private String password;
	
	
	@Temporal(TemporalType.DATE)
	private Date DateOfBirth;
	
	private String Photo;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	public User() {
	}

	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}

	
	
	
	public User(@NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
			boolean active, @NotBlank @Size(max = 120) String password) {
		super();
		this.username = username;
		this.email = email;
		this.active = active;
		this.password = password;
	}




	//all relations  in database
	
	@OneToMany(mappedBy="user")
	private List<ListParticipants> list_participants;
	
	@OneToMany(mappedBy="user")
	private List<LikesSub> likes_subs;
	
	@OneToMany(mappedBy="user")
	private List<LikesPub> likes_pubs;
	
	@OneToMany(mappedBy="user")
	private List<Subject> list_subject;
	
	@OneToMany(mappedBy="user")
	private List<Reclamation> list_reclams;
	
	@OneToMany(mappedBy="user")
	private List<Publication> list_pub;
	
	
	@ManyToMany(mappedBy="user", fetch = FetchType.EAGER)
	private List<Kindergarten> kindergarten;
	
	@OneToMany(mappedBy="user")
	private List<Event> list_events;
	
	@OneToMany(mappedBy="user")
	private List<Comment> comments;
	
	@OneToMany(mappedBy="user")
	private List<Child> list_child;
	
	@OneToMany(mappedBy="user")
	private List<Bill> list_fact;
	
	@OneToMany(mappedBy="user")
	private List<Appointment> list_appoint;
	
	@OneToMany(mappedBy="user")
	private List<Activity> list_act;
	
	@OneToMany(mappedBy="user")
	private List<Planning> list_plan;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public List<ListParticipants> getList_participants() {
		return list_participants;
	}

	public void setList_participants(List<ListParticipants> list_participants) {
		this.list_participants = list_participants;
	}

	public List<LikesSub> getLikes_subs() {
		return likes_subs;
	}

	public void setLikes_subs(List<LikesSub> likes_subs) {
		this.likes_subs = likes_subs;
	}

	public List<LikesPub> getLikes_pubs() {
		return likes_pubs;
	}

	public void setLikes_pubs(List<LikesPub> likes_pubs) {
		this.likes_pubs = likes_pubs;
	}

	public List<Subject> getList_subject() {
		return list_subject;
	}

	public void setList_subject(List<Subject> list_subject) {
		this.list_subject = list_subject;
	}

	public List<Reclamation> getList_reclams() {
		return list_reclams;
	}

	public void setList_reclams(List<Reclamation> list_reclams) {
		this.list_reclams = list_reclams;
	}

	public List<Publication> getList_pub() {
		return list_pub;
	}

	public void setList_pub(List<Publication> list_pub) {
		this.list_pub = list_pub;
	}

	public List<Kindergarten> getKindergarten() {
		return kindergarten;
	}

	public void setKindergarten(List<Kindergarten> kindergarten) {
		this.kindergarten = kindergarten;
	}

	public List<Event> getList_events() {
		return list_events;
	}

	public void setList_events(List<Event> list_events) {
		this.list_events = list_events;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Child> getList_child() {
		return list_child;
	}

	public void setList_child(List<Child> list_child) {
		this.list_child = list_child;
	}

	public List<Bill> getList_fact() {
		return list_fact;
	}

	public void setList_fact(List<Bill> list_fact) {
		this.list_fact = list_fact;
	}

	public List<Appointment> getList_appoint() {
		return list_appoint;
	}

	public void setList_appoint(List<Appointment> list_appoint) {
		this.list_appoint = list_appoint;
	}

	public List<Activity> getList_act() {
		return list_act;
	}

	public void setList_act(List<Activity> list_act) {
		this.list_act = list_act;
	}

	public List<Planning> getList_plan() {
		return list_plan;
	}

	public void setList_plan(List<Planning> list_plan) {
		this.list_plan = list_plan;
	}


	public Date getDateOfBirth() {
		return DateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}

	public String getPhoto() {
		return Photo;
	}

	public void setPhoto(String photo) {
		Photo = photo;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
  }

	
}
