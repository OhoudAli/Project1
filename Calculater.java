import java.util.*;
public class Calculater {
    static ArrayList<Double> result =new ArrayList<>();
    static double Last_Result=0;
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        input.useLocale(Locale.US);
        System.out.println("Welcome to the calculator: ");


        int number;
        String staying = "";
        boolean keepCalculater= true;

        while (keepCalculater) {
            System.out.println("Please Enter First Number: ");
            double First_number = ValidNumber();
            System.out.println("Please Enter Second Number: ");
            double Second_number = ValidNumber();
            System.out.println("HERE IS THE MENU");
            do {

                System.out.println(
                        "       - Enter 1 to addition the numbers\n" +
                                "       - Enter 2 to subtraction the numbers\n" +
                                "       - Enter 3 to multiplication the numbers\n" +
                                "       - Enter 4 to division the numbers\n" +
                                "       - Enter 5 to modulus the numbers\n" +
                                "       - Enter 6 to find minimum number\n" +
                                "       - Enter 7 to find maximum number\n" +
                                "       - Enter 8 to find the average of numbers\n" +
                                "       - Enter 9 to print the last result in calculator\n" +
                                "       - Enter 10 to print the list of all results in calculator\n" +
                                "       - Enter 0 to Exit   ");
                System.out.println("Enter what you need from the menu? ");
                number = input.nextInt();

                switch (number) {
                    case 1:
                        summation(First_number, Second_number);
                        break;
                    case 2:
                        subtraction(First_number, Second_number);

                        break;
                    case 3:
                        multiplication(First_number, Second_number);
                        break;
                    case 4:
                        division(First_number, Second_number);
                        break;
                    case 5:
                        modules(First_number, Second_number);
                        break;
                    case 6:
                        minimum(First_number, Second_number);
                        break;
                    case 7:
                        maximum(First_number, Second_number);
                        break;
                    case 8:
                        avarge(First_number, Second_number);
                        break;
                    case 9:
                        LastResult();
                        break;
                    case 10:
                        ListOfResult(First_number, Second_number);
                        break;
                    default:
                }

            } while (number != 0);
            System.out.println("Do you wanna Enters new numbers? (yes or no)");
            staying = input.next().toLowerCase();
            if (!staying.equals("yes")){
               keepCalculater = false;
            }

        }
        System.out.println("See you soon :)");
    }
    public static void summation(double first, double second) {
        double sum = 0;
        if (first == 0 || second == 0) {
            System.out.println("By adding any number to zero it will be the same number");
        } else {
            sum = first + second;
            System.out.println("The result of summation " + first + " + " + second + " = " + sum);
        }
        Last_Result = sum;
        result.add(Last_Result);
    }
    public static void subtraction(double first, double second){
        double sum = first-second;
        System.out.println("The result of subtraction "+first+" - "+ second+" = "+ sum);
        Last_Result = sum;
        result.add(Last_Result);
    }
    public static void multiplication(double first, double second) {
        double sum = 0;
        if (first != 0 && second != 0) {
            sum = first * second;
            System.out.println("The result from multiplication " + first + " * " + second + " = " + sum);
        } else
            System.out.println("Any thing multiply by zero will be zero .");

        Last_Result = sum;
        result.add(Last_Result);
    }
    public static void division(double first, double second){
        double sum =0;
      if( second == 0) {
            System.out.println("second number should not be zero .");
        }else {
                sum = first / second;
                System.out.println("The result from division " + first + " / " + second + " = " + sum);
        }
        Last_Result = sum;
        result.add(Last_Result);

    }
    public static void modules(double first, double second){
        double sum = 0;
        if(second == 0){
            System.out.println("Modulus by zero is undefined");
        }else {
            sum = first % second;
            System.out.println("The result from modules " + first + " % " + second + " = " + sum);
        }
        Last_Result = sum;
        result.add(Last_Result);

    }
    public static void minimum(double first, double second){
        double min =Math.min(first,second);

        System.out.println("The minimum number between " + first + " and " + second + " = " + min);
        Last_Result = min;
        result.add(Last_Result);

    }
    public static void maximum(double first, double second){
        double max =Math.max(first,second);

        System.out.println("The minimum number between " + first + " and " + second + " = " + max);
        Last_Result = max;
        result.add(Last_Result);
    }
    public static void avarge(double first, double second){
        double avarge = (first+second)/2;

        System.out.println("The average of " + first + " and " + second + " is " + avarge);
        Last_Result = avarge;
        result.add(Last_Result);

    }
    public static void LastResult(){
        System.out.println("The last result is " + Last_Result);

    }
    public static void ListOfResult(double first, double second){
        System.out.println("The results in array : " +result);

        summation(first,second);

        subtraction(first,second);

        multiplication(first,second);
        division(first,second);
        modules(first,second);
        minimum(first,second);
        maximum(first,second);
        avarge(first,second);

    }

    public static double ValidNumber() {
        while (true) {
            try {
                return input.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                input.next();
            }
        }
    }

}