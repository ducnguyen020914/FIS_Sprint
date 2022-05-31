package fe;



public class Main {
    public static void main(String[] args) {
        Integer num1 = 0;
        Integer num2  = 0;
       num1 = ArrayUtils.app(num1,num2).min;
        num2 = ArrayUtils.app(num1,num2).max;
        System.out.println(num1 +"   "+ num2);
    }

}