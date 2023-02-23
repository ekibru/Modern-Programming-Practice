package ExamPracticeMidterm;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private List<Account> accounts;

    public String getName(){
        return this.name;
    }

    public Employee(String name)
    {
        this.name = name;
        accounts = new ArrayList<>();
    }
    public void addAccount(Account account)
    {
        accounts.add(account);
    }

    public double computeUpdatedBalanceSum(){
        double sum = 0;
        for(Account a : accounts)
        {
            sum += a.computeUpdatedBalance();
        }
//        System.out.println(sum);
        return sum;
    }
}
