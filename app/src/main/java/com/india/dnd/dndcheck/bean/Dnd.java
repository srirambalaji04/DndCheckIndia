package com.india.dnd.dndcheck.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sriram on 30/10/16.
 */

public class Dnd {

    @Expose
    @SerializedName("mobilenumber")
    private String mobileNumber;

    @Expose
    @SerializedName("DND_status")
    private String dndStatus;

    @Expose
    @SerializedName("activation_date")
    private String activationDate;

    @Expose
    @SerializedName("current_preference")
    private String currentPreference;

    @Expose
    @SerializedName("preference_history")
    private List<PreferenceHistory> preferenceHistory;

    public Dnd() {
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getDndStatus() {
        return dndStatus;
    }

    public void setDndStatus(String dndStatus) {
        this.dndStatus = dndStatus;
    }

    public String getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(String activationDate) {
        this.activationDate = activationDate;
    }

    public String getCurrentPreference() {
        return currentPreference;
    }

    public void setCurrentPreference(String currentPreference) {
        this.currentPreference = currentPreference;
    }

    public List<PreferenceHistory> getPreferenceHistory() {
        return preferenceHistory;
    }

    public void setPreferenceHistory(List<PreferenceHistory> preferenceHistory) {
        this.preferenceHistory = preferenceHistory;
    }

    @Override
    public String toString() {
        return "Dnd{" +
                "mobileNumber='" + mobileNumber + '\'' +
                ", dndStatus='" + dndStatus + '\'' +
                ", activationDate='" + activationDate + '\'' +
                ", currentPreference='" + currentPreference + '\'' +
                ", preferenceHistory=" + preferenceHistory +
                '}';
    }
}