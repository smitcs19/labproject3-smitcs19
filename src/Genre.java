import java.util.ArrayList;

public class Genre {
    ArrayList<String> genreArrayList = new ArrayList<String>();

    public Genre(ArrayList<String> input){
        genreArrayList = input;
    }

    public boolean isGenre(String category){
        return (genreArrayList.contains(category));
    }

    @Override
    public String toString() {
        String ret = "Genres: ";
        for (String s : genreArrayList){
            ret += s + " ";
        }
        return ret;
    }
}
