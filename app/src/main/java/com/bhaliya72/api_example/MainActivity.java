package com.bhaliya72.api_example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    Api_interface api_interface;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        api_interface = retrofit_class.getRetrofit().create(Api_interface.class);
        api_interface.getpost().enqueue(new Callback<List<post_pojo>>() {
            @Override
            public void onResponse(Call<List<post_pojo>> call, Response<List<post_pojo>> response) {

                if (response.body().size()>0){
                    List<post_pojo> postList = response.body();
                    Adapter adapter = new Adapter(MainActivity.this, postList);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(adapter);
                    Toast.makeText(MainActivity.this, "List not Emtay", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "List empaty", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<post_pojo>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}