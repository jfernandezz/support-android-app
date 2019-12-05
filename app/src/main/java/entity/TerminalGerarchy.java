package entity;

import uy.com.geocom.geopos3.foodservice.terminal.Terminal;

public class TerminalGerarchy {
    String id;
    String name;
    Terminal terminal;
    
        
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Terminal getTerminal() {
        return terminal;
    }
    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }
    

}
