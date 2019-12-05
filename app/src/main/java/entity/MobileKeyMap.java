package entity;




public class MobileKeyMap {
   private static final long serialVersionUID = 1L; 
   private String id;
   private String companyId;
   private String key;
   private String auxKey;
   private String nodeType;
 

   
 /*  public MobileKeyMap(String id, String companyId, String key,String auxKey, String nodeType) {
       this.id = id;
       this.companyId = companyId;
       this.key = key;
       this.auxKey = auxKey;
       this.nodeType = nodeType;
   }  
   
   public MobileKeyMap(String id, String companyId, String key, String nodeType) {    
    this.id = id;
    this.companyId = companyId;
    this.key = key;
    this.nodeType = nodeType;
   }*/

   public String getAuxKey() {
       return auxKey;
   }

   public void setAuxKey(String auxKey) {
       this.auxKey = auxKey;
   }

    public String getNodeType() {
       return nodeType;
    }
    
    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getCompanyId() {
        return companyId;
    }
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
       

}
