package bayu.anas.com.popularmovie.modules.home;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import bayu.anas.com.popularmovie.R;
import bayu.anas.com.popularmovie.adapter.MovieAdapter;

public class MainActivity extends AppCompatActivity implements MainView{

    private ProgressDialog mDialog;
    private RecyclerView rv;
    private MovieAdapter moviewAdapter;
    private MainPresenter mPresenter;
    private Spinner spinner;
    private boolean isFirst = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initPresenter();
        initView();
        initListener();
    }

    private void initView(){
        mDialog = new ProgressDialog(this);
        mDialog.setCancelable(false);
        rv = (RecyclerView) findViewById(R.id.rv_movie);
        moviewAdapter = new MovieAdapter(MainActivity.this);
        spinner = (Spinner) findViewById(R.id.spinner);

        GridLayoutManager llm = new GridLayoutManager(getApplicationContext(), 2);
        rv.setLayoutManager(llm);
        rv.setAdapter(moviewAdapter);

        populateData();
    }

    private void initPresenter(){
        mPresenter = new MainPresenter(this, getResources().getString(R.string.base_url));
    }

    private void initListener(){
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(!isFirst){
                    if(spinner.getSelectedItemPosition() == 0){
                        mPresenter.getMovie(getResources().getString(R.string.api_key), moviewAdapter,
                                getResources().getString(R.string.api_most_popular));
                    }else{
                        mPresenter.getMovie(getResources().getString(R.string.api_key), moviewAdapter,
                                getResources().getString(R.string.api_top_rated));
                    }
                }else{
                    isFirst = false;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void populateData(){
        // Populate spinner.
        List<String> spinnerArray =  new ArrayList<String>();
        spinnerArray.add(getResources().getString(R.string.popular));
        spinnerArray.add(getResources().getString(R.string.top_rated));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // Populate feed (RV).
        mPresenter.getMovie(getResources().getString(R.string.api_key), moviewAdapter,
                getResources().getString(R.string.api_most_popular));
    }


    @Override
    public void onProgress() {
        mDialog.setMessage("Loading...");
        mDialog.show();
    }

    @Override
    public void onFinished() {
        mDialog.dismiss();
    }
}
