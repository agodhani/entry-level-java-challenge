package com.challenge.api.model;

import java.time.Instant;
import java.util.UUID;

/**
 * Employee Instance Implementation
 */
public class EmployeeClass implements Employee {
    private UUID uuid;
    private String firstName;
    private String lastName;
    private String fullName;
    private Integer salary;
    private Integer age;
    private String jobTitle;
    private String email;
    private Instant hireDate;
    private Instant terminateDate;

    // constructor
    public EmployeeClass() {}

    @Override
    public UUID getUuid() {
        return uuid;
    }

    /**
     * Set by either the Service or Data layer.
     * @param uuid required non-null
     */
    @Override
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public Integer getSalary() {
        return salary;
    }

    @Override
    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public Integer getAge() {
        return age;
    }

    @Override
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String getJobTitle() {
        return jobTitle;
    }

    @Override
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    public Instant getContractHireDate() {
        return hireDate;
    }

    public void setContractHireDate(Instant hireDate) {
        this.hireDate = hireDate;
    }

    /**
     * Nullable.
     * @return null, if Employee has not been terminated.
     */
    public Instant getContractTerminationDate() {
        return terminateDate;
    }

    public void setContractTerminationDate(Instant terminateDate) {
        this.terminateDate = terminateDate;
    }
}
