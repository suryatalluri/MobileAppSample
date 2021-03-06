/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/

package com.hrdb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import javax.persistence.PrimaryKeyJoinColumn;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import java.util.Arrays;

import javax.persistence.Transient;
import javax.persistence.CascadeType;
import javax.persistence.UniqueConstraint;




/**
 * Employee generated by hbm2java
 */
@Entity
@Table(name="EMPLOYEE"
    ,schema="PUBLIC"
)
public class Employee  implements java.io.Serializable
 {


private Integer eid;
private String firstname;
private String lastname;
private String street;
private String city;
private String state;
private String zip;
private Date birthdate;
private String picurl;
private String twitterid;
private Integer tenantid;
private Department department;
private Employee employeeByManagerid;
private Set<Employee> employeesForManagerid = new HashSet<Employee>(0);
private Set<Vacation> vacations = new HashSet<Vacation>(0);

    public Employee() {
    }



     @Id @GeneratedValue(strategy=IDENTITY)

    

    @Column(name="EID", nullable=false)
    public Integer getEid() {
        return this.eid;
    }
    
    public void setEid(Integer eid) {
        this.eid = eid;
    }

    

    @Column(name="FIRSTNAME")
    public String getFirstname() {
        return this.firstname;
    }
    
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    

    @Column(name="LASTNAME")
    public String getLastname() {
        return this.lastname;
    }
    
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    

    @Column(name="STREET")
    public String getStreet() {
        return this.street;
    }
    
    public void setStreet(String street) {
        this.street = street;
    }

    

    @Column(name="CITY")
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }

    

    @Column(name="STATE", length=2)
    public String getState() {
        return this.state;
    }
    
    public void setState(String state) {
        this.state = state;
    }

    

    @Column(name="ZIP")
    public String getZip() {
        return this.zip;
    }
    
    public void setZip(String zip) {
        this.zip = zip;
    }

    @Temporal(TemporalType.DATE)

    @Column(name="BIRTHDATE", length=10)
    public Date getBirthdate() {
        return this.birthdate;
    }
    
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    

    @Column(name="PICURL")
    public String getPicurl() {
        return this.picurl;
    }
    
    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    

    @Column(name="TWITTERID", length=40)
    public String getTwitterid() {
        return this.twitterid;
    }
    
    public void setTwitterid(String twitterid) {
        this.twitterid = twitterid;
    }

    

    @Column(name="TENANTID")
    public Integer getTenantid() {
        return this.tenantid;
    }
    
    public void setTenantid(Integer tenantid) {
        this.tenantid = tenantid;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="DEPTID", nullable=false)
    public Department getDepartment() {
        return this.department;
    }
    
    public void setDepartment(Department department) {
        this.department = department;
    }

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="MANAGERID")
    public Employee getEmployeeByManagerid() {
        return this.employeeByManagerid;
    }
    
    public void setEmployeeByManagerid(Employee employeeByManagerid) {
        this.employeeByManagerid = employeeByManagerid;
    }

@OneToMany(fetch=FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy="employeeByManagerid")
    public Set<Employee> getEmployeesForManagerid() {
        return this.employeesForManagerid;
    }
    
    public void setEmployeesForManagerid(Set<Employee> employeesForManagerid) {
        this.employeesForManagerid = employeesForManagerid;
    }

@OneToMany(fetch=FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy="employee")
    public Set<Vacation> getVacations() {
        return this.vacations;
    }
    
    public void setVacations(Set<Vacation> vacations) {
        this.vacations = vacations;
    }



public boolean equals(Object o) {
         if (this == o)
         return true;
		 if ( (o == null ) )
		 return false;
		 if ( !(o instanceof Employee) )
		 return false;

		 Employee that = ( Employee ) o;

		 return ( (this.getEid()==that.getEid()) || ( this.getEid()!=null && that.getEid()!=null && this.getEid().equals(that.getEid()) ) );

   }

   public int hashCode() {
         int result = 17;

         result = 37 * result + ( getEid() == null ? 0 : this.getEid().hashCode() );

         return result;
     }


}

