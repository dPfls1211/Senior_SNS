package com.example.senior_sns_project;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;

public class Write extends AppCompatActivity {
    private ImageView writeImage;
    private AlertDialog dialog;
    private final int GET_GALLERY_IMAGE = 200;
    private ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        final EditText writeTitle = (EditText) findViewById(R.id.writeTitle);
        final EditText write = (EditText) findViewById(R.id.write);
        final Button registerWriteButton = (Button) findViewById(R.id.registerWriteButton);

        registerWriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String userwriteTitle = writeTitle.getText().toString();
                String userwrite  = write.getText().toString();
                AlertDialog.Builder builder = new AlertDialog.Builder(Write.this);
                dialog = builder.setMessage("글을 등록하였습니다.").setPositiveButton("확인", null).create();
                dialog.show();
                Intent intent = new Intent(Write.this, MainActivity3.class);
                intent.putExtra("userwriteTitle", userwriteTitle);
                intent.putExtra("userwrite", userwrite);
                Write.this.startActivity(intent);
                finish();
            }
        });

        imageview = (ImageView)findViewById(R.id.writeImage);
        imageview.setImageResource(R.drawable.ic_image) ;

        imageview.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                imageview.setImageBitmap(null);
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent. setDataAndType(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intent, GET_GALLERY_IMAGE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GET_GALLERY_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri selectedImageUri = data.getData();
            imageview.setImageURI(selectedImageUri);

        }

    }

    @Override
    protected void onStop(){
        super.onStop();
        if(dialog != null){
            dialog.dismiss();
            dialog = null;
        }
    }
    /*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                try {
                    InputStream in = getContentResolver().openInputStream(data.getData());

                    Bitmap img = BitmapFactory.decodeStream(in);
                    in.close();

                    writeImage.setImageBitmap(img);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "사진 선택 취소", Toast.LENGTH_LONG).show();
            }
        }
    }*/

}