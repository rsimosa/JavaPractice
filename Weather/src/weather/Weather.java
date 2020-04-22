package weather;

public class Weather {
    
    private String identifier;
    private String stateCode;
    private String countyCode;
    private String name;

    public Weather(String identifier, String stateCode, String countyCode, String name) {
        
        this.identifier = identifier;
        this.stateCode = stateCode;
        this.countyCode = countyCode;
        this.name = name;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getStateCode() {
        return stateCode;
    }

    public String getCountyCode() {
        return countyCode;
    }

    public String getName() {
        return name;
    }    
}
