package entity;

import java.util.List;

import uy.com.geocom.geopos3.foodservice.terminal.Store;

public class StoreGerarchy {
    private String id;
    private Store store;
    private List<TerminalGerarchy> terminalGerarchyList;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Store getStore() {
        return store;
    }
    public void setStore(Store store) {
        this.store = store;
    }
    public List<TerminalGerarchy> getTerminalGerarchyList() {
        return terminalGerarchyList;
    }
    public void setTerminalGerarchyList(List<TerminalGerarchy> terminalGerarchyList) {
        this.terminalGerarchyList = terminalGerarchyList;
    }
   
    

}
