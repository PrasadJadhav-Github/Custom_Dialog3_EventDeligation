package com.example.custom_dialog3eventdeligation;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ImagePickerDialog extends Dialog {

    private LinearLayout imagesContainer;
    private TextView txtTitle;

    public interface OnImageSelectedListener{
        void  onImageSelect(ImagePickerDialog imagePickerDialog,int imageId);
    }
    private  OnImageSelectedListener onImageSelectedListener=null;

    public  void  setOnImageSelectedListener(OnImageSelectedListener onImageSelectedListener){
        this.onImageSelectedListener=onImageSelectedListener;
    }

    public  ImagePickerDialog(Context context,int[]imageIds,String title){
        super(context);
        setContentView(R.layout.lmage_picker_dialog);
        imagesContainer=findViewById(R.id.imagesContainer);
        txtTitle=findViewById(R.id.txtTitle);
        txtTitle.setText(title);

        for (int imageId : imageIds){
            ImageView img = new ImageView(context);
            img.setImageResource(imageId);
            img.setLayoutParams(
                    new ViewGroup.LayoutParams(200,200)
            );
            img.setOnClickListener(
                    new View.OnClickListener(){
                        @Override
                        public void onClick(View view) {
                            if (onImageSelectedListener !=null){
                                onImageSelectedListener.onImageSelect(
                                        ImagePickerDialog.this,
                                        imageId
                                );
                            }
                        }
                    }
            );
            imagesContainer.addView(img);
        }
    }
}
