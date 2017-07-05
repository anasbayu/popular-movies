package bayu.anas.com.popularmovie.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by AnasBayu on 04/07/2017.
 */

public class ResultResponse {
    @SerializedName("page")
    private String page;
    @SerializedName("total_results")
    private String totalResult;
    @SerializedName("total_pages")
    private String totalPages;
    @SerializedName("results")
    private List<Movie> results;

    public ResultResponse() {
    }

    public String getPage() {
        return page;
    }

    public String getTotalResult() {
        return totalResult;
    }

    public String getTotalPages() {
        return totalPages;
    }

    public List<Movie> getResults() {
        return results;
    }
}
