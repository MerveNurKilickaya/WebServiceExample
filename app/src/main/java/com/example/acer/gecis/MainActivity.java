package com.example.acer.gecis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.acer.gecis.Adapters.BilgiAdapter;
import com.example.acer.gecis.Models.Bilgi;
import com.example.acer.gecis.RestApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    BilgiAdapter adp;
    List<Bilgi> list;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimla();
        istek();
    }
    public void tanimla(){
        listView=findViewById(R.id.list_item);
    }
    public void istek(){
        list=new ArrayList<>();
        Call<List<Bilgi>> call= ManagerAll.getInstance().getirCall();
        call.enqueue(new Callback<List<Bilgi>>() {
            @Override
            public void onResponse(Call<List<Bilgi>> call, Response<List<Bilgi>> response) {
                if(response.isSuccessful()){
                    list=response.body();
                    adp=new BilgiAdapter(list,getApplicationContext(),MainActivity.this);
                    listView.setAdapter(adp);
                }

            }

            @Override
            public void onFailure(Call<List<Bilgi>> call, Throwable t) {

            }
        });
    }
}
