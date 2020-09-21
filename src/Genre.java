import java.util.ArrayList;

public class Genre {
    ArrayList<Genre> genreArrayList = new ArrayList<Genre>();

    Genre genre1 = new Genre();

    //public Genre();

    public ArrayList<Genre> getGenreArrayList() {return genreArrayList;}
    public void setGenreArrayList(ArrayList<Genre> genreArrayList) {this.genreArrayList = genreArrayList;}
}
