import java.util.Scanner;

public class CreditCard {
    private String cardNumber;
    private int pinCode;
    private double balance;
    private double creditLimit;
    private double debt;

    public CreditCard(String cardNumber, int pinCode) {
        this.cardNumber = cardNumber;
        this.pinCode = pinCode;
        this.balance = 0;
        this.creditLimit = 0;
        this.debt = 0;
    }

    public boolean transaction(int pinCode, double amount, boolean isDeposit) {
        if (this.pinCode == pinCode) {
            if (amount > 0) {
                if (isDeposit) {
                    this.debt = Math.max(0, this.debt - amount);
                    this.balance += Math.max(0, amount - this.debt);
                } else {
                    double availableAmount = this.balance + this.creditLimit - this.debt;
                    if (amount <= availableAmount) {
                        this.balance -= amount;
                    } else {
                        System.out.println("Превышен кредитный лимит. Вам доступна сумма: " + availableAmount);
                        return false;
                    }
                }
                return true;
            } else {
                System.out.println("Ошибка: сумма транзакции должна быть положительной.");
                return false;
            }
        } else {
            System.out.println("Неверный пин-код. Операция отклонена.");
            return false;
        }
    }

    public void setCreditLimit(double creditLimit) {
        if (creditLimit >= 0) {
            this.creditLimit = creditLimit;
        } else {
            System.out.println("Ошибка: кредитный лимит не может быть отрицательным.");
        }
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public double getBalance() {
        return balance;
    }

    public double getDebt() {
        return debt;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public int getPinCode() {
        return pinCode;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите номер карты: ");
        String cardNumber = scanner.next();

        System.out.print("Введите пин-код: ");
        int pinCode = scanner.nextInt();

        CreditCard card = new CreditCard(cardNumber, pinCode);

        System.out.print("Введите кредитный лимит: ");
        double creditLimit = scanner.nextDouble();
        card.setCreditLimit(creditLimit);

        System.out.print("Введите пин-код для зачисления средств: ");
        int depositPin = scanner.nextInt();

        if (depositPin == pinCode) {
            System.out.print("Введите сумму для зачисления: ");
            double depositAmount = scanner.nextDouble();
            card.transaction(pinCode, depositAmount, true);
        } else {
            System.out.println("Неверный пин-код. Операция зачисления средств отклонена.");
        }

        System.out.print("Введите пин-код для снятия средств: ");
        int withdrawPin = scanner.nextInt();

        while (withdrawPin == pinCode) {
            System.out.print("Введите сумму для снятия: ");
            double withdrawAmount = scanner.nextDouble();

            card.transaction(pinCode, withdrawAmount, false);

            System.out.print("Желаете продолжить снятие средств? (да/нет): ");
            String continueWithdraw = scanner.next();
            if (!continueWithdraw.equalsIgnoreCase("да")) {
                break;
            }
        }

        System.out.println("Номер карты: " + card.getCardNumber());
        System.out.println("Текущий баланс: " + card.getBalance());
        System.out.println("Кредитный лимит: " + card.getCreditLimit());

        SimpleATM atm = new SimpleATM(10000);

        System.out.print("Введите пин-код для банкомата: ");
        int atmPinCode = scanner.nextInt();

        if (atm.validateCard(card, atmPinCode)) {
            System.out.println("Выберите операцию: ");
            System.out.println("1. Проверить баланс");
            System.out.println("2. Снять деньги");
            System.out.println("3. Положить деньги");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    double balance = atm.checkBalance(card);
                    System.out.println("Текущий баланс: " + balance);
                    break;
                case 2:
                    System.out.print("Введите сумму для снятия: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (atm.withdrawCash(card, atmPinCode, withdrawAmount)) {
                        System.out.println("Снятие успешно выполнено.");
                    }
                    break;
                case 3:
                    System.out.print("Введите сумму для внесения: ");
                    double depositAmount = scanner.nextDouble();
                    if (atm.depositCash(card, atmPinCode, depositAmount)) {
                        System.out.println("Внесение успешно выполнено.");
                    }
                    break;
                default:
                    System.out.println("Неверный выбор операции.");
                    break;
            }
        } else {
            System.out.println("Неверный пин-код для банкомата. Операция отклонена.");
        }

        scanner.close();
    }
}

class SimpleATM {
    private double cashAmount;

    public SimpleATM(double initialCashAmount) {
        this.cashAmount = initialCashAmount;
    }

    public boolean validateCard(CreditCard card, int pinCode) {
        return card.getPinCode() == pinCode;
    }

    public double checkBalance(CreditCard card) {
        return card.getBalance();
    }

    public boolean withdrawCash(CreditCard card, int pinCode, double amount) {
        if (validateCard(card, pinCode)) {
            if (amount <= cashAmount) {
                if (card.transaction(pinCode, amount, false)) {
                    cashAmount -= amount;
                    return true;
                } else {
                    System.out.println("Недостаточно средств на карте.");
                }
            } else {
                System.out.println("В банкомате недостаточно денег.");
            }
        } else {
            System.out.println("Неверный пин-код. Операция отклонена.");
        }
        return false;
    }

    public boolean depositCash(CreditCard card, int pinCode, double amount) {
        if (validateCard(card, pinCode)) {
            if (card.transaction(pinCode, amount, true)) {
                cashAmount += amount;
                return true;
            } else {
                System.out.println("Ошибка при зачислении на карту.");
            }
        } else {
            System.out.println("Неверный пин-код. Операция отклонена.");
        }
        return false;
    }
}

