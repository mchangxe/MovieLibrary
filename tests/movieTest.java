
import CS126.movie;
import static org.junit.Assert.*;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;


public class movieTest {

    URL url = new URL("https://api.themoviedb.org/3/movie/popular?api_key=21e3d0475313167452c6fa005259b480&page=1");
    InputStream inputStream = url.openStream();
    InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
    JsonReader jsonReader = new JsonReader(inputStreamReader);
    Gson gson = new Gson();

    movie.movieCollection movieOfSinglePage = gson.fromJson(jsonReader, movie.movieCollection.class);
    movie[] sampleMovieParsed = {movieOfSinglePage.getResults()[0]};

    //Testing correct cases
    public movieTest() throws IOException {
    }

    @Test
    public void printAll() throws Exception {
        assertTrue(sampleMovieParsed[0].getTitle().equals("Captain America: Civil War"));
    }

    @Test
    public void printAllWithGenre() throws Exception {
        int genreWanted = 28;
        assertTrue(movie.printAllWithGenre(sampleMovieParsed, genreWanted).equals("\nCaptain America: Civil War"));
    }

    @Test
    public void printAllWithAverage() throws Exception {
        double minAverage = 6.0;
        assertTrue(movie.printAllWithAverage(sampleMovieParsed, minAverage).equals("\nCaptain America: Civil War"));
    }

    @Test
    public void printAllWithPopularity() throws Exception {
        double minPopularity = 30.0;
        assertTrue(movie.printAllWithPopularity(sampleMovieParsed ,minPopularity).equals("\nCaptain America: Civil War"));

    }

    //Testing false cases
    @Test
    public void printAllWithGenreFalse() throws Exception {
        int genreWanted = 99;
        assertFalse(movie.printAllWithGenre(sampleMovieParsed, genreWanted).equals("\nCaptain America: Civil War"));
    }

    @Test
    public void printAllWithAverageFalse() throws Exception {
        double minAverage = 10.0;
        assertFalse(movie.printAllWithAverage(sampleMovieParsed, minAverage).equals("\nCaptain America: Civil War"));
    }

    @Test
    public void printAllWithPopularityFalse() throws Exception {
        double minPopularity = 70.0;
        assertFalse(movie.printAllWithPopularity(sampleMovieParsed ,minPopularity).equals("\nCaptain America: Civil War"));

    }

}