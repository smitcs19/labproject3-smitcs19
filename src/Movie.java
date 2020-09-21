import java.util.ArrayList;

public class Movie {
    ArrayList<String> genreArrayList = new ArrayList<String>();

    private String titleType;
    private String primaryTitle;
    private String originalTitle;
    private String startYear;
    private String runTimeMins;
    //private String genres;

    //public Genre genreList;

    public void setGenreArrayList(String genreFor1) {
        genreArrayList.add(genreFor1);
    }
    public void setGenreArrayList(String genreFor1, String genreFor2) {
        genreArrayList.add(genreFor1);
        genreArrayList.add(genreFor2);
    }
    public void setGenreArrayList(String genreFor1, String genreFor2, String genreFor3) {
        genreArrayList.add(genreFor1);
        genreArrayList.add(genreFor2);
        genreArrayList.add(genreFor3);
    }


    public Movie(){

        this.titleType = "None";
        this.primaryTitle = "None";
        this.originalTitle ="None";
        this.startYear = "None";
        this.runTimeMins = "None";
        //this.genres = "None";
    }

    public Movie(String titleType, String primaryTitle, String originalTitle, String startYear, String runTimeMins, String genres){
        this.titleType = titleType;
        this.primaryTitle = primaryTitle;
        this.originalTitle = originalTitle;
        this.startYear = startYear;
        this.runTimeMins = runTimeMins;
        //this.genres = genres;
    }

    public String getTitleType() {
        return titleType;
    }
    public String getPrimaryTitle() {
        return primaryTitle;
    }
    public String getOriginalTitle() {
        return originalTitle;
    }
    public String getStartYear() {
        return startYear;
    }
    public String getRunTimeMins() {
        return runTimeMins;
    }
    //public String getGenres() {
      //  return genres;
    //}

    public void setTitleType(String titleType) {
        this.titleType = titleType;
    }
    public void setPrimaryTitle(String primaryTitle) {
        this.primaryTitle = primaryTitle;
    }
    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }
    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }
    public void setRunTimeMins(String runTimeMins) {
        this.runTimeMins = runTimeMins;
    }
    //public void setGenres(String genres) {
     //   this.genres = genres;
    //}
}
