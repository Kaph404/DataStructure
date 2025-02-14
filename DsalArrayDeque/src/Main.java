import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter code: ");
        if(CodeValidator.checkBrackets(scanner.nextLine())){
            System.out.println("Brackets are valid");
        }else{
            System.out.println("Brackets are invalid");
        }
    }
}