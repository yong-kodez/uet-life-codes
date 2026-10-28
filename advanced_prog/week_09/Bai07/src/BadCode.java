import java.util.*;

public class BadCode {
  private int bad_variable_name = 10;

  public int calculate(int a,int b){ 
    int sum=a+b;

    if(sum > 10) 
    {
      return sum;
    }

    System.out.println("Day la mot dong log rat dai duoc viet co y vuot qua gioi han do dai ky tu toi da");

    return 0;
  }
}
