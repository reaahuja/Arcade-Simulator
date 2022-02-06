import java.util.*;
import java.io.*;

/*
Pre: N/A
Description: The SaveFile class inherits the Store class as it is a store component. Additionally, it allows the user
to write their information to a file and read it.
Post: N/A
 */
public class SaveFile extends Store {
    int age;
    String name;
    int points;

    /*
    Pre: N/A
    Description: This is the constructor of the SaveFile class
    Post: N/A
     */
    public SaveFile(){
        super();
        age = 0;
        name = "";
        points = 0;
    }

    /*
    Pre: This method takes the total number of points the user has won as a parameter
    Description: This method is the parameterized constructor of the SaveFile class
    Post: N/A
     */
    public SaveFile (int totalPoints){
        points = totalPoints;
    }

    /*
    Pre: N/A
    Description: This method provides the instructions for the Millionaire game to the user
    Post: N/A
     */
    void instructions() {
        System.out.println("Welcome to the save file component of the store!");
        System.out.println("You will be asked to input some information to put into your file!");
        System.out.println("Lets begin!");
    }

    /*
    Pre: N/A
    Description: This method directs the user and the main functionalities of the class
    Post: N/A
     */
    void menu() {
        Scanner input = new Scanner(System.in);
        File playerFile = new File("playerFile.docx");

        //file is created if its does not already exist
        if (playerFile.exists()){
            System.out.println("File exists");
        }else{
            try{
                playerFile.createNewFile();
                System.out.println("File created");
            }catch (IOException e){
                System.out.println("File could not be created");
                System.err.println("IOException: " + e.getMessage());
            }
        }

        try{
            //Streams are created to write to the file
            FileOutputStream outputStream = new FileOutputStream(playerFile);
            ObjectOutputStream writePlayer = new ObjectOutputStream(outputStream);

            //user is asked to input their information
            System.out.println("Enter your full name: ");
            String name = input.nextLine();
            //name is written to file
            writePlayer.writeObject("Name: " + name);

            System.out.println("Enter your age: ");
            String age = input.nextLine();
            //age is written to file
            writePlayer.writeObject("Age: " + age);


            System.out.println("Enter the name of your favourite game: ");
            String theFavouriteGame = input.nextLine();
            //name of favourite game is written to the file
            writePlayer.writeObject("Favourite game: " + theFavouriteGame);

            System.out.println("Last but not least, the number of points you earned is " + points);
            //points are written to file
            writePlayer.writeObject("Total points: " + points);

            //File is read if user chooses to
            System.out.println("Would you like to read the file? (1) for Yes and (2) for no");
            int option = input.nextInt();

            if (option == 1){
                //Input streams to read from file are created
                FileInputStream inputStream = new FileInputStream(playerFile);
                ObjectInputStream readPlayer = new ObjectInputStream(inputStream);
                System.out.println("File being read:\n");

                String reading;

                //each line in file is read
                for (int i = 0; i < 3; i++){
                    System.out.println(readPlayer.readObject());
                }
            }



        }catch (FileNotFoundException e){
            //if a FileNotFoundException error occurs the following messages will be printed
            System.out.println("File not found");
            System.out.println("FileNotFoundException: " + e.getMessage());
        }catch (IOException e){
            //if a IOException error occurs the following messages will be printed
            System.out.println("Problem with IO");
            System.err.println("IOException: " + e.getMessage());
        }catch (ClassNotFoundException e){
            //if a ClassNotFoundException error occurs the following messages will be printed
            System.out.println("Class not found");
            System.out.println("ClassNotFoundException: " + e.getMessage());
        }





    }
}
