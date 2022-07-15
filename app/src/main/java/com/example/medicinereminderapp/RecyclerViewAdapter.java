package com.example.medicinereminderapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{
    Context context;
    List<MedicationModel> medicationModels;

    public RecyclerViewAdapter(Context context,  List<MedicationModel> medicationModels){
          this.context = context;
          this.medicationModels = medicationModels;
    }
    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.single_item,parent,false);
        return new RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {
          holder.tvMedicationName.setText(medicationModels.get( position).getMedicationName());
          holder.tvPrescription1.setText(medicationModels.get(position).getPrescription1());
          holder.tvPrescription2.setText(medicationModels.get(position).getPrescription2());

    }

    @Override
    public int getItemCount() {
        return medicationModels.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
     TextView tvMedicationName,tvPrescription1,tvPrescription2,tvMultiplySign;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvMedicationName =itemView.findViewById(R.id.textViewSingleMedicationName);
            tvPrescription1 =itemView.findViewById(R.id.textViewSinglePrediction1);
            tvPrescription2 =itemView.findViewById(R.id.textViewSinglePrediction2);
            tvMultiplySign =itemView.findViewById(R.id.textViewMultiplySign);
        }
    }
}
