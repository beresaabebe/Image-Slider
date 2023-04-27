package com.beckytech.imageslider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.List;

public class ImageSlider extends SliderViewAdapter<ImageSlider.MyHolder>{

    Context context;
    onImageClickListener imageClickListener;
    List<SliderModel> modelList;

    public interface onImageClickListener {
        void imageClick(SliderModel model);
    }

    public ImageSlider(Context context, List<SliderModel> modelList, onImageClickListener imageClickListener) {
        this.context = context;
        this.modelList = modelList;
        this.imageClickListener = imageClickListener;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_file, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder viewHolder, int position) {
        SliderModel model = modelList.get(position);
        viewHolder.relativeLayout.setBackgroundResource(model.getImage());
        viewHolder.textView.setText(model.getTextTitle());
        viewHolder.itemView.setOnClickListener(v -> imageClickListener.imageClick(model));
    }

    @Override
    public int getCount() {
        return modelList.size();
    }

    static class MyHolder extends SliderViewAdapter.ViewHolder {
        private final RelativeLayout relativeLayout;
        private final TextView textView;
        public MyHolder(View itemView) {
            super(itemView);
            relativeLayout = itemView.findViewById(R.id.relative);
            textView = itemView.findViewById(R.id.titleTextView);
        }
    }

}
