package com.example.myapplication.model;

public class Patient {
    private double vm;
    private  int age;
    private boolean isFast;
    private String consultation;
    public Patient(double vm,int age,boolean isFast){
        this.vm=vm;
        this.age=age;
        this.isFast=isFast;
        calculer();
    }

    public double getVm() {
        return vm;
    }

    public int getAge() {
        return age;
    }

    public boolean isFast() {
        return isFast;
    }

    public String getConsultation() {
        return consultation;
    }

    public void calculer(){
        if (isFast) {
            if (age >= 13) {
                if (vm< 5.0) {
                    consultation ="Niveau de glycémie est bas";
                } else if (vm >= 5.0 && vm <= 7.2) {
                    consultation="Niveau de glycémie est normal";
                } else {
                    consultation="Niveau de glycémie est trop élevé";
                }
            } else if (age >= 6 && age <= 12) {
                if (vm < 5.0) {
                    consultation="Niveau de glycémie est trop bas";
                } else if (vm >= 5.0 && vm <= 10.0) {
                    consultation="Niveau de glycémie est normal";
                } else {
                    consultation="Niveau de glycémie est trop élevé";
                }
            } else {
                if (vm < 5.5) {
                    consultation="Niveau de glycémie est trop bas";
                } else if (vm >= 5.5 && vm <= 10.0) {
                    consultation="Niveau de glycémie est normal";
                } else {
                    consultation="Niveau de glycémie est trop élevé";
                }
            }
        } else if (vm < 10.5) {
            consultation="Niveau de glycémie est normal";
        } else {
            consultation="Niveau de glycémie est élevé";
        }
    }
}
