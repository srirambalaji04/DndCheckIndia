package com.india.dnd.dndcheck.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.india.dnd.dndcheck.bean.Dnd;

import java.util.List;

/**
 * Created by sriram on 30/10/16.
 */

public class DndRsp {

    @Expose
    @SerializedName("response")
    private List<Dnd> dnds;

    public DndRsp() {
    }

    public List<Dnd> getDnds() {
        return dnds;
    }

    public void setDnds(List<Dnd> dnds) {
        this.dnds = dnds;
    }

    @Override
    public String toString() {
        return "DndRsp{" +
                "dnds=" + dnds +
                '}';
    }
}
