package entity;


import uy.com.geocom.geopos3.foodservice.Address;
public class CompanyConfiguration extends Company { 
  
    private boolean nonFiscal;
    private String  phone; 
    private String  geoUserId;
    private String  userId;
    private String  userName;
    private String  userMail;
    private String  userPassword;
    private boolean pharmacy;  
    private boolean defaultArticles;
    private boolean defaultPayment;
    private boolean defaultCurrency;
    private boolean useExpressCreditAuth;
    private boolean blockConfigurations;
    private Address address;
    private String pos2000TerminalId;
    private String userPin;
   
        
  
    public boolean isUseExpressCreditAuth() {
        return useExpressCreditAuth;
    }
    public void setUseExpressCreditAuth(boolean useExpressCreditAuth) {
        this.useExpressCreditAuth = useExpressCreditAuth;
    }
    public boolean isNonFiscal() {
        return nonFiscal;
    }
    public void setNonFiscal(boolean nonFiscal) {
        this.nonFiscal = nonFiscal;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getGeoUserId() {
        return geoUserId;
    }
    public void setGeoUserId(String geoUserId) {
        this.geoUserId = geoUserId;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserMail() {
        return userMail;
    }
    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
  
    public boolean isPharmacy() {
        return pharmacy;
    }
    public void setPharmacy(boolean pharmacy) {
        this.pharmacy = pharmacy;
    }
    public String getUserPassword() {
        return userPassword;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    public boolean isDefaultArticles() {
        return defaultArticles;
    }
    public void setDefaultArticles(boolean defaultArticles) {
        this.defaultArticles = defaultArticles;
    }
    public boolean isDefaultPayment() {
        return defaultPayment;
    }
    public void setDefaultPayment(boolean defaultPayment) {
        this.defaultPayment = defaultPayment;
    }
    public boolean isDefaultCurrency() {
        return defaultCurrency;
    }
    public void setDefaultCurrency(boolean defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }
    public String getPos2000TerminalId() {
        return pos2000TerminalId;
    }
    public void setPos2000TerminalId(String pos2000TerminalId) {
        this.pos2000TerminalId = pos2000TerminalId;
    }
    public String getUserPin() {
        return userPin;
    }
    public void setUserPin(String userPin) {
        this.userPin = userPin;
    }
	public boolean isBlockConfigurations() {
		return blockConfigurations;
	}
	public void setBlockConfigurations(boolean blockConfigurations) {
		this.blockConfigurations = blockConfigurations;
	}

    
    
    
}
