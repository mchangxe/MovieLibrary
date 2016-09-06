package M;

import CS126.parseFunction;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class parseFunctionTest {

    @Before
    Gson gson = new Gson();
    // 1. JSON to Java object, read it from a file.
    List<parseFunction.movieData> movieList = new ArrayList<parseFunction.movieData>();
    movieList = gson.fromJson(new FileReader("apiData.json"), new TypeToken<List<parseFunction.movieData>>(){}.getType());

    @Test
    public void printAll() throws Exception {

    }

    @Test
    public void printAllWithGenre() throws Exception {

    }

    @Test
    public void printAllWithAverage() throws Exception {

    }

    @Test
    public void printAllWithPopularity() throws Exception {

    }

}