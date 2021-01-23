package com.example.contactmishaanton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MainActivity extends AppCompatActivity {
  LayoutInflater inflater;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    inflater = getLayoutInflater();
    RecyclerView recyclerView = findViewById(R.id.listItem);
    recyclerView.setAdapter(new ContactAdapter());
  }

  public void AddItemUser(View view){
    Intent intent = new Intent(MainActivity.this, AddUserActivity.class);
    startActivity(intent);
  }

  private class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view = inflater.inflate(R.layout.item_user, parent, false);
      return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
      return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
      public ViewHolder(@NonNull View itemView) {
        super(itemView);
      }
    }
  }
}