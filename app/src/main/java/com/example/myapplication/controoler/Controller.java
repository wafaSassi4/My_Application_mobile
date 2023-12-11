package com.example.myapplication.controoler;

import com.example.myapplication.model.Patient;


public class Controller {

    public static Patient patient;
    private static Controller instance;
    public void createPatient(double vm,int age, boolean isFast){
        patient=new Patient(vm,age,isFast);
    }
    private Controller(){
        super();
    }
    public String getResponse(){
        return patient.getConsultation();
    }
    public static Controller getInstance(){
        if(Controller.instance==null){
            return instance=new Controller();
        }else {
            return instance;
        }
    }
}

