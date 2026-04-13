import java.util.Scanner;

import static java.lang.Math.max;

public class TaxSelect {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isEndWhile = true;
        String answer;
        int expenses = 0;
        int income = 0;
        int answerSum;
        int sumTax15;
        int sumTax6;
        int sumSavings;

        while (isEndWhile) {
            System.out.println("Выберите операцию и введите её номер:\n" +
                    "1. Добавить новый доход\n" +
                    "2. Добавить новый расход\n" +
                    "3. Выбрать систему налогообложения");
                answer = scanner.nextLine();
            switch (answer) {
                case "1":
                    System.out.println("Введите сумму дохода:");
                    income += Integer.parseInt(scanner.nextLine());
                    break;
                case "2":
                    System.out.println("Введите сумму расхода:");
                    expenses += Integer.parseInt(scanner.nextLine());
                    break;
                case "3":
                    sumTax15 = taxEarningsMinusSpendings(income,expenses);
                    sumTax6 = taxEarnings(income);
                    sumSavings = (sumTax15 > sumTax6) ? sumTax15 - sumTax6 : sumTax6 - sumTax15;
                    if (sumTax15 == sumTax6) {
                        System.out.printf("Можете выбрать любую систему налогообложения\n" +
                                "Ваш налог составит: %d рублей\n" ,sumTax6);
                    } else if (sumTax15 > sumTax6) {
                        System.out.printf("Мы советуем вам УСН доходы\n" +
                                "Ваш налог составит: %d рублей\n" +
                                "Налог на другой системе: %d рублей\n" +
                                "Экономия: %d рублей\n",sumTax6,sumTax15,sumSavings);
                    } else {
                        System.out.printf("Мы советуем вам УСН доходы минус расходы\n" +
                                "Ваш налог составит: %d рублей\n" +
                                "Налог на другой системе: %d рублей\n" +
                                "Экономия: %d рублей\n",sumTax15,sumTax6,sumSavings);

                    }
                    break;
                case "end":
                    isEndWhile = false;
                    break;
            }

        }
    }
    public static int taxEarningsMinusSpendings (int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        return max(tax, 0);
    };
    public static int taxEarnings (int earnings) {
        int tax = earnings * 6 / 100;
        return max(tax, 0);
    };
}
