package bayu.anas.com.popularmovie.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by AnasBayu on 04/07/2017.
 */

public class Movie implements Parcelable{
    @SerializedName("vote_count")
    private String voiteCount;
    @SerializedName("id")
    private String id;
    @SerializedName("video")
    private String video;
    @SerializedName("vote_average")
    private String voiteAverage;
    @SerializedName("title")
    private String title;
    @SerializedName("popularity")
    private String popularity;
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("original_language")
    private String originalLanguage;
    @SerializedName("original_title")
    private String originalTitle;
    @SerializedName("backdrop_path")
    private String backdropPath;
    @SerializedName("adult")
    private String adult;
    @SerializedName("overview")
    private String overview;
    @SerializedName("release_date")
    private String releaseDate;

    public Movie(String poster) {
        this.posterPath = poster;
    }


    public String getVoiteCount() {
        return voiteCount;
    }

    public String getId() {
        return id;
    }

    public String getVideo() {
        return video;
    }

    public String getVoiteAverage() {
        return voiteAverage;
    }

    public String getTitle() {
        return title;
    }

    public String getPopularity() {
        return popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public String getAdult() {
        return adult;
    }

    public String getOverview() {
        return overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(voiteCount);
        dest.writeString(id);
        dest.writeString(video);
        dest.writeString(voiteAverage);
        dest.writeString(title);
        dest.writeString(popularity);
        dest.writeString(posterPath);
        dest.writeString(originalLanguage);
        dest.writeString(popularity);
        dest.writeString(backdropPath);
        dest.writeString(adult);
        dest.writeString(overview);
        dest.writeString(releaseDate);
    }

    public Movie(Parcel in) {
        this.voiteCount = in.readString();
        this.id = in.readString();
        this.video = in.readString();
        this.voiteAverage = in.readString();
        this.title = in.readString();
        this.popularity = in.readString();
        this.posterPath = in.readString();
        this.originalLanguage = in.readString();
        this.popularity = in.readString();
        this.backdropPath = in.readString();
        this.adult = in.readString();
        this.overview = in.readString();
        this.releaseDate = in.readString();
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}