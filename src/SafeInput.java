import java.util.Scanner;
public class SafeInput {
Scanner pipe = new Scanner(System.in);


    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = ""; // Set this to zero length. Loop runs until it isn't
        do
        {
            System.out.print("\n" +prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        }while(retString.length() == 0);

        return retString;

    }

    public static int getInt(Scanner pipe, String prompt){
        boolean done = false;
        int retInt = 0;
        String trash = " ";

        do{
            IO.print(prompt + ": ");

            if(pipe.hasNextInt()) {
                retInt = pipe.nextInt();
                done = true;
            }else{
                trash = pipe.nextLine();
                System.out.println("You need to enter a valid integer not: " + trash);
                done = false;
            }
        }while(!done);

        return(retInt);
    }

    public static double getDouble(Scanner pipe, String prompt){
        boolean done = false;
        double retDouble = 0;
        String trash = " ";

        do{
            IO.print(prompt + ": ");

            if(pipe.hasNextDouble()) {
                retDouble = pipe.nextDouble();
                done = true;
            }else{
                trash = pipe.nextLine();
                System.out.println("You need to enter a valid number not: " + trash);
                done = false;
            }
        }while(!done);

        return(retDouble);
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high){
       int retRange = 0;
       boolean done = false;
       String trash = " ";
       int userNum = 0;


        do{
            System.out.print(prompt+ " [" + low + "-" + high +"]: " );

            if(pipe.hasNextInt()){
                userNum = pipe.nextInt();
                if(userNum >= low && userNum <= high) {
                    done = true;
                    retRange = userNum;
                }
                else{
                    IO.println("You entered an input out of range: " + userNum + " Try again, range is ["+low+"-"+high+"]");
                    done = false;
                }
            }
            else
            {
                trash = pipe.nextLine();
                IO.println("You entered an invalid input: " + trash + " Please try again and " + prompt + " [" + low + "-" + high + "]");
            }
        }while(!done);


        return(retRange);
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high){
        double retRange = 0;
        boolean done = false;
        String trash = " ";
        double userNum = 0;


        do{
            System.out.print(prompt+ " [" + low + "-" + high +"]: " );

            if(pipe.hasNextDouble()){
                userNum = pipe.nextDouble();
                if(userNum >= low && userNum <= high) {
                    done = true;
                    retRange = userNum;
                }
                else{
                    IO.println("You entered an input out of range: " + userNum + " Try again, range is ["+low+"-"+high+"]");
                    done = false;
                }
            }
            else
            {
                trash = pipe.nextLine();
                IO.println("You entered an invalid input: " + trash + " Please try again and " + prompt + " [" + low + "-" + high + "]");
            }
        }while(!done);

        return(retRange);
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt){
        boolean done = false;
        String trash = " ";
        boolean retYN = false;

        do{
            IO.print(prompt + "[Y/N]: ");
            String response = pipe.nextLine();

            if(response.equalsIgnoreCase("Y") || response.equalsIgnoreCase("YES") ){
                done = true;
                retYN = true;
            }else if(response.equalsIgnoreCase("N") || response.equalsIgnoreCase("NO") ){
                done = true;
                retYN = false;
            }else{
                IO.println("You entered an invalid input: '" + response + "' please answer yes or no");
                done = false;
            }

        }while(!done);


        return(retYN);
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx){
        boolean done = false;
        String retRegEx = " ";


        do {
            IO.print(prompt + ": ");
            String response = pipe.nextLine();

                if (response.matches(regEx)) {
                    retRegEx = response;
                    done = true;
                } else {
                    IO.println("You entered an invalid input: '" + response + "' please match this pattern: " + regEx);
                }

        }while(!done);

        return(retRegEx);
    }

    public static String prettyHeader(String msg){
        int len =  msg.length();


        for(int i = 0; i <= 60; i++){
            IO.print("*");
        }
        IO.println();
        int spaces = (60 - 6) - len;
        int leftSpaces = spaces / 2;
        int rightSpaces = spaces - leftSpaces;

        IO.print("***");

        for(int i = 0; i < leftSpaces; i++){
            IO.print(" ");
        }

        IO.print(msg);
        if (len % 2 != 0)
            rightSpaces += 1;

        for(int i = 0; i < rightSpaces; i++){
            IO.print(" ");
        }
        IO.print("***");
        IO.println();

        for(int i = 0; i <= 60; i++){
            IO.print("*");
        }

        return(" ");

    }
}

/* censor color hex val: #133313 */