package ThreadAndComparableAndComparator.MyPrimeThhread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MyPrimeThread implements Runnable{
    private int start;
    private int end;

    List<Integer> primes;

    public List<Integer> getPrimes() {
        return primes;
    }

    public MyPrimeThread(int start, int end){
        this.start = start;
        this.end = end;
        primes = new ArrayList<>();
    }

    @Override
    public void run() {
       Object[] arr = findPrimeNumbers().toArray();
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private List<Integer> findPrimeNumbers(){
        boolean flag = true;
        for(int i = this.start+1;i <= end;i++)
        {
            if(isPrime(i))
               primes.add(i);

        }
        return this.primes;
    }

    public Comparator comparator = new Comparator(){
        @Override
        public int compare(Object o1, Object o2) {
            return 0;
        }


    };

    private boolean  isPrime (int anInt){
        for(int m = anInt+1;m < Math.sqrt(anInt);m++)
        {
            if(anInt%m == 0 && m!= anInt) {
                return false;
            }

        }
        return true;
    }
}
