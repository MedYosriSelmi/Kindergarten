package tn.kindergarten.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ListParticipantsPK   implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private Long idUser;
	
	private int idEvent;

	public ListParticipantsPK() {
		super();
	}

	public ListParticipantsPK(Long idUser, int idEvent) {
		super();
		this.idUser = idUser;
		this.idEvent = idEvent;
	}

	

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public int getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}

	
	
	

	
}
