import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
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

                    movie1.setStartYear(data.substring(d + 1, e));
                    //System.out.println(movie1.getStartYear());

                    movie1.setRunTimeMins(data.substring(e + 1, f));
                    //System.out.println(movie1.getRunTimeMins());

                    //movie1.setGenres(data.substring(f + 1, g));
                    //System.out.println(movie1.getGenres());

                    String genreString = data.substring(f+1, g);
                    //System.out.println(genreString);
                    int numCommas = 0;

                    for(int j=0; j<genreString.length(); j++){
                        char instance = genreString.charAt(j);
                        char comma1 = ',';
                        if(instance == comma1){
                            numCommas++;
                        }
                    }

                    //System.out.println(numCommas);
                    if(numCommas==0){
                        movie1.setGenreArrayList(genreString);
                    } else if(numCommas==1){
                        a = genreString.indexOf(",");
                        b = genreString.indexOf(",", a + 1);
                        c = genreString.indexOf(",", b + 1);
                        String firstGenre = genreString.substring(a+1,b);
                        String secondGenre = genreString.substring(b+1,c);
                        movie1.setGenreArrayList(firstGenre, secondGenre);
                    } else if(numCommas==2){
                        a = genreString.indexOf(",");
                        b = genreString.indexOf(",", a + 1);
                        c = genreString.indexOf(",", b + 1);
                        d = genreString.indexOf(",", c + 1);
                        String firstGenre = genreString.substring(a+1,b);
                        String secondGenre = genreString.substring(b+1,c);
                        String thirdGenre = genreString.substring(c+1,d);
                        movie1.setGenreArrayList(firstGenre, secondGenre, thirdGenre);
                    } else if(numCommas==3){
                        a = genreString.indexOf(",");
                        b = genreString.indexOf(",", a + 1);
                        c = genreString.indexOf(",", b + 1);
                        d = genreString.indexOf(",", c + 1);
                        e = genreString.indexOf(",", d + 1);
                        String secondGenre = genreString.substring(b+1,c);
                        String thirdGenre = genreString.substring(c+1,d);
                        String extraGenre = genreString.substring(d+1,e);
                        movie1.setGenreArrayList(secondGenre, thirdGenre, extraGenre);
                    }

                    movieArray[counter] = movie1;
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
                            MY = Integer.parseInt(movieArray[j].getStartYear());

                            if(MY>=2005 && MY<=2020) {

                                fileWriter.print(movieArray[j].getStartYear() + ", ");
                                fileWriter.print(movieArray[j].getPrimaryTitle() + ", ");
                                fileWriter.print(movieArray[j].getOriginalTitle() + ", ");
                                fileWriter.print(movieArray[j].getRunTimeMins() + ", ");
                                //fileWriter.println(movieArray[j].getGenres());
                            }
                        } catch (NumberFormatException e1){
                            System.out.println("Error in start year at line " + j);
                        }
                    }
                    fileWriter.close();

                FileOutputStream Documentary = new FileOutputStream("Documentary.txt");
                fileWriter = new PrintWriter(Documentary);

                /*
                for (int j = 1; j < 801; j++) {
                    String Doc = movieArray[j].getGenres();

                    if (Doc.contains("Documentary")) {
                        fileWriter.print(movieArray[j].getPrimaryTitle() + ", ");
                        fileWriter.print(movieArray[j].getStartYear() + ", ");
                        fileWriter.print(movieArray[j].getOriginalTitle() + ", ");
                        fileWriter.print(movieArray[j].getRunTimeMins() + ", ");
                        fileWriter.println(movieArray[j].getGenres());
                    }
                }

                 */
                fileWriter.close();

                FileOutputStream titleandyear = new FileOutputStream("Title-Year.txt");
                fileWriter = new PrintWriter(titleandyear);

                for (int j = 1; j < 801; j++) {
                    String title = movieArray[j].getPrimaryTitle();
                    String year = movieArray[j].getStartYear();

                    fileWriter.println(title + " " + year);
                }
                fileWriter.close();


                getPathLoop = false;
            } catch (FileNotFoundException e1) {
                System.out.println("File Not Found");
            }
        }

        JOptionPane.showMessageDialog(null, "All tasks complete.");
    }
}

// C:\Users\Camer\IdeaProjects\project2f-smitcs19\src\moviesDataset.csv

