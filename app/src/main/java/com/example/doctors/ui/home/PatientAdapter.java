package com.example.doctors.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doctors.databinding.ItemLayoutBinding;
import com.example.doctors.databinding.ItemPatientBinding;
import com.example.doctors.models.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientAdapter extends RecyclerView.Adapter<PatientAdapter.ViewHolder> {
    private List<Patient> patients = new ArrayList<>();

    public void setList(List<Patient> patients){
        this.patients = patients;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PatientAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPatientBinding itemPatientBinding = ItemPatientBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        ViewHolder viewHolder = new ViewHolder(itemPatientBinding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Patient patient = patients.get(position);
        holder.binding.fName.setText("Имя: " + patient.getF_name());
        holder.binding.lName.setText("Фамилия: " + patient.getL_name());
        holder.binding.phone.setText("Номре телефона: " + patient.getPhone());
    }

    @Override
    public int getItemCount() {
        return patients.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemPatientBinding binding;

        public ViewHolder(@NonNull ItemPatientBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }

    }
}
