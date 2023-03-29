/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group.job_board;

/**
 *
 * @author main
 */
public class Resume {

    String name, academicInfo, personalDetails;

    public Resume(String name, String academicInfo, String personalDetails) {
        this.name = name;
        this.academicInfo = academicInfo;
        this.personalDetails = personalDetails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcademicInfo() {
        return academicInfo;
    }

    public void setAcademicInfo(String academicInfo) {
        this.academicInfo = academicInfo;
    }

    public String getPersonalDetails() {
        return personalDetails;
    }

    public void setPersonalDetails(String personalDetails) {
        this.personalDetails = personalDetails;
    }

    // prototype methods
    public static void uploadResume() {
    }

    public static Resume downloadResume() {
        return null;
    }

    public static Resume updateResume() {
        return null;
    }

}
