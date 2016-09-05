/**
 * Created by Museum2015 on 4/9/2016.
 */

import java.io.InputStreamReader;
import java.net.URL;

import com.google.gson.Gson;

public class parseFunction {

    public static void main(String args) throws Exception {

        URL url = new URL("https://api.themoviedb.org/3/movie/popular?api_key=21e3d0475313167452c6fa005259b480");
        InputStreamReader reader = new InputStreamReader(url.openStream());
        movieData movies = new Gson().fromJson(reader, movieData.class);

        System.out.println(movies.title);

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
