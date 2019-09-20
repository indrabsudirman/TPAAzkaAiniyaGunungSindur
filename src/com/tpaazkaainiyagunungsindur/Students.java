/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tpaazkaainiyagunungsindur;

/**
 *
 * @author indrasudirman
 */
public class Students {
    
    private String noInduk;
    private String namaSiswa;
    private String courseName;
    private String courseFee;
    private String paymentAmount;
    private String paymentStatus;
    
    public Students(String noInduk, String namaSiswa, String courseName, String courseFee, String paymentAmount, String paymentStatus) {
        this.noInduk = noInduk;
        this.namaSiswa = namaSiswa;
        this.courseName = courseName;
        this.courseFee = courseFee;
        this.paymentAmount = paymentAmount;
        this.paymentStatus = paymentStatus;
    }

    

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(String courseFee) {
        this.courseFee = courseFee;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    

    public String getNoInduk() {
        return noInduk;
    }

    public void setNoInduk(String noInduk) {
        this.noInduk = noInduk;
    }

    public String getNamaSiswa() {
        return namaSiswa;
    }

    public void setNamaSiswa(String namaSiswa) {
        this.namaSiswa = namaSiswa;
    } 
    
    public String getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(String paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
    
}
