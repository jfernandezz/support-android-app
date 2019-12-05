package entity;

import java.io.Serializable;
import java.util.Date;

public class SupportTicket implements Serializable {
    private static final long serialVersionUID = 1L;
    private String            id;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    private String              supportUserName;
    private String              userName;
    private String              action;
    private Company             company;
    private Geopos3SupportState state = Geopos3SupportState.OPEN;

    private TicketStateDate ticketStateDates[] = new TicketStateDate[Geopos3SupportState.values().length];

    public SupportTicket() {
        Date now = new Date();
        for (int i = 0; i < ticketStateDates.length; i++) {
            Geopos3SupportState dState[] = Geopos3SupportState.values();
            if (dState[i] == Geopos3SupportState.OPEN) {
                ticketStateDates[i] = new TicketStateDate(dState[i], now);
            } else {
                ticketStateDates[i] = new TicketStateDate(dState[i], null);
            }

        }
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Geopos3SupportState getState() {
        return state;
    }

    public void setState(Geopos3SupportState state) {
        this.state = state;
    }

    public void setStateDate(Geopos3SupportState newState) {
        if (newState != null)
            ticketStateDates[newState.ordinal()].setDate(new Date());
    }

    public String getSupportUserName() {
        return supportUserName;
    }

    public void setSupportUserName(String supportUserName) {
        this.supportUserName = supportUserName;
    }

    public TicketStateDate[] getTicketStateDates() {
        return ticketStateDates;
    }

    public void setTicketStateDates(TicketStateDate[] ticketStateDates) {
        this.ticketStateDates = ticketStateDates;
    }
    
    
}