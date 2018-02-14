package ammyaman.testing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class FilterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        final EditText type = (EditText) findViewById(R.id.et_type);
        final EditText category = (EditText) findViewById(R.id.et_cat);
        final EditText country = (EditText) findViewById(R.id.et_country);
        final EditText state = (EditText) findViewById(R.id.et_state);
        final EditText city = (EditText) findViewById(R.id.et_city);
        final EditText status = (EditText) findViewById(R.id.et_status);


        findViewById(R.id.btn_filter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String typeString = type.getText().toString().trim();
                String categoryString = category.getText().toString().trim();
                String countryString = country.getText().toString().trim();
                String stateString = state.getText().toString().trim();
                String cityString = city.getText().toString().trim();
                String statusString = status.getText().toString().trim();

                Intent intent = new Intent();
                intent.putExtra(MainActivity.TYPE,typeString);
                intent.putExtra(MainActivity.CATEGORY,categoryString);
                intent.putExtra(MainActivity.COUNTRY,countryString);
                intent.putExtra(MainActivity.STATE,stateString);
                intent.putExtra(MainActivity.CITY,cityString);
                intent.putExtra(MainActivity.STATUS,statusString);

                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}
