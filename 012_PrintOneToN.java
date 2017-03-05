/**
 * Created by Administrator on 2017/3/5.
 */
public class PrintOneToN {

//    public void printOneToMaxOfNDigits(int n) {
//        if (n <= 0)
//            return;
//        char[] number = new char[n+1];
//        for (int i = 0; i < n + 1; i++) number[i] = '0';
//        while (!increment(number)) {
//            printNumber(number);
//            System.out.println();
//        }
//    }
//
//    public boolean increment(char[] number) {
//        boolean isOverFlow = false;
//        int len = number.length;
//        int flag = 0;
//        for (int i = len - 1; i >= 0; --i) {
//
//            if (i == 0 && flag == 1) {
//                isOverFlow = true;
//                return isOverFlow;
//            }
//            int sum = number[i] - '0' + flag;
//            if (i == len - 1)
//                sum += 1;
//
//            number[i] = (char)(sum % 10 + '0');
//            flag = sum / 10;
//        }
//        return isOverFlow;
//    }
//
//    public void printNumber(char[] number) {
//        int len = number.length;
//        int i = 0;
//        while (number[i] == '0') ++i;
//        for (; i < len; i++)
//            System.out.print(number[i]);
//    }

    public void printOneToMaxOfNDigits(int n) {
        if (n <= 0)
            return;
        char[] number = new char[n];
        for (int i = 0; i < n; i++) number[i] = '0';
        while (!increment(number)) {
            printNumber(number);
            System.out.println();
        }
    }

    public boolean increment(char[] number) {
        boolean isOverFlow = false;
        int len = number.length;
        int flag = 0;
        for (int i = len - 1; i >= 0; --i) {
            int sum = number[i] - '0' + flag;
            if (i == len - 1)
                sum += 1;
            number[i] = (char)(sum % 10 + '0');
            flag = sum / 10;
            if (i == 0 && flag == 1) {
                isOverFlow = true;
                break;
            }
        }
        return isOverFlow;
    }

    public void printNumber(char[] number) {
        int len = number.length;
        int i = 0;
        while (number[i] == '0') ++i;
        for (; i < len; i++)
            System.out.print(number[i]);
    }

    public static void main(String[] args) {
        PrintOneToN p = new PrintOneToN();
        p.printOneToMaxOfNDigits(3);
    }
}
