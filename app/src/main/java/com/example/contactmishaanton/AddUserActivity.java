package com.example.contactmishaanton;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class AddUserActivity extends AppCompatActivity {
  public static Bitmap selectedImage;
  private static final int PICK_IMAGE = 01;
  ImageView imageView;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.add_item);

    Init();
  }

  private void Init() {
    imageView = findViewById(R.id.imageAvatar);
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if(requestCode == PICK_IMAGE){
      try{
        Uri uri = data.getData();
        InputStream imageStream = getContentResolver().openInputStream(uri);
        selectedImage = BitmapFactory.decodeStream(imageStream);
        imageView.setImageBitmap(selectedImage);
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
    }
  }

  public void PickPhoto(View view){
    Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
    photoPickerIntent.setType("image/");
    startActivityForResult(photoPickerIntent, PICK_IMAGE);
  }

  public void AddNewItem(View view){
    Intent intent = new Intent( AddUserActivity.this,MainActivity.class);
    startActivity(intent);
  }
}