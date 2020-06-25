package com.kewo.huda;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class JobsAdapter extends RecyclerView.Adapter<JobsAdapter.UserAdapterVH> {
    private List<JobResponse> userResponseList;
    private Context context;
    private ClickedItem clickedItem;

    public JobsAdapter(ClickedItem clickedItem) {
        this.clickedItem = clickedItem;
    }
    public void setData(List<JobResponse> userResponseList){
        this.userResponseList = userResponseList;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public UserAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new JobsAdapter.UserAdapterVH(LayoutInflater.from(context).inflate(R.layout.row_jobs,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapterVH holder, int position) {
        JobResponse userResponse = userResponseList.get(position);
        String desg = userResponse.getDesignation();
        String criteria = userResponse.getEligibility_criteria();
        String exp = userResponse.getExperience();


        holder.designation.setText(desg);
        holder.criteria.setText(criteria);
        holder.experience.setText(exp);



        holder.designation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickedItem.ClickedUser(userResponse);
            }
        });
        holder.criteria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickedItem.ClickedUser(userResponse);
            }
        });
        holder.experience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickedItem.ClickedUser(userResponse);
            }
        });
        holder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickedItem.ClickedUser(userResponse);
            }
        });

    }
    public interface ClickedItem{
        public void ClickedUser(JobResponse userResponse);
    }

    @Override
    public int getItemCount() {
        return userResponseList.size();
    }

    public class UserAdapterVH extends RecyclerView.ViewHolder {
        TextView designation,criteria,experience ;
        LinearLayout ll;

        public UserAdapterVH(@NonNull View itemView) {
            super(itemView);
            designation = itemView.findViewById(R.id.designation);

            criteria = itemView.findViewById(R.id.eligibility_criteria);
            experience = itemView.findViewById(R.id.experience);
            ll = itemView.findViewById(R.id.ll);


        }
    }
}

