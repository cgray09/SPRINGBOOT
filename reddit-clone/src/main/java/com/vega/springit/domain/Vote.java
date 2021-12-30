package com.vega.springit.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Vote extends Auditable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private short direction;

    @NonNull
    @ManyToOne
    private Link link;
    
     
    
    public void setDirection(short direction) {
		// TODO Auto-generated method stub
		this.direction = direction;
	}
	
	public short getDirection() {
		// TODO Auto-generated method stub
		return this.direction;
	}
	
	 public void setLink(Link link) {
			// TODO Auto-generated method stub
			this.link = link;
		}
		
		public Link getLink() {
			// TODO Auto-generated method stub
			return this.link;
		}

}
