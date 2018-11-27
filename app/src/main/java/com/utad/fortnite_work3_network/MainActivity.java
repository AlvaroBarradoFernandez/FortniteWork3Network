package com.utad.fortnite_work3_network;
import android.arch.lifecycle.ViewModelProviders;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.EditText;
import android.widget.Spinner;

import com.utad.fortnite_work3_network.Fortnite.RankFortnite;
import com.utad.fortnite_work3_network.Fortnite.ViewModelFortnite;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText nickname_fornite;
    private Spinner spinner;
    private MyAdapter adapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private FloatingActionButton buttonGo;
    private ViewModelFortnite viewModelFortnite;
    private String platformGame;
    private String epic_nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nickname_fornite = findViewById(R.id.nickname_fornite);
        spinner = findViewById(R.id.spinner);
        buttonGo = findViewById(R.id.buttonGo);

        changeData("","");

        onclick();

    }

    private void changeData(String platformGame,String epic_nickname){
        viewModelFortnite = ViewModelProviders.of(this).get(ViewModelFortnite.class);
        viewModelFortnite.fortniteData.observe(this, stadisticObjectData -> {
            if(stadisticObjectData!=null){
                Log.d("ServicioFornite","Cambios: "+stadisticObjectData);
                generateForniteList(stadisticObjectData);
            }
        });
        viewModelFortnite.getData(platformGame, epic_nickname);
    }

    private void generateForniteList(List<RankFortnite> listFornite) {
        recyclerView = findViewById(R.id.recycleview_fornite);
        adapter = new MyAdapter(listFornite);
        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void onclick(){
        buttonGo.setOnClickListener(v -> {
            platformGame = spinner.getSelectedItem().toString();
            epic_nickname = nickname_fornite.getText().toString();
            viewModelFortnite.getData(platformGame, epic_nickname);

        });

    }
}
