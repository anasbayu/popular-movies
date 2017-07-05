package bayu.anas.com.popularmovie.modules.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import bayu.anas.com.popularmovie.R;
import bayu.anas.com.popularmovie.model.Movie;

public class DetailActivity extends AppCompatActivity {

    private TextView txtTitle;
    private TextView txtRating;
    private TextView txtSynopsys;
    private TextView txtReleaseDate;
    private ImageView imgPoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent i = getIntent();
        if(i != null && i.hasExtra("data")){
            Movie data = i.getExtras().getParcelable("data");
            initView();
            setData(data);
        }
    }


    private void initView(){
        txtTitle = (TextView) findViewById(R.id.txt_title);
        txtRating = (TextView) findViewById(R.id.txt_rating);
        txtSynopsys = (TextView) findViewById(R.id.txt_synopsis);
        txtReleaseDate = (TextView) findViewById(R.id.txt_date);
        imgPoster = (ImageView) findViewById(R.id.img_poster);
    }

    private void setData(Movie data){
        if(data != null){
            String imgBasePath = getResources().getString(R.string.img_base_path);

            txtTitle.setText(data.getTitle());
            txtRating.setText("Rating: " + data.getVoiteAverage());
            txtSynopsys.setText(data.getOverview());
            txtReleaseDate.setText("Release Date: " + data.getReleaseDate());
            Picasso.with(this).load(imgBasePath + data.getPosterPath()).into(imgPoster);
        }else{
            Toast.makeText(this, "Cannot load data", Toast.LENGTH_SHORT).show();
        }
    }
}
