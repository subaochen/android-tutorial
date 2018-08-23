package cn.edu.sdut.android.customlistviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        FruitAdapter adapter = new FruitAdapter(MainActivity.this, R.layout.fruit_item,fruitList);
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }

    private void initFruits() {
        for(int i = 0; i < 30; i++){
            Fruit apple = new Fruit("Apple",R.drawable.apple,i % 2 == 0 ? "Green" : "red");
            fruitList.add(apple);
        }
    }
}
