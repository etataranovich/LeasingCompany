package by.tataranovich.leasingcompany.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class IdEntity {
    
   @JsonProperty
    private Long id;

    public IdEntity() {
	super();

    }

    public IdEntity(Long id) {

	this.id = id;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

}