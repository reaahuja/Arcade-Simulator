import java.util.*;

/*
Pre: N/A
Description: The StackGame class inherits the Gaming class as it is a part of the gaming component. This game asks the
user if they think there is a special value in the element of a stack and gives points depending on whether they are
right or wrong.
Post: N/A
 */
public class StackGame extends Gaming{
    int points;

    /*
    Pre: N/A
    Description: This is the constructor of the StackGame class
    Post: N/A
     */
    public StackGame(){
        super();
        points = 0;
    }

    /*
    Pre: N/A
    Description: This method returns the variable points
    Post: This method returns the variable points
     */
    public int getPoints() {
        return points;
    }

    /*
    Pre: This method takes the points variable as a parameter
    Description: This method sets a value for the points variable
    Post: N/A
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /*
   Pre: N/A
   Description: This method provides the instructions for the Millionaire game to the user
   Post: N/A
    */
    public void instructions(){
        System.out.println("Welcome to Stack in Here");
        System.out.println("In this game, there are 10 crates and in some of the crates there is a duck");
        System.out.println("You will be given the weight of the crate and you have to guess if there is a duck in it");
        System.out.println("If you guess correctly, then you will win 100 points for each guess, but if not you will not win any points");
        System.out.println("Note: The weight of a duck is 3 pounds and the crates may contain other items\n");
    }

    /*
    Pre: N/A
    Description: This method directs the user and the main functionalities of the class
    Post: N/A
     */
    public void menu() {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int crateWeight;
        int counter = 1;
        int answer;
        Stack gameStack = new Stack(10);
        gameStack = fillStack(gameStack);
        boolean isDuck;

        System.out.println("Are you ready? Lets play!");

        while (!gameStack.isEmpty()){
            //program checks if top of the stack has the value of 1 which represents a 'duck'
            if (gameStack.top() == 1){
                isDuck = true;
            }else{
                isDuck = false;
            }

            //specific weight is generated if the crate has a 'duck'
            if (isDuck){
                crateWeight = random.nextInt(8) + 3;
            }else{
                //isDuck == false
                crateWeight = random.nextInt(4) + 1;
            }
            System.out.println("\nCrate " + counter);
            System.out.println("The weight of the crate is " + crateWeight);
            System.out.println("Do you think there is a duck?");
            System.out.println("Answer 1 for yes and 2 for no");
            answer = input.nextInt();


            if (answer == 1){
                //user thinks there is a duck then this conditional statement is entered
                if(isDuck){
                    System.out.println("Congratulations, you are right!");
                    points += 100;
                    System.out.println("You have been awarded 100 points!");
                }else{
                    System.out.println("Wrong answer!");
                }
            }else if (answer == 2){
                //user thinks there is not a duck then this conditional statement is entered
                if (isDuck){
                    System.out.println("Wrong answer!");
                }else{
                    System.out.println("Congratulations, you are right!");
                    points += 100;
                    System.out.println("You have been awarded 100 points!");
                }
            }else{
                System.out.println("Invalid option! Please choose 1 for yes anf 2 for no");
            }

            //value of counter which represents the crate being looked at is increased
            counter++;
            //element is popped so next element can be looked at
            gameStack.pop();

        }

    }

    /*
    Pre: The stack created in the menu is taken as a parameter
    Description: This method randomly fills the Stack with 0s and 1s
    Post: The method returns the stack filled with values
     */
    public Stack fillStack(Stack gameStack){
        Random random = new Random();
        int counter1 = 0;
        int counter = 0;

        while (counter < 10){
            int numberFiller = random.nextInt(2);
            //the following conditional statement makes sure that there are not an excess amount of 'ducks'
            if (counter1 < 5 && numberFiller == 1){
                gameStack.push(numberFiller);
                counter1++;
            }else{
                //if numberFiller is not 1 and the stack already has 5 1s then fill the element in the stack with a 0
                numberFiller = 0;
                gameStack.push(numberFiller);
            }
            counter++;
        }

        //stack is returned
        return gameStack;
    }



}

/*
Pre: N/A
Description: This class represents a Stack
Post: N/A
 */
class Stack{

    int []data;
    int top;

    /*
    Pre: This method takes the maximum amount of items that the stack can hold as a parameter
    Description: This method is the parameterized constructor of the Stack class
    Post: N/A
     */
    public Stack(int maxItems){
        data = new int[maxItems];
        top=-1;
    }

    /*
    Pre: N/A
    Description: This method removes the top element
    Post: The method returns the value of the popped element
     */
    public int pop(){
        top = top -1;
        return data[top+1];

    }

    /*
    Pre: This method takes the element that needs to be added to the stack as a parameter
    Description: This method adds a element to the stack
    Post: N/A
     */
    public void push(int item){
        if(top <= data.length-1){
            top = top +1;
            data[top]=item;
        }
    }

    /*
    Pre: N/A
    Description: This method returns the top value of the Stack
    Post: This method returns the top value of the Stack
     */
    public int top(){
        return data[top];
    }

    /*
    Pre: N/A
    Description: This method checks and returns a value indicating if the stack is empty or not
    Post: A boolean value of true or false to indicate if the stack is empty or not
     */
    public boolean isEmpty(){
        if (top==-1){
            return true;
        }
        else return false;
    }

    /*
    Pre: N/A
    Description: This method returns the size of the stack
    Post: The size of the stack is returned
     */
    public int size(){
        if (isEmpty()){
            return 0;
        }
        else {
            return top+1;
        }
    }

    /*
    Pre: N/A
    Description: This method makes the stack empty
    Post: N/A
     */
    public void makeEmpty()
    {
        top=-1;
    }
}
