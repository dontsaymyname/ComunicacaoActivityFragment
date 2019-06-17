package com.example.comunicacaofragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ComunicacaoActivityParaFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comunicacao_para_fragment);


        Button botaoVerde = findViewById(R.id.verde_button);
        botaoVerde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               inicarFragment("VERDE");

            }
        });

        Button botaoRosa = findViewById(R.id.rosa_button);
        botaoRosa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               inicarFragment("ROSA");

            }
        });
    }

    private void inicarFragment (String cor){

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        CoresFragment coresFragment = new CoresFragment();

        Bundle bundle = new Bundle();
        bundle.putString("COR", cor);

        coresFragment.setArguments(bundle);

        transaction.replace(R.id.frameLayout, coresFragment);
        transaction.commit();
    }
}
