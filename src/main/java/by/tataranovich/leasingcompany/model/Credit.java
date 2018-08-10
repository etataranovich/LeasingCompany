package by.tataranovich.leasingcompany.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import by.tataranovich.leasingcompany.model.IdEntity;

@XmlRootElement(name="credit")
@XmlAccessorType(XmlAccessType.FIELD)
public class Credit extends IdEntity {

    private Integer loanAmount;
    private Integer interestRate;
    private Integer term;

    public Integer getLoanAmount() {
	return loanAmount;
    }

    public void setLoanAmount(Integer loanAmount) {
	this.loanAmount = loanAmount;
    }

    public Integer getInterestRate() {
	return interestRate;
    }

    public void setInterestRate(Integer interestRate) {
	this.interestRate = interestRate;
    }

    public Integer getTerm() {
	return term;
    }

    public void setTerm(Integer term) {
	this.term = term;
    }

    @Override
    public String toString() {
	return "Credit [id=" + getId() + ", loanAmount=" + loanAmount + ", interestRate=" + interestRate + ", term"
		+ term + "]";
    }

}
