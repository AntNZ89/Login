import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        registerOrLogin();

    }


    public static void registerOrLogin(){

        Map<String , String> LOGIN_MAP = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Do you want to REGISTER or LOGIN? ");
        String answer = scanner.next();

        if (answer.toLowerCase().equals("register")){

            register(scanner, LOGIN_MAP);

        }
        else {
            if (LOGIN_MAP.isEmpty()){

                System.out.println("Database is empty! Please Register");
                register(scanner, LOGIN_MAP);

            }
            else {
                login(scanner, LOGIN_MAP);
            }
        }

        scanner.close();

    }


    public static void register(Scanner scanner, Map<String, String> LOGIN_MAP){

        System.out.println("What username do you want? ");
        String newUsername = scanner.next();
        System.out.println("What password do you want?");
        String newPassword = scanner.next();

        if (LOGIN_MAP.containsKey(newUsername)){

            System.out.println("Name is already taken, please try again");
            register(scanner, LOGIN_MAP);
            return;

        }
        else {

            LOGIN_MAP.put(newUsername, newPassword);

        }

        System.out.println("Do you want to LOGIN or REGISTER? ");
        String answer2 = scanner.next();

        if (answer2.equals("register")){

            register(scanner, LOGIN_MAP);

        }
        else {

            login(scanner, LOGIN_MAP);

        }
    }


    public static void login(Scanner scanner, Map<String, String> LOGIN_MAP){

        System.out.println("Username? ");
        String username = scanner.next();
        System.out.println("Password? ");
        String password = scanner.next();

        if (LOGIN_MAP.containsKey(username)){

            if (Objects.equals(LOGIN_MAP.get(username), password)){

                System.out.println("You are logged in as " + username);

            }
            else {

                System.out.println("Failed to login \n Do you want to try again? ");
                String retry = scanner.next();

                if (Objects.equals(retry, "yes")){

                    login(scanner, LOGIN_MAP);

                }
            }
        }
        else {

            System.out.println("Not a registered account! \n Do you want to REGISTER or LOGIN? ");
            String retry2 = scanner.next();

            if (retry2.toLowerCase().equals("register")){

                register(scanner, LOGIN_MAP);

            }
            else {

                login(scanner, LOGIN_MAP);

            }
        }
    }
}