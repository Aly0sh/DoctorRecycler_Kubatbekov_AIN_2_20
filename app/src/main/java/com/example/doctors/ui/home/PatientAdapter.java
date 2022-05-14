package com.example.doctors.ui.home;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
        holder.binding.phone.setText("Номер телефона: " + patient.getPhone());
        holder.binding.patronymic.setText("Отчество: " + patient.getPatronymic());
        holder.binding.item.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog alertDialog = new AlertDialog.Builder(holder.binding.getRoot().getContext()).create();
                alertDialog.setTitle("Ваша очередь");
                alertDialog.setMessage("" + (holder.getAdapterPosition() + 1));
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
                return true;
            }
        });
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
