package com.rocketshield.testbitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import org.freemp.malevich.Malevich;

public class MyAdapter extends ArrayAdapter<String> {

    private final LayoutInflater inflater;
    private Malevich malevich;

    public MyAdapter(Context context) {
        super(context, 0);
        inflater = LayoutInflater.from(context);
        if (malevich == null) {
            malevich = new Malevich.Builder(context).build();
        }
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item, parent, false);
        }

        String item = getItem(position);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.image);

        malevich.load(item).imageDecodedListener(new Malevich.ImageDecodedListener() {
            @Override
            public Bitmap onImageDecoded(String data, int reqWidth, int reqHeight, Bitmap bitmap) {
                Bitmap bitmapCopy = bitmap.copy(bitmap.getConfig(), true);
                Bitmap bitmapOut = Malevich.Utils.getCircleBitmap(bitmapCopy);
                return bitmapOut;
            }
        }).into(imageView);

        return convertView;
    }
}
