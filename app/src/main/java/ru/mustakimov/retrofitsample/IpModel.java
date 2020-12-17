package ru.mustakimov.retrofitsample;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class IpModel {

    @SerializedName("ip")
    @Expose
    private String ip;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }


}
