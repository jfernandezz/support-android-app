package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class RedisCompany implements Serializable {
    private static final long serialVersionUID = 1L;
    private Date          _ts;
    private List<Company> lsCompany;

    public Date getTs() {
        return _ts;
    }

    public void setTs(Date _ts) {
        this._ts = _ts;
    }

    public List<Company> getLsCompany() {
        return lsCompany;
    }

    public void setLsCompany(List<Company> lsCompany) {
        this.lsCompany = lsCompany;
    }

}
