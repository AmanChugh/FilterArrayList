package ammyaman.testing;

import java.io.Serializable;

/**
 * Created by CH-E01449 on 14-02-2018.
 */

public class FilterModel implements Serializable {

    private String type;
    private String cat;
    private String country;
    private String state;
    private String city;
    private String status;

    public FilterModel(String type, String cat, String country, String state, String city, String status) {
        this.type = type;
        this.cat = cat;
        this.country = country;
        this.state = state;
        this.city = city;
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public String getCat() {
        return cat;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return type + "," + cat + "," + country + "," + state + "," + city + "," + status;
    }


}
