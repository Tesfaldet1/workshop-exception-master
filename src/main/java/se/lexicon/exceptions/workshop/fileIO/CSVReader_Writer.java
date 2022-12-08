package se.lexicon.exceptions.workshop.fileIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CSVReader_Writer {
    /**
     * This method getMaleFirstNames should use a try-catch-finally without resources
     * Should catch FileNotFoundException and IOException
     * You should also close the Buffered reader in the finally block
     *
     * @return List<String>of male firstnames
     */

    public static List<String> getMaleFirstNames ()throws FileNotFoundException {
        BufferedReader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get("firstname_males.txt"));


        } catch (NullPointerException e){
            System.out.println("male file was null");
        }
        catch (IOException e) {
            System.out.println("In catch block");
        }finally {
            System.out.println("__finally block__");
            try {
                if(reader!=null) {
                    System.out.println("Attempting to cols male name file");
                    reader.close();
                }
            } catch (IOException e) {
                throw new FileNotFoundException("this file is not fond", "-");
            }
        }

        List<String> names = reader.lines().collect(Collectors.toList());
        names = reader.lines()
                .flatMap(line -> Stream.of(line.split(",")))
                .collect(Collectors.toList());
         	return names;

       }




    /**
     * This method getFemaleFirstNames should make use of a try-catch with resources
     * @return
     */
    public static List<String> getFemaleFirstNames(){

        List<String> names=null;

        BufferedReader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get("firstname_female.txt"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        names = reader.lines()
                        .flatMap(line -> Stream.of(line.split(",")))
                        .collect(Collectors.toList());

        return names;
    }


    /**
     * This method fetches strings from a file and put them into a list
     * This method might throw IOException which due to the throws clause need to
     * be handled by the caller.
     * @return List <String> of last names
     * @throws IOException
     */
    public static List<String> getLastNames() throws IOException{

        List<String> names = null;
        BufferedReader reader = null;

        try{
                reader = Files.newBufferedReader(Paths.get("lastnames.txt"));
                names = reader.lines()
                .flatMap(line -> Stream.of(line.split(",")))
                .collect(Collectors.toList());


        }finally{
            if(reader != null){
                reader.close();
            }
        }
        return names;
    }


    public static void saveLastNames(List <String> lastNames){

        BufferedWriter writer = null;
        try {
            writer = Files.newBufferedWriter(Paths.get("lastnames.txt"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        for(String toWrite : lastNames){
            try {
                writer.append(toWrite+",");
            } catch (IOException e) {

                System.out.println(e.getMessage());
            }
        }
        try {
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void saveFemaleNames(List <String> femaleNames){
        BufferedWriter writer = null;
        try {
            writer = Files.newBufferedWriter(Paths.get("firstname_female.txt"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        for(String toWrite : femaleNames){
            try {
                writer.append(toWrite+",");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void saveMaleNames(List <String> maleNames){
        BufferedWriter writer = null;
        try {
            writer = Files.newBufferedWriter(Paths.get("firstname_males.txt"));
        } catch (IOException e) {
            System.out.println(e.getMessage());;
        }
        for(String toWrite : maleNames){
            try {
                writer.append(toWrite+",");
            } catch (IOException e) {
                System.out.println(e.getMessage());;
            }
        }
        try {
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }


}
