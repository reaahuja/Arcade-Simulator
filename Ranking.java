import java.util.*;

/*
Pre: N/A
Description: The Ranking class inherits the store class as it is a store component. Additionally, it displays a
leaderboard with randomly generated users and points.
Post: N/A
 */
public class Ranking extends Store{
    int userPoints;

    /*
    Pre: N/A
    Description: This method is a constructor for the Ranking class
    Post: N/A
     */
    public Ranking(){
        super();
        userPoints = 0;
    }

    /*
    Pre: The method takes the total number of points that the user has won as a parameter
    Description: This method is the parameterized constructor of the Ranking class
    Post: N/A
     */
    public Ranking(int totalPoints){
        this.userPoints = totalPoints;
    }

    /*
    Pre: N/A
    Description: This method provides the instructions for the Millionaire game to the user
    Post: N/A
     */
    void instructions() {
        System.out.println("In this component, the leadership board will be displayed");
    }

    /*
    Pre: N/A
    Description: This method directs the user and the main functionalities of the class
    Post: N/A
     */
    void menu() {
        Scanner input = new Scanner(System.in);

        //ArrayList with integers is created
        ArrayList<Integer> users = new ArrayList<Integer>();
        //users points are added to list
        users.add(userPoints);

        //random points are added to list
        for (int i = 0; i < 4; i++){
            int otherUsers = randomPoints();
            users.add(otherUsers);
        }

        //users list is sorted using bubble sort
        for (int i = 0; i < users.size(); i++){
            for (int j = 0; j < users.size() - 1; j ++){
                if (users.get(j) > users.get(j + 1)){
                    int temp = users.get(j);
                    users.set(j, users.get(j + 1));
                    users.set(j + 1, temp);
                }
            }
        }

        //ArrayList with strings that contains with names of users is created
        ArrayList<String> usersNames = new ArrayList<String>();

        //Random names are added to list
        for (int i = 0; i < 5; i++){
            String[] nameBank = {"Rea", "Ahuja", "Bob", "Mary", "Emma"};
            usersNames.add(nameBank[i]);
        }

        //ArrayList method is called on to sort usersName list
        Collections.sort(usersNames);


        int value = 0;

        //leadership board is printed
        for (int i = 0; i < usersNames.size(); i++){
            int points = users.get(i);
            if (points == userPoints){
                System.out.println("You: " + points);
                value = i;
            }else{
                System.out.println(usersNames.get(i) + ": " + points);
            }
        }

        System.out.println("");

        //user is given a comment based on their placement on the leaderboard
        if (value == 4){
            System.out.println("Awesome your first on the board!");
        }else if (value == 0){
            System.out.println("Awh your in last place :(");
        }else{
            System.out.println("Your in the middle of the board! Cool!");
        }

        System.out.println("");



    }

    /*
    Pre: N/A
    Description: This method returns a random number which is then used to assign the random users with points
    Post: The number of points for the random user
     */
    public int randomPoints(){
        Random random = new Random();

        int[] pointsIndex = new int[22];
        int number = 0;

        //array is filled with numbers
        for (int i = 0; i < pointsIndex.length - 1; i++){
            pointsIndex[i] = number;
            number += 100;
        }

        pointsIndex[21] = 1000000;

        //randomNumber is generated and is used to get random number of points from array
        int randomNumber = random.nextInt(22);

        int othersPoints = pointsIndex[randomNumber];


        return othersPoints;
    }

}
