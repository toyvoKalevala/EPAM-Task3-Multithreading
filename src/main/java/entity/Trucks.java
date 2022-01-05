package entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Trucks {

    @JsonProperty
    private ArrayList<Truck> trucks;

    public List<Truck> getTracks() {
        return trucks;
    }

}
