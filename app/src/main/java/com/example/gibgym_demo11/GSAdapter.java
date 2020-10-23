package com.example.gibgym_demo11;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;


public class GSAdapter extends RecyclerView.Adapter<GSAdapter.MyViewHolder> {

    String data[];
    int images[];
    Context context;

    public GSAdapter(Context ct, String things[], int img[]){
        context = ct;
        data = things;
        images = img;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.general_settings_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView.setText(data[position]);
        holder.imageView.setImageResource(R.drawable.backbutton);

        String arr[]=context.getResources().getStringArray(R.array.glsetarr);

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(v);
                if(data[position].equals(arr[0])){
                    navController.navigate(R.id.action_generalSettingsFragment_to_accountSettingsFragment);
                }else if(data[position].equals(arr[1])){
                    System.out.println("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        ConstraintLayout constraintLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textView_gsrFrag_settingnames);
            imageView = itemView.findViewById(R.id.imageView_gsrFrag_igview);
            constraintLayout = itemView.findViewById(R.id.gstFrag_gsrLayout);
        }
    }
}
