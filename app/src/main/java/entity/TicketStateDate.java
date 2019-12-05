package entity;

import java.io.Serializable;
import java.util.Date;



public class TicketStateDate implements Serializable {
    private static final long serialVersionUID = 1L;

    public Geopos3SupportState state;
    public Date                date;

    public TicketStateDate() {
    }
    
    public TicketStateDate(Geopos3SupportState state, Date date) {
        this.state = state;
        this.date = date;
    }

    public Geopos3SupportState getState() {
        return state;
    }

    public void setState(Geopos3SupportState state) {
        this.state = state;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}