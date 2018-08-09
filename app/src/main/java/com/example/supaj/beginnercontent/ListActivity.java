package com.example.supaj.beginnercontent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ListActivity extends Activity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    String[] myDataset = {"Joe", "Bob", "Dan"};
    int[] mDataset2 = {12, 2, 124};


    //DATA SET IS DECLARED HERE

    public List<Data> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //pass list into changing



        Intent i = getIntent();
        Bundle bundle = getIntent().getExtras();

        String[] sendata;

        data = fill_with_data();

        boolean isNull = i.getStringExtra("message") == null  ? true : false;


        if (!isNull) {
            if(i.getStringExtra("message").equals("success")) {
                sendata = i.getStringArrayExtra("DataList");
                data.add(new Data(sendata[0], sendata[1], R.drawable.github, sendata[2]));
            }
        }



        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        CustomListAdapter adapter = new CustomListAdapter(data, getApplication());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new

                LinearLayoutManager(this));

        //Onitemclicked listener for list
        recyclerView.addOnItemTouchListener(new

                CustomRVItemTouchListener(this, recyclerView, new RecyclerViewItemClickListener() {
            @Override
            public void onClick(View view, int position) {

                Intent toDetail = new Intent(getApplicationContext(), DetailActivity.class);


                toDetail.putExtra("title", getData(position, "title"));
                toDetail.putExtra("detail", getData(position, "detail"));
                toDetail.putExtra("description", getData(position, "description"));


                startActivity(toDetail);

            }

            @Override
            public void onLongClick(View view, int position) {

                //Lol there's nothing

            }

        }));
    }
    // ...


    public List<Data> fill_with_data() {

        data.add(new Data("Title 1", "This is the description", R.drawable.github, "This is an example description in more detail"));
        data.add(new Data("Title 2", "This a boring description", R.drawable.github, "This is really boring descipriotnn  does that doesn't help with anything"));

        return data;

    }

    public List<Data> fill_with_data(String title, String detail, String desc) {

        data.add(new Data(title, detail, R.drawable.github, desc));

        return data;

    }

    public String getData(int position, String type) {
        switch (type) {
            case "title":
                return data.get(position).title;
            case "detail":
                return data.get(position).detail;
            case "description":
                return data.get(position).description;
            default:
                return "Did not get valid type";
        }
    }


}
/*


public class ListActivity extends AppCompatActivity {

    ListView myListView;
    String[] items, prices, descriptions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Resources res = getResources();
        myListView = (ListView) findViewById(R.id.listview);
        items = res.getStringArray(R.array.items);
        prices = res.getStringArray(R.array.prices);
        descriptions = res.getStringArray(R.array.descriptions);

        final itemAdapter itemAdapter = new itemAdapter(this, items, prices, descriptions);
        myListView.setAdapter(itemAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(ListActivity.this, "You clicked the item!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}

 */