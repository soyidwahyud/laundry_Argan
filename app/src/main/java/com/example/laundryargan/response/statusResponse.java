package com.example.laundryargan.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class statusResponse {
    @SerializedName("status")
    @Expose
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
