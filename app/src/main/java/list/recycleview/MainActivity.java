package list.recycleview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import java.util.ArrayList;

import list.recycleview.adapter.GridMoboAdapter;
import list.recycleview.adapter.ListMoboAdapter;
import list.recycleview.model.Mobo;
import list.recycleview.model.MoboData;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvMobo;
    private ArrayList<Mobo> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Main Activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMobo = findViewById(R.id.rv_mobo);
        rvMobo.setHasFixedSize(true);

        list.addAll(MoboData.getListData());
        showRecyclerList();
    }

    //MAKE ACTION BAR
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    //SWITCH CASE ACTION BAR
    private void setMode(int itemId) {
        switch (itemId) {
            case R.id.profile:
                Intent intent = new Intent(this, Useract.class);
                startActivity(intent);
                break;
            case R.id.action_list:
                showRecyclerList();
                break;
            case R.id.action_grid:
                showRecyclerGrid();
                break;
        }
    }

    //SHOW RECYCLEVIEW LIST
    private void showRecyclerList() {
        rvMobo.setLayoutManager(new LinearLayoutManager(this));
        ListMoboAdapter listMoboAdapter = new ListMoboAdapter(list, this);
        rvMobo.setAdapter(listMoboAdapter);
    }

    //SHOW RECYCLEVIEW GRID
    private void showRecyclerGrid() {
        rvMobo.setLayoutManager(new GridLayoutManager(this, 2));
        GridMoboAdapter gridMoboAdapter = new GridMoboAdapter(list, this);
        rvMobo.setAdapter(gridMoboAdapter);
    }

}
