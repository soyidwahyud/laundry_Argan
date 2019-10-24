
package com.example.laundryargan.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReadResponse {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("laundry")
    @Expose
    private List<Laundry> laundry = null;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<Laundry> getLaundry() {
        return laundry;
    }

    public void setLaundry(List<Laundry> laundry) {
        this.laundry = laundry;
    }

}
