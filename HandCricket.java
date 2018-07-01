
import java.util.*;

class HandCricket {

public static String username;
public static String batsman;
public static String playAgainChoice;
public static int run;
public static int flag;
public static String a;

public static void main() {
        clear();
        introduce();
        displayRules();
        clear();
        toss();
        play();
}

public static void play(){
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int[] runArray = new int[0];
        int balls = 0,enteredNumber=(0-1),randomNumber=(0-1),target = (0-1);
        run=0;
        flag = 0;
        for (;;) {
                createTable(runArray,balls,target,(batsman.equals("user") ? randomNumber : enteredNumber));
                leftAlign("Enter : ",35);
                centerifyInput();
                enteredNumber = sc.nextInt();
                randomNumber = (int)(r.nextInt(6));
                while (enteredNumber > 6) {
                        centreAlign(username + ", please enter a number less than 6");
                        centerifyInput();
                        enteredNumber = sc.nextInt();
                }
                if (batsman.equals("user")) {
                        if (enteredNumber == randomNumber) {
                                if (run == target) {
                                        leftAlign("It's a draw",35);
                                        delay(2000);
                                        leftAlign("My(computer) run : "+target,35);
                                        delay(1000);
                                        leftAlign("Your("+username+") run : "+run,35);
                                        delay(1000);
                                }else if (flag != 1) {
                                        delay(1500);
                                        leftAlign("We both had entered "+randomNumber,35);
                                        delay(2000);
                                        leftAlign(username+", you're out.Now it's my turn",35);
                                        delay(2000);
                                        leftAlign("Your("+username+") run : "+run,35);
                                        quiet();
                                        batsman = "computer";
                                        flag = 1;
                                        target = run;
                                        runArray = new int[0];
                                        run = 0;
                                        balls = 0;
                                        randomNumber = -1;
                                        continue;
                                }else {
                                        leftAlign(username+", You're out.You lose",35);
                                        delay(1000);
                                        leftAlign("My(computer) run : "+target,35);
                                        delay(1000);
                                        leftAlign("Your("+username+") run : "+run,35);
                                        delay(2000);
                                        leftAlign("You're a disgrace to cricket",35);
                                        delay(2000);
                                        break;
                                }
                        }else {
                                runArray = add(runArray,enteredNumber);
                                run += enteredNumber;
                        }
                        if (run > target && target >= 0) {
                                createTable(runArray,balls,target,randomNumber);
                                leftAlign(username+", You have won",35);
                                leftAlign("My(computer) run : "+target,35);
                                leftAlign("Your("+username+") run : "+run,35);
                                delay(2000);
                                break;
                        }
                }else {
                        sc = new Scanner(System.in);
                        if (enteredNumber == randomNumber) {
                                if (run == target) {
                                        leftAlign("It's a draw",35);
                                        delay(2000);
                                        leftAlign("Your("+username+") run : "+target,35);
                                        delay(1000);
                                        leftAlign("My(computer) run : "+run,35);
                                        delay(1000);
                                }else if (flag != 1) {
                                        delay(1500);
                                        leftAlign("We both had entered "+randomNumber,35);
                                        delay(2000);
                                        leftAlign("I'm out.Now it's your turn "+username,35);
                                        delay(2000);
                                        leftAlign("My(computer) run : "+run,35);
                                        quiet();
                                        batsman = "user";
                                        flag = 1;
                                        target = run;
                                        runArray = new int[0];
                                        run = 0;
                                        balls = 0;
                                        enteredNumber = -1;
                                        continue;
                                }else {
                                        leftAlign("We both had entered "+randomNumber,35);
                                        delay(2000);
                                        leftAlign("I'm out.I lose",35);
                                        delay(2000);
                                        leftAlign("Your("+username+") run : "+target,35);
                                        delay(1000);
                                        leftAlign("My(computer) run : "+run,35);
                                        delay(1000);
                                        break;
                                }
                        }else {
                                runArray = add(runArray,randomNumber);
                                run += randomNumber;
                        }
                        if (run > target && target >= 0) {
                                createTable(runArray,balls,target,randomNumber);
                                leftAlign(username + ", you lose.I have won",35);
                                delay(1000);
                                leftAlign("My(computer) run : "+run,35);
                                delay(1000);
                                leftAlign("Your("+username+") run : "+target,35);
                                delay(2000);
                                leftAlign("You're a disgrace to cricket",35);
                                delay(2000);
                                break;
                        }
                }
                balls +=1;
        }
        playAgain();
}

public static void playAgain(){
        leftAlign("Do you wanna play again, "+username+"??Y or N",35);
        for (;;) {
                centerifyInput();
                Scanner sc = new Scanner(System.in);
                String playAgainChoice = sc.nextLine().toLowerCase();
                if (playAgainChoice.equals("n")) {
                        clear();
                        break;
                }else if (playAgainChoice.equals("y")) {
                        clear();
                        toss();
                        play();
                        break;
                }else if(playAgainChoice.equals("") == false) {
                        centreAlign(username+", please Enter Correctly");
                }
        }
}

public static void createTable(int[] arr,int balls,int target,int num){
        clear();
        leftAlign("BALLS : " + balls,35);
        if (flag == 1) {
                leftAlign("TARGET : " + (target+1),35);
        }
        leftAlign("+-----------+-----------+",35);
        leftAlign("|         SCORE         |",35);
        leftAlign("+-----------+-----------+",35);
        for (int i=0; i<arr.length; i++) {
                leftAlign("|           "+arr[i]+"           |",35);
        }
        leftAlign("+-----------+-----------+",35);
        leftAlign("                "+run+"                        ",31);
        leftAlign("+-----------+-----------+",35);
        if (num != -1) {
                if (batsman.equals("user")) {
                        leftAlign("I have entered "+num,35);
                }else {
                        leftAlign("You have entered "+num,35);
                }
        }
}
public static void toss(){
        Scanner sc = new Scanner(System.in);
        centreAlign("So let's toss.Enter 'H' for heads or 'T' for tails");
        String[] tossOptions = {"h","t"};
        String tossChoice;
        int enteredChoice;
        int randomNumber;
        for (;;) {
                centerifyInput();
                tossChoice = sc.nextLine().toLowerCase();
                randomNumber = (int)(Math.random() * 1000);
                if (tossOptions[randomNumber%2].equals(tossChoice)) {
                        centreAlign(username+", you have won the toss.Enter '0' for BATTING or '1' for BOWLING");
                        centerifyInput();
                        enteredChoice = sc.nextInt();
                        batsman = (enteredChoice == 0) ? "user" : "computer";
                        centreAlign(username + " you have chosen " + ((enteredChoice == 0) ? "batting" : "bowling"));
                        a = sc.nextLine();
                        break;
                }else if (tossOptions[randomNumber%2].equals(tossChoice) == false && Arrays.asList(tossOptions).contains(tossChoice) == true) {
                        centreAlign(username+", you have lost the toss.I choose " + ((randomNumber%2 == 0) ? "batting" : "bowling"));
                        batsman = (randomNumber%2 == 0) ? "computer" : "user";
                        break;
                }else if(tossChoice.equals("") == false) {
                        centreAlign(username+", please enter 'H' or 'T' only");
                }
        }
        quiet();
}

public static void displayRules() {
        Scanner sc = new Scanner(System.in);
        clear();
        centreAlign("So "+username+", do you want to display the rules of the game???Y or N");
        for (;;) {
                centerifyInput();
                String displayRules = sc.next().toLowerCase();
                if (displayRules.equals("y")) {
                        centreAlign("The number you enter must be within 0 and 6");
                        delay(1500);
                        centreAlign("The inning will continue untill the batsman is out");
                        delay(1500);
                        centreAlign("You know the rest,right!");
                        quiet();
                        break;
                }else if (displayRules.equals("n")) {
                        break;
                }else {
                        centreAlign(username+", Please Enter Y or N");
                }
        }
}

public static void quiet() {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
}

public static void gameTitle(){
        leftAlign("|   |  /=\\  |\\  | |==\\\\     //=== |==\\ ===  //=== |  / |=== =====",17);
        leftAlign("|===| /===\\ | \\ | |   |     |     |__/  |   |     |||  |===   |",17);
        leftAlign("|   |/     \\|  \\| |==//     \\\\=== |\\\\  ===  \\\\=== |  \\ |===   |",17);
        System.out.println();
}

public static void introduce(){
        Scanner sc = new Scanner(System.in);
        centreAlign("Welcome");
        delay(1000);
        centreAlign("May I know your name???");
        centerifyInput();
        username = sc.nextLine();
}

public static void delay(int t){
        try {
                Thread.sleep(t);
        }catch(InterruptedException ie) {
                ie.printStackTrace();
        }
}

public static void centreAlign (String s) {
        int l = s.length();
        System.out.printf("%-"+((100-l)/2)+"s "+s+"%n","");
}

public static void leftAlign (String s,int l) {
        System.out.printf("%-"+l+"s "+s+"%n","");
}

public static void clear () {
        System.out.print('\u000C');
        gameTitle();
}

public static void centerifyInput(){
        System.out.print("                                                  ");;
}

public static int[] add(int[] arr,int elem){
        int[] tempArray = new int[arr.length];
        for (int j=0; j<tempArray.length; j++ ) {
                tempArray[j] = arr[j];
        }
        arr = new int[tempArray.length+1];
        for (int j=0; j<arr.length-1; j++ ) {
                arr[j] = tempArray[j];
        }
        arr[arr.length-1] = elem;
        return arr;
}
}
