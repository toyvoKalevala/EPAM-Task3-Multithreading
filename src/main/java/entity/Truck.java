package entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Truck implements Runnable {

    @JsonProperty
    private long id;
    @JsonProperty
    private boolean loading;

    @Override
    public void run() {
        Base base = Base.getInstance();
        base.process(this);
    }

    public boolean getLoading() {
        return loading;
    }

    public void setLoading(boolean loading) {
        this.loading = loading;
    }

    public long getId() {
        return id;
    }

}
