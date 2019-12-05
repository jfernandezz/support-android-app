package entity;

import java.util.List;

import uy.com.geocom.geopos3.foodservice.terminal.Chain;

public class ChainGerarchy {
    private String id;
    private Chain chain;
    private String companyImage;
    private String ticketImage;    
    private boolean companyImageOk;
    private boolean ticketImageOk;    
    
    private List<StoreGerarchy> storeGerarchyList;   
    
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getCompanyImage() {
        return companyImage;
    }
    public void setCompanyImage(String companyImage) {
        this.companyImage = companyImage;
    }
    public String getTicketImage() {
        return ticketImage;
    }
    public void setTicketImage(String ticketImage) {
        this.ticketImage = ticketImage;
    }
  
    public Chain getChain() {
        return chain;
    }
    public void setChain(Chain chain) {
        this.chain = chain;
    }
    public List<StoreGerarchy> getStoreGerarchyList() {
        return storeGerarchyList;
    }
    public void setStoreGerarchyList(List<StoreGerarchy> storeGerarchyList) {
        this.storeGerarchyList = storeGerarchyList;
    }
    public boolean isCompanyImageOk() {
        return companyImageOk;
    }
    public void setCompanyImageOk(boolean companyImageOk) {
        this.companyImageOk = companyImageOk;
    }
    public boolean isTicketImageOk() {
        return ticketImageOk;
    }
    public void setTicketImageOk(boolean ticketImageOk) {
        this.ticketImageOk = ticketImageOk;
    }
   
    
    
}
