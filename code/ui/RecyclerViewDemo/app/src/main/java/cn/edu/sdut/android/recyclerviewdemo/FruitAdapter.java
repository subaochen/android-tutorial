package cn.edu.sdut.android.recyclerviewdemo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    private List<Fruit> mFruitList;

    public FruitAdapter(List<Fruit> fruitList){
        mFruitList = fruitList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 使用竖向滚动显示的布局
        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item, parent,false);
        // 使用横向滚动显示的布局
        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item_vertical, parent,false);
        // 使用瀑布流布局
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item_waterfall, parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Fruit fruit = mFruitList.get(position);
        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getName());
        viewHolder.fruitColor.setText(fruit.getColor());

    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView fruitImage;
        TextView fruitName;
        TextView fruitColor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fruitImage = (ImageView)itemView.findViewById(R.id.fruit_image);
            fruitName = (TextView)itemView.findViewById(R.id.fruit_name);
            fruitColor = (TextView)itemView.findViewById(R.id.fruit_color);
        }
    }
}
