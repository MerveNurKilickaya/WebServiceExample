package com.example.acer.gecis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.acer.gecis.Models.Result;
import com.example.acer.gecis.RestApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main2Activity extends AppCompatActivity {
    String ıd,postıd;
    TextView postText,idText,nameText,emailText,bodyText;
    List<Result> liste;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tanimla();
        al();
        istek();
    }
    public void tanimla(){
        postText=findViewById(R.id.postId2);
        idText=findViewById(R.id.Id2);
        nameText=findViewById(R.id.Name2);
        emailText=findViewById(R.id.Email2);
        bodyText=findViewById(R.id.Body2);
    }
    public void al(){
        Bundle bundle=getIntent().getExtras();
        ıd=bundle.getString("id");
        postıd=bundle.getString("post_id");
    }
    public void atama(List<Result> list){
        idText.setText(""+list.get(0).getId());
        postText.setText(""+list.get(0).getPostId());
        nameText.setText(list.get(0).getName());
        emailText.setText(list.get(0).getEmail());
        bodyText.setText(list.get(0).getBody());
    }
    public void istek(){
        liste=new ArrayList<>();
        Call<List<Result>> call= ManagerAll.getInstance().managerGetResult(postıd,ıd);
        call.enqueue(new Callback<List<Result>>() {
            @Override
            public void onResponse(Call<List<Result>> call, Response<List<Result>> response) {
                if(response.isSuccessful()){
                    liste=response.body();
                    atama(liste);
                }
            }
            @Override
            public void onFailure(Call<List<Result>> call, Throwable t) {
            }
        });
    }
}
