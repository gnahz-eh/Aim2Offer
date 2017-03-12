/**
 * Created by Administrator on 2017/3/12.
 */
public class AddTwoNumbers {

    public int add(int num1, int num2) {
        int sum = 0, carry = 0;

        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        } while (num2 != 0);
        return num1;
    }

    public static void main(String[] args) {
        AddTwoNumbers a = new AddTwoNumbers();
        System.out.println(a.add(5,-6));
    }
}
