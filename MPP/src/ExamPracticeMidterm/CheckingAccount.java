package ExamPracticeMidterm;

public class CheckingAccount extends Account{
    private String accoutId;
    private double balance;
    private double monthlyFee;

    @Override
    String getAccountId() {
        return accoutId;
    }

    public double getBalance(){
        return this.balance;
    }

    @Override
    double computeUpdatedBalance() {
        return balance - monthlyFee;
    }

    public CheckingAccount(String accoutId,double monthlyFee,double balance)
    {
        this.accoutId = accoutId;
        this.monthlyFee  = monthlyFee;
        this.balance = balance;
    }
}
