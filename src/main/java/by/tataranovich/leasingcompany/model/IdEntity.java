package by.tataranovich.leasingcompany.model;

public abstract class IdEntity {
    
    private Integer id;

    public IdEntity() {
	super();

    }

    public IdEntity(Integer id) {

	this.id = id;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

}