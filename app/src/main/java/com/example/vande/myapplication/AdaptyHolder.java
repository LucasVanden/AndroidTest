package com.example.vande.myapplication;
import android.content.Intent;
import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import com.example.vande.myapplication.MainActivity;

import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;


public class AdaptyHolder extends RecyclerView.Adapter<AdaptyHolder.señorViewHolder> {
//    public static final String EXTRA_MESSAGE_Pickachu = "com.example.myfirsy_intent";
//
//    public void slatarOtraPantallaconTab(View view,String clave){
//        Intent intent = new Intent(view.getContext(),Second.class);
//
//        intent.putExtra(EXTRA_MESSAGE_Pickachu,clave);
//        startActivity(intent);
//    }

    //Lista de datos
    private List<Item> nItem;
    //Adapter Constructor: le paso datos y los guarda en esta clase
    public AdaptyHolder(List<Item> nItem) {
        this.nItem = nItem;
    }

    @NonNull
    @Override
    public AdaptyHolder.señorViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        //Contexto??
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.layoutdlrecycleview, viewGroup, false);

        // Return a new holder instance
        señorViewHolder viewHolder = new señorViewHolder(contactView);
        return viewHolder;

    }
    @Override
    public void onBindViewHolder(@NonNull señorViewHolder señorViewHolder, int i) {
        Item contact = nItem.get(i);

        // Set item views based on your views and data model
        TextView textView = señorViewHolder.text;
        textView.setText(contact.getnName());
        Button button = señorViewHolder.boton;
        button.setText(contact.ismOnline() ? "Message" : "Offline");
        button.setEnabled(contact.ismOnline());
    }
    @Override
    public int getItemCount() {
        return nItem.size();
    }

    //Holder
    public class señorViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView text;
        public Button boton;



        public señorViewHolder(@NonNull View itemView) {
            super(itemView);
            this.text = (TextView) itemView.findViewById(R.id.contact_name);
            this.boton = (Button) itemView.findViewById(R.id.message_button);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
          String m= (String) this.text.getText().toString();

//            Intent intent = new Intent(v.getContext(),Second.class);
//            intent.putExtra(EXTRA_MENSAGE_PANTALLA,m);
//            startActivity(intent);
//            slatarOtraPantallaconTab(v,m);




            Toast.makeText(v.getContext(),m,Toast.LENGTH_SHORT).show();
        }
    }
}
