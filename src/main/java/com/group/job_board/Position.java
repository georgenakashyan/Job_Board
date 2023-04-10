/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group.job_board;

/**
 *
 * @author jimko
 */
public class Position {
    String positionTitle;
    String positionDescription;
    String positionPay;
    int positionSponsor;
    String positionAddress;
    boolean positionRemote;
    boolean positionActive;

    public Position() {
        this.positionTitle = "";
        this.positionDescription = "";
        this.positionPay = "";
        this.positionAddress = "";
    }

    public Position(String positionTitle, String positionDescription, String positionPay, int positionSponsor, String positionAddress, boolean positionRemote, boolean positionActive) {
        this.positionTitle = positionTitle;
        this.positionDescription = positionDescription;
        this.positionPay = positionPay;
        this.positionSponsor = positionSponsor;
        this.positionAddress = positionAddress;
        this.positionRemote = positionRemote;
        this.positionActive = positionActive;
    }

    public String getPositionTitle() {
        return positionTitle;
    }

    public void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
    }

    public String getPositionDescription() {
        return positionDescription;
    }

    public void setPositionDescription(String positionDescription) {
        this.positionDescription = positionDescription;
    }

    public String getPositionPay() {
        return positionPay;
    }

    public void setPositionPay(String positionPay) {
        this.positionPay = positionPay;
    }

    public int getPositionSponsor() {
        return positionSponsor;
    }

    public void setPositionSponsor(int positionSponsor) {
        this.positionSponsor = positionSponsor;
    }

    public String getPositionAddress() {
        return positionAddress;
    }

    public void setPositionAddress(String positionAddress) {
        this.positionAddress = positionAddress;
    }

    public boolean isPositionRemote() {
        return positionRemote;
    }

    public void setPositionRemote(boolean positionRemote) {
        this.positionRemote = positionRemote;
    }

    public boolean isPositionActive() {
        return positionActive;
    }

    public void setPositionActive(boolean positionActive) {
        this.positionActive = positionActive;
    }
    
    
}
