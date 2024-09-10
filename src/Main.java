public class Main {

    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.deposit(15000);

        while (true) {
            try {
                account.withdraw(6000);
                System.out.println("Withdrawn 6000KGS. Remaining credit: " + account.getAmount() + "KGS");
            } catch (LimitException e) {
                System.out.println(e.getMessage());
                try {
                    account.withdraw(e.getRemainingAmount());
                    System.out.println("Withdrawn remaining credit: " + e.getRemainingAmount() + "KGS");
                } catch (LimitException ex) {
                    throw new RuntimeException(ex);
                }
                break;
            }
        }
    }

}