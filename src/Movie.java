import java.util.ArrayList;

public class Movie implements Comparable<Movie>{

    private String titleType;
    private String primaryTitle;
    private String originalTitle;
    private int startYear;
    private String runTimeMins;
    private Genre genre;

    public void setGenres(ArrayList<String> list){
        Genre temp = new Genre(list);
        genre = temp;
    }

    @Override
    public String toString(){
        String ret = "Type: " + titleType + ", ";
        ret+= "Title: " + primaryTitle + ", ";
        ret+= "Original Title: " + originalTitle + ", ";
        ret+= "Start Year: " + startYear + ", ";
        ret+= "Run Time: " + runTimeMins + ", ";
        ret+= "Genre: " + genre.toString();
        return ret;
    }

    public Movie(){

        this.titleType = "None";
        this.primaryTitle = "None";
        this.originalTitle ="None";
        this.startYear = 0;
        this.runTimeMins = "None";
    }

    public Movie(String titleType, String primaryTitle, String originalTitle, String startYear, String runTimeMins, String genres){
        this.titleType = titleType;
        this.primaryTitle = primaryTitle;
        this.originalTitle = originalTitle;
        this.startYear = Integer.parseInt(startYear);
        this.runTimeMins = runTimeMins;
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
    public int getStartYear() {
        return startYear;
    }
    public String getRunTimeMins() {
        return runTimeMins;
    }

    public void setTitleType(String titleType) {
        this.titleType = titleType;
    }
    public void setPrimaryTitle(String primaryTitle) {
        this.primaryTitle = primaryTitle;
    }
    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }
    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }
    public void setRunTimeMins(String runTimeMins) {
        this.runTimeMins = runTimeMins;
    }

    public int compareTo(Movie otherMovie){
        if(this.startYear==otherMovie.startYear){
            return 0;
        } else if(this.startYear>otherMovie.startYear){
            return 1;
        } else{
            return -1;
        }
    }
}
