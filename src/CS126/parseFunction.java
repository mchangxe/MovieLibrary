package CS126;

import java.io.*;
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class parseFunction {

    public List<movieData> parseFromJson()throws Exception {

        Gson gson = new Gson();
        // 1. JSON to Java object, read it from a file.
        List<movieData> movieList = new ArrayList<movieData>();
        movieList = gson.fromJson(new FileReader("CS126/apiData.json"), new TypeToken<List<movieData>>(){}.getType());
        return movieList;

    }

    public void printAll(List<movieData> movies){

        for (int x=0; x< movies.size(); x++)
        {
            System.out.println(movies.get(x).title);
        }

    }

    public void printAllWithGenre(List<movieData> movies, int genreId){

        for (int x=0; x< movies.size(); x++)
        {
            movieData currentMovie = movies.get(x);
            for (int y=0; y<currentMovie.genre_ids.length-1; y++)
            {
                if (currentMovie.genre_ids[y] == genreId)
                {
                    System.out.println(currentMovie.getTitle());
                }
            }
        }

    }

    public void printAllWithAverage(List<movieData> movies, double minVoteAverage)
    {

        for (int x=0; x<movies.size(); x++){
            movieData currentMovie = movies.get(x);
            double currentVoteAverage = currentMovie.getVote_average();
            if (currentVoteAverage > minVoteAverage)
            {
                System.out.println(currentMovie.getTitle());
            }
        }
    }

    public void printAllWithPopularity(List<movieData> movies, double minPopularity)
    {

        for (int x=0; x<movies.size(); x++){
            movieData currentMovie = movies.get(x);
            double currentPopularity = currentMovie.getPopularity();
            if (currentPopularity > minPopularity)
            {
                System.out.println(currentMovie.getTitle());
            }
        }
    }



    public class movieData {
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
    }

}
