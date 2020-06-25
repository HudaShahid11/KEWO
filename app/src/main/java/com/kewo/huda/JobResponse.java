package com.kewo.huda;

import java.io.Serializable;

public class JobResponse implements Serializable {

    private int id;
    private String industry, department, company, designation, eligibility_criteria, experience, other_requirements, location, age, shift, responsibilities, gender;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEligibility_criteria() {
        return eligibility_criteria;
    }

    public void setEligibility_criteria(String eligibility_criteria) {
        this.eligibility_criteria = eligibility_criteria;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getOther_requirements() {
        return other_requirements;
    }

    public void setOther_requirements(String other_requirements) {
        this.other_requirements = other_requirements;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "JobResponse{" +
                "id=" + id +
                ", industry='" + industry + '\'' +
                ", department='" + department + '\'' +
                ", company='" + company + '\'' +
                ", designation='" + designation + '\'' +
                ", eligibility_criteria='" + eligibility_criteria + '\'' +
                ", experience='" + experience + '\'' +
                ", other_requirements='" + other_requirements + '\'' +
                ", location='" + location + '\'' +
                ", age='" + age + '\'' +
                ", shift='" + shift + '\'' +
                ", responsibilities='" + responsibilities + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
