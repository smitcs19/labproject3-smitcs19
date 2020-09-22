import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
public class Project3 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        FileInputStream myFile = null;

        boolean getPathLoop = true;
        while(getPathLoop) {
            try {
                //myFile = new FileInputStream("src/moviesDataset.csv");
                //Scanner fileReader = new Scanner(myFile);

                System.out.println("Input the file path");
                String filePath = keyboard.nextLine();
                myFile = new FileInputStream(filePath);

                Scanner fileReader = new Scanner(myFile);
                int counter = 0;
                Movie[] movieArray = new Movie[801]; // I need to store the movie info in an array
                Genre[] genreArray = new Genre[801];


                while (fileReader.hasNextLine()) {
                    Movie movie1 = new Movie();


                    String data = fileReader.nextLine();
                    //System.out.println(data);

                    int a = data.indexOf(",");
                    //System.out.println("a"+a);
                    int b = data.indexOf(",", a + 1);
                    //System.out.println("b"+b);
                    int c = data.indexOf(",", b + 1);
                    //System.out.println("c"+c);
                    int d = data.indexOf(",", c + 1);
                    //System.out.println("d"+d);
                    int e = data.indexOf(",", d + 1);
                    //System.out.println("e"+e);
                    int f = data.indexOf(",", e + 1);
                    //System.out.println("f"+f);
                    int g = data.length();
                    //System.out.println("g"+g);

                    movie1.setTitleType(data.substring(a + 1, b));
                    //System.out.println(movie1.getTitleType());

                    movie1.setPrimaryTitle(data.substring(b + 1, c));
                    //System.out.println(movie1.getPrimaryTitle());

                    movie1.setOriginalTitle(data.substring(c + 1, d));
                    //System.out.println(movie1.getOriginalTitle());

                    String syString = data.substring(d + 1, e);
                    try {
                        movie1.setStartYear(Integer.parseInt(syString));
                    } catch(NumberFormatException e2){}
                    //System.out.println(movie1.getStartYear());

                    movie1.setRunTimeMins(data.substring(e + 1, f));
                    //System.out.println(movie1.getRunTimeMins());

                    //movie1.setGenres(data.substring(f + 1, g));
                    //System.out.println(movie1.getGenres());

                    String genreString = data.substring(f+1, g);
                    //System.out.println(genreString);

                    String delimiter = ",";
                    //genreString holds all of the genres in one string
                    genreString.split(delimiter);
                    String [] genreSplit = genreString.split(delimiter);

                    ArrayList<String> genreArrayList = new ArrayList<String>();

                    for (int i=0; i<genreSplit.length; i++){
                        if(genreSplit[i].contains("\\N")) {
                            genreArrayList.add("none");
                        } else{
                           genreSplit[i] = genreSplit[i].toLowerCase();
                            //System.out.println(genreSplit[i]);
                            genreArrayList.add(genreSplit[i]);
                        }
                    }
                    movie1.setGenres(genreArrayList);
                    Genre genre1 = new Genre(genreArrayList);

                    //System.out.println(genreArrayList);

                    movieArray[counter] = movie1;
                    genreArray[counter] = genre1;
                    counter++;

                }
                fileReader.close();

                FileOutputStream Titles = new FileOutputStream("Titles.txt");
                PrintWriter fileWriter = new PrintWriter(Titles);

                for (int j = 1; j < 801; j++) {
                    String title = movieArray[j].getPrimaryTitle();
                    fileWriter.println(title);
                }
                fileWriter.close();

                FileOutputStream Movies2005through2020 = new FileOutputStream("Movies2005-2020.txt");
                fileWriter = new PrintWriter(Movies2005through2020);

                    for (int j = 1; j < 801; j++) {
                        int MY;
                        try {
                            MY = movieArray[j].getStartYear();

                            if(MY>=2005 && MY<=2020) {
                                fileWriter.print(movieArray[j].toString());
                                //fileWriter.println(genreArray[j].toString());
                                fileWriter.println();
                            }
                        } catch (NumberFormatException e1){
                            System.out.println("Error in start year at line " + j);
                        }
                    }
                    fileWriter.close();

                FileOutputStream Documentary = new FileOutputStream("Documentary.txt");
                fileWriter = new PrintWriter(Documentary);

                for (int j = 1; j < 801; j++) {

                    if (genreArray[j].isGenre("documentary")) {
                        fileWriter.print(movieArray[j].toString());
                        //fileWriter.println(genreArray[j].toString());
                        fileWriter.println();
                    }
                }

                fileWriter.close();

                FileOutputStream titleandyear = new FileOutputStream("Title-Year.txt");
                fileWriter = new PrintWriter(titleandyear);

                for (int j = 1; j < 801; j++) {
                    String title = movieArray[j].getPrimaryTitle();
                    int year = movieArray[j].getStartYear();

                    fileWriter.println(title + " " + year);
                }
                fileWriter.close();

                FileOutputStream SortedByYear = new FileOutputStream("SortedByYear.txt");
                fileWriter = new PrintWriter(SortedByYear);
                Movie movie2 = new Movie();

                for(int i=1900; i<=2020; i++) {
                    movie2.setStartYear(i);
                    //System.out.println(movie2.getStartYear());
                    boolean yearFound = false;
                    for(int j=1; j<movieArray.length; j++){
                        int x = movie2.compareTo(movieArray[j]);
                        //System.out.println(x);
                        if (x==0){
                            fileWriter.print(movieArray[j].toString());
                            fileWriter.println();
                            yearFound = true;
                        }
                    }
                    if(yearFound) {
                        fileWriter.println();
                    }

                } fileWriter.close();

                getPathLoop = false;
            } catch (FileNotFoundException e1) {
                System.out.println("File Not Found");
            }
        }

        //JOptionPane.showMessageDialog(null, "All tasks complete.");
        System.out.println("All Tasks Complete");
    }
}

// C:\Users\Camer\IdeaProjects\project2f-smitcs19\src\moviesDataset.csv

