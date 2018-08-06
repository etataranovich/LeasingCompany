package by.tataranovich.leasingcompany.model;

import by.tataranovich.leasingcompany.model.IdEntity;

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
