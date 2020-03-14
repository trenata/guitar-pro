package com.guitar.guitarpro;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ScalesAdapter extends RecyclerView.Adapter<ScalesAdapter.ScalesViewHolder> {


    public interface OnItemSelectedListener {

        void onItemSelected(String item);
    }

    private final OnItemSelectedListener listener;
    private List<String> mValues;

    ScalesAdapter(@NonNull ScalesFragment listener) {
        this.listener = (OnItemSelectedListener) listener;
        mValues = new ArrayList<>();
    }

    @NonNull
    @Override
    public ScalesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ScalesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ScalesViewHolder viewHolder, int position) {
        viewHolder.bind(mValues.get(position));
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    void setScales(List<String> mValues) {
        this.mValues = mValues;
        notifyDataSetChanged();
    }

    class ScalesViewHolder extends RecyclerView.ViewHolder {

        private CheckedTextView mKeyName;

        ScalesViewHolder(View itemView) {
            super(itemView);
            mKeyName = itemView.findViewById(R.id.chord_text);
            mKeyName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final int adapterPosition = getAdapterPosition();
                    if (adapterPosition != RecyclerView.NO_POSITION) {
                        listener.onItemSelected(mValues.get(adapterPosition));
                    }
                }
            });
        }

        void bind(String chord) {
            mKeyName.setText(chord);
            //mKeyName.setChecked(chord.isSelected());
        }
    }
}