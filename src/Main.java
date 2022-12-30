import java.util.Scanner;

public class Main {

    public static void printResult(int[] totalProducts, String[] products, int[] prices, int sumProducts) {
        System.out.println("Ваша корзина:");
        for (int i = 0; i < totalProducts.length; i++) {
            if (totalProducts[i] != 0) {
                System.out.println(" " + products[i] + " " + totalProducts[i] + " шт "
                        + prices[i] + " руб/шт," + (totalProducts[i] * prices[i]) + " руб. в сумме");
            }
        }
        System.out.println("Итого: " + sumProducts + " руб.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] products = {"Хлеб", "Яблоки", "Молоко"};
        int[] prices = {100, 200, 300};

        int[] totalProducts = new int[3];
        int sumProducts = 0;

        System.out.println("Список возможных товаров для покупки:");

        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i] + " " + prices[i] + " руб/шт.");
        }

        while (true) {
            System.out.println("Выберите номер товара и количество или введите end для завершения");
            String input = scanner.nextLine();

            if (input.equals("end")) {
                printResult(totalProducts, products, prices, sumProducts);
                break;
            }

            String[] choice = input.split(" ");

            if (choice.length != 2) {
                System.out.println("ОШИБКА. Требуется ввести номер товара и количество.");
                System.out.println();
                continue;
            }
            int productNumber;
            int productCount;

            try {
                productNumber = Integer.parseInt(choice[0]);
                productCount = Integer.parseInt(choice[1]);

            } catch (NumberFormatException exception) {
                System.out.println("ОШИБКА. Вы ввели не число!");
                System.out.println();
                continue;
            }

            if (productNumber > products.length || productNumber <= 0) {
                System.out.println("ОШИБКА. Введите верно номер товара!");
                System.out.println();
                continue;
            } else {
                productNumber -= 1;
            }

            if (productCount <= 0) {
                System.out.println("ОШИБКА. Введите верно колличество товара!");
                System.out.println();
                continue;
            }

            totalProducts[productNumber] += productCount;

            sumProducts += (productCount * prices[productNumber]);
        }

    }

}
