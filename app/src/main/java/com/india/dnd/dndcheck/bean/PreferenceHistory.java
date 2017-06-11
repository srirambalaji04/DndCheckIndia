package com.india.dnd.dndcheck.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sriram on 30/10/16.
 */

public class PreferenceHistory {

    @Expose
    @SerializedName("preference_date")
    private String preferenceDate;

    @Expose
    private String preference;

    @Expose
    private String status;

    public PreferenceHistory() {
    }

    public String getPreferenceDate() {
        return preferenceDate;
    }

    public void setPreferenceDate(String preferenceDate) {
        this.preferenceDate = preferenceDate;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PreferenceHistory{" +
                "preferenceDate='" + preferenceDate + '\'' +
                ", preference='" + preference + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
