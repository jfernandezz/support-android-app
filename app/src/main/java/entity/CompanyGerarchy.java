package entity;

import java.util.Date;
import java.util.List;



import com.google.gson.annotations.SerializedName;

public class CompanyGerarchy {
    private static final long serialVersionUID = 1L;
    @SerializedName("id")
    private String id;
    private String companyId;
    private CompanyConfiguration companyConfiguration;
    private List<ChainGerarchy> chainGerarchyList;
    private String state;
    private Date savedDate;
    private Date processedDate;
    private String articlesFile;
    private String clientsFile;
    private String ticketAddendum;
    private boolean articlesFileOk;
    private boolean clientsFileOk;
    
    public String getArticlesFile() {
        return articlesFile;
    }
    public void setArticlesFile(String articlesFile) {
        this.articlesFile = articlesFile;
    }
    public String getClientsFile() {
        return clientsFile;
    }
    public void setClientsFile(String clientsFile) {
        this.clientsFile = clientsFile;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getCompanyId() {
        return companyId;
    }
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
    public CompanyConfiguration getCompanyConfiguration() {
        return companyConfiguration;
    }
    public void setCompanyConfiguration(CompanyConfiguration companyConfiguration) {
        this.companyConfiguration = companyConfiguration;
    }
    public List<ChainGerarchy> getChainGerarchyList() {
        return chainGerarchyList;
    }
    public void setChainGerarchyList(List<ChainGerarchy> chainGerarchyList) {
        this.chainGerarchyList = chainGerarchyList;
    }    
    public Date getProcessedDate() {
        return processedDate;
    }
    public void setProcessedDate(Date processedDate) {
        this.processedDate = processedDate;
    }
    public Date getSavedDate() {
        return savedDate;
    }
    public void setSavedDate(Date savedDate) {
        this.savedDate = savedDate;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public boolean isArticlesFileOk() {
        return articlesFileOk;
    }
    public void setArticlesFileOk(boolean articlesFileOk) {
        this.articlesFileOk = articlesFileOk;
    }
    public boolean isClientsFileOk() {
        return clientsFileOk;
    }
    public void setClientsFileOk(boolean clientsFileOk) {
        this.clientsFileOk = clientsFileOk;
    }
    public String getTicketAddendum() {
        return ticketAddendum;
    }
    public void setTicketAddendum(String ticketAddendum) {
        this.ticketAddendum = ticketAddendum;
    }
   
    

}
