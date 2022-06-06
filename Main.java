import mytax.myTax;
import taxdohod.taxD;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int earnings = 0;    // доходы
        int spendings = 0;   // расходы
        while (true) {
            System.out.println("Select a set and enter its number:");
            System.out.println("1. Add new income +");
            System.out.println("2.Add new expense -");
            System.out.println("3.Choose a taxation system");
            System.out.println("To end the program, type end");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            int operations = Integer.parseInt(input);


            switch (operations) {
                case 1 -> {
                    System.out.println("Enter the amount of income +:");
                    String moneyStr = scanner.nextLine(); // Не используйте тут nextInt (!)
                    int money = Integer.parseInt(moneyStr);
                    earnings += money;
                }
                case 2 -> {
                    System.out.println("Enter the amount of the expense -:");
                    String spendStr = scanner.nextLine(); // Не используйте тут nextInt (!)
                    int spend = Integer.parseInt(spendStr);
                    spendings += spend;
                }
                case 3 -> {
                    //расходы минус доходы
                    int alltaxR = myTax.taxRAS(earnings, spendings);
                    int alltaxD = taxD.taxes(earnings);
                    if (alltaxR > alltaxD) {
                        System.out.println("Mi sovetuem vam USN dohodi");
                        System.out.println("Vash nalog sostavit " + alltaxD + " rublei");
                        System.out.println("Nalog na drugoi sisteme: " + alltaxR + " rublei");
                        int econom = alltaxR - alltaxD;
                        System.out.println("Ekonomiya:" + econom + " rublei");
                    } else {
                        System.out.println("Mi sovetuem vam USN dohodi minus rashodi");
                        System.out.println("Vash nalog sostavit: " + alltaxR);
                        System.out.println("Nalog na drugoi sisteme: " + alltaxD);
                        int econom = alltaxD - alltaxR;
                        System.out.println("Ekonomiya:" + econom + " rublei");
                    }
                }
                default -> System.out.println("Takoi operacii net");
            }
        }
        System.out.println("End program!");
    }
}