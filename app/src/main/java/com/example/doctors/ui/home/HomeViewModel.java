package com.example.doctors.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.doctors.R;
import com.example.doctors.models.Patient;
import com.example.doctors.models.Person;

import java.util.ArrayList;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<ArrayList<Patient>> patients;
    private ArrayList<Patient> patientList;

    public void setList(ArrayList<Patient> patients) {
        patientList = patients;
        init();
    }

    public HomeViewModel() {
        patients = new MutableLiveData<>();
        init();
    }

    private void init(){
        populateList();
        patients.setValue(patientList);
    }

    private void populateList(){
        patientList = new ArrayList<>();
        Patient patient = new Patient();
        patient.setF_name("Alakem");
        patient.setL_name("Kubatbekov");
        patient.setPhone("0705667102");
        patientList.add(patient);
        patientList.add(patient);
        patientList.add(patient);
        patientList.add(patient);
        patientList.add(patient);
        patientList.add(patient);
        patientList.add(patient);
        patientList.add(patient);
        patientList.add(patient);
        patientList.add(patient);
        patientList.add(patient);
        patientList.add(patient);
        patientList.add(patient);
        patientList.add(patient);
    }

    public LiveData<ArrayList<Patient>> getMutableLiveData() {
        return patients;
    }
}