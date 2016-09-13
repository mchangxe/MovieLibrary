package CS126;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

public class movie {

    private String poster_path;
    private Boolean adult;
    private String overview;
    private String release_date;
    private int[] genre_ids;
    private String id;
    private String original_title;
    private String original_language;
    private String title;
    private String backdrop_path;
    private double popularity;
    private int vote_count;
    private Boolean video;
    private double vote_average;

    public String getPoster_path(){
            return poster_path;
        }
    public Boolean getAdult(){
            return adult;
        }
    public String getOverview(){
            return overview;
        }
    public String getRelease_date(){
            return release_date;
        }
    public int[] getGenre_ids(){
            return genre_ids;
        }
    public String getId(){
            return id;
        }
    public String getOriginal_title(){
            return original_title;
        }
    public String getOriginal_language(){
            return original_language;
        }
    public String getTitle(){
            return title;
        }
    public String getBackdrop_path(){
            return backdrop_path;
        }
    public double getPopularity(){
            return popularity;
        }
    public int getVote_count(){
            return vote_count;
        }
    public Boolean getVideo(){
            return video;
        }
    public double getVote_average(){
            return vote_average;
        }

    public class movieCollection {

        private int page;
        private movie[] results;
        private int total_results;
        private int total_pages;

        public int getPage() { return page;}
        public movie[] getResults(){
            return results;
        }
        public int getTotal_results(){
            return total_results;
        }
        public int getTotal_pages(){
            return total_pages;
        }

    }

    public static movieCollection requestMovies(int pageNumber) throws Exception{

        assert (pageNumber < 0);

        URL url = new URL("https://api.themoviedb.org/3/movie/popular?api_key=21e3d0475313167452c6fa005259b480&page=" + pageNumber);
        InputStream inputStream = url.openStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
        JsonReader jsonReader = new JsonReader(inputStreamReader);
        Gson gson = new Gson();
        movieCollection movieOfSinglePage= gson.fromJson(jsonReader, movieCollection.class);

        Thread.sleep(500);

        return movieOfSinglePage;

    }

    public static String printAll(movie[] movies){

        for (int x=0; x< movies.length; x++)
        {
            return movies[x].title;
        }
        return null;
    }

    public static String printAllWithGenre(movie[] movies, int genreId){

        String output = "";

        for (int x=0; x< movies.length; x++)
        {
            movie currentMovie = movies[x];
            for (int y=0; y<currentMovie.genre_ids.length-1; y++)
            {
                if (currentMovie.genre_ids[y] == genreId)
                {
                    output = output + "\n" + currentMovie.getTitle();
                }
            }
        }

        return output;

    }

    public static String printAllWithAverage(movie[] movies, double minVoteAverage)
    {
        String output = "";

        for (int x=0; x<movies.length; x++){
            movie currentMovie = movies[x];
            double currentVoteAverage = currentMovie.getVote_average();
            if (currentVoteAverage > minVoteAverage)
            {
                output = output + "\n" + currentMovie.getTitle();
            }
        }

        return output;
    }

    public static String printAllWithPopularity(movie[] movies, double minPopularity)
    {
        String output = "";

        for (int x=0; x<movies.length; x++){
            movie currentMovie = movies[x];
            double currentPopularity = currentMovie.getPopularity();
            if (currentPopularity > minPopularity)
            {
                output = output + "\n" + currentMovie.getTitle();
            }
        }

        return output;
    }

}
