package tbz.m326.StockManagementSystem.Controller;

public class ValidateCC {

    public static boolean validateCreditCardNumber(String str) {

        if (str.length() == 15){
            int[] ints = new int[str.length()];
            for (int i = 0; i < str.length(); i++) {
                ints[i] = Integer.parseInt(str.substring(i, i + 1));
            }
            for (int i = ints.length - 2; i >= 0; i = i - 2) {
                int j = ints[i];
                j = j * 2;
                if (j > 9) {
                    j = j % 10 + 1;
                }
                ints[i] = j;
            }
            int sum = 0;
            for (int i = 0; i < ints.length; i++) {
                sum += ints[i];
            }
            if (sum % 10 == 0) {
                return true;
            } else {
                return false;
            }
        }
        else {
            return false;
        }
    }
}

