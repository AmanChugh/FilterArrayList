package ammyaman.testing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<FilterModel> modelList = new ArrayList<>();
    List<FilterModel> tempList = new ArrayList<>();

    public static final String TYPE = "type";
    public static final String CATEGORY = "category";
    public static final String COUNTRY = "country";
    public static final String STATE = "state";
    public static final String CITY = "city";
    public static final String STATUS = "status";
    private static final int MY_FILTER_REQUEST = 201;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initModels();

        findViewById(R.id.btn_filter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FilterActivity.class);
                startActivityForResult(intent,MY_FILTER_REQUEST);
            }
        });
    }

    private void initModels() {

        modelList.add(new FilterModel("cloth", "shop", "India", "Punjab", "Chandigarh", "active"));
        modelList.add(new FilterModel("Shoes", "Mall", "China", "BlaBl", "Kapurthala", "deactive"));
        modelList.add(new FilterModel("cloth", "Mall", "India", "BlaBl", "Dehradun", "active"));
        modelList.add(new FilterModel("Shoes", "shop", "USA", "Punjab", "Chandigarh", "deactive"));
        modelList.add(new FilterModel("Laptop", "shop", "India", "Punjab", "Kapurthala", "active"));
        modelList.add(new FilterModel("Laptop", "Mall", "USA", "BlaBl", "Dehradun", "deactive"));
        modelList.add(new FilterModel("BlaBla", "Mall", "China", "Punjab", "Chandigarh", "active"));
        modelList.add(new FilterModel("BlaBla", "shop", "India", "BlaBl", "Dehradun", "active"));
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case (MY_FILTER_REQUEST): {
                if (resultCode == Activity.RESULT_OK) {

                    String type = data.getStringExtra(TYPE);
                    String category = data.getStringExtra(CATEGORY);
                    String country = data.getStringExtra(COUNTRY);
                    String state = data.getStringExtra(STATE);
                    String city = data.getStringExtra(CITY);
                    String status = data.getStringExtra(STATUS);

                    tempList.clear();
                    Log.e("All List", modelList.toString());
                    for (int i = 0; i < modelList.size(); i++) {
                        FilterModel filterModel = modelList.get(i);
                        if ((filterModel.getType().equalsIgnoreCase(type) || type.isEmpty())
                                && (filterModel.getCat().equalsIgnoreCase(category) || category.isEmpty())
                                && (filterModel.getCountry().equalsIgnoreCase(country) || country.isEmpty())
                                && (filterModel.getState().equalsIgnoreCase(state) || state.isEmpty())
                                && (filterModel.getCity().equalsIgnoreCase(city) || city.isEmpty())
                                && (filterModel.getStatus().equalsIgnoreCase(status) || status.isEmpty())) {

                            tempList.add(filterModel);
                        }

                    }

                    Log.e("Filtered List", tempList.toString());
                }
                break;
            }
        }
    }


}
