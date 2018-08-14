package by.tataranovich.leasingcompany.model;


import java.util.List;


//@XmlRootElement(name = "leasingCompanies")
public class LeasingCompanyList {

    private List<LeasingCompany> leasingCompanyList;

    //@XmlElement(name = "leasingCompany")
    public List<LeasingCompany> getLeasingCompanyList() {
	return leasingCompanyList;
    }

    public void setLeasingCompanyList(List<LeasingCompany> leasingCompanyList) {
	this.leasingCompanyList = leasingCompanyList;
    }

}
