package com.example.DTO;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class WifiDTO {

    @SerializedName("TbPublicWifiInfo")
    @Expose
    private TbPublicWifiInfo tbPublicWifiInfo;

    public TbPublicWifiInfo getTbPublicWifiInfo() {
        return tbPublicWifiInfo;
    }

    public void setTbPublicWifiInfo(TbPublicWifiInfo tbPublicWifiInfo) {
        this.tbPublicWifiInfo = tbPublicWifiInfo;
    }

}