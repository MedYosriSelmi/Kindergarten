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
public class ListParticipants implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	    @EmbeddedId
	    private ListParticipantsPK listparticipantsPK;
	
		@ManyToOne
	    @JoinColumn(name = "idEvent", referencedColumnName = "id", insertable=false, updatable=false)
		private Event event;
		
		@ManyToOne
	    @JoinColumn(name = "idUser", referencedColumnName = "id", insertable=false, updatable=false)
		private User user;
		
		@Temporal(TemporalType.DATE)
		private Date DateParticipation;

		public ListParticipants() {
			super();
		}

		
		public ListParticipantsPK getListparticipantsPK() {
			return listparticipantsPK;
		}

		public void setListparticipantsPK(ListParticipantsPK listparticipantsPK) {
			this.listparticipantsPK = listparticipantsPK;
		}

		public Event getEvent() {
			return event;
		}

		public void setEvent(Event event) {
			this.event = event;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public Date getDateParticipation() {
			return DateParticipation;
		}

		public void setDateParticipation(Date dateParticipation) {
			DateParticipation = dateParticipation;
		}


		

		

	

}
