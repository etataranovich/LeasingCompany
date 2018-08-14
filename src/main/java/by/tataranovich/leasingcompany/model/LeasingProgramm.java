package by.tataranovich.leasingcompany.model;


//@XmlRootElement(name="leasingProgramm")
//@XmlAccessorType(XmlAccessType.FIELD)
public class LeasingProgramm extends IdEntity {

    private String name;
    private Integer maxYearTerm;
    private Integer commision;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public Integer getMaxYearTerm() {
	return maxYearTerm;
    }

    public void setMaxYearTerm(Integer maxYearTerm) {
	this.maxYearTerm = maxYearTerm;
    }

    public Integer getCommision() {
	return commision;
    }

    public void setCommision(Integer commision) {
	this.commision = commision;
    }
    @Override
    public String toString() {
	return "LeasingProgramm [id=" + getId() + ", name=" + name + ", maxYearTerm=" + maxYearTerm + ", commision=" + commision
		+ "]";
    }
    
}
