package entity;

import java.io.Serializable;



public class Company implements Serializable {
    private static final long serialVersionUID = 1L;
    
	private String companyName;              
	private String socialReason;
	private boolean nonFiscalUser;
	private String fiscalResolution;
	private String companyId;
	private String rut;
	private String chainId;	
	private String environmentName; 
	
	public String getEnvironmentName() {
        return environmentName;
    }
    public void setEnvironmentName(String environmentName) {
        this.environmentName = environmentName;
    }
    public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getSocialReason() {
		return socialReason;
	}
	public void setSocialReason(String socialReason) {
		this.socialReason = socialReason;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
    public String getChainId() {
        return chainId;
    }
    public void setChainId(String chainId) {
        this.chainId = chainId;
    }
    public boolean getNonFiscalUser() {
        return nonFiscalUser;
    }
    public void setNonFiscalUser(boolean nonFiscalUser) {
        this.nonFiscalUser = nonFiscalUser;
    }
    public String getFiscalResolution() {
        return fiscalResolution;
    }
    public void setFiscalResolution(String fiscalResolution) {
        this.fiscalResolution = fiscalResolution;
    }
	
	
	

}
