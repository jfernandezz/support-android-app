package entity;



import uy.com.geocom.geopos3.util.resource.EntityResource;

public class EntityResourceModel extends EntityResource {
    private static final long serialVersionUID = 1L;
    private String posibleValuesType; 
    private String dataValuesType;
    
    public String getPosibleValuesType() {
        return posibleValuesType;
    }
    public void setPosibleValuesType(String posibleValuesType) {
        this.posibleValuesType = posibleValuesType;
    }
    public String getDataValuesType() {
        return dataValuesType;
    }
    public void setDataValuesType(String dataValuesType) {
        this.dataValuesType = dataValuesType;
    }
    

}
