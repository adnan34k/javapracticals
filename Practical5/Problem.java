public class Problem {
    public static void main(String[] args) {

        String[] arr = {"2022bit055", "2022bcs001", "2022bec023", "sggsit023","2022bit123"};
        int ans = check(arr);
        System.out.println("Count of valid patterns: " + ans);
    }

    public static int check(String[] arr) {
        // format available 2022bit, bcs, bec00x
        int count = 0; // substring

        for (int i = 0; i < arr.length; i++) {
            int j = 0;
            int k = 4; // Start from index 4 to check the letters
            int flag = 1; // Assume valid until proven otherwise
            String abc = arr[i];

            // function to check pattern: 4 digit number, 3 letters, 3 digits
            while (j < 4) {
                if (Character.isDigit(abc.charAt(j))) {
                    // Continue checking
                } else {
                    flag = 0;
                    break; // Break if a non-digit is encountered
                }
                j++;
            }

            while (k < 7) {
                if (Character.isLetter(abc.charAt(k))) {
                    // Continue checking
                } else {
                    flag = 0;
                    break; // Break if a non-letter is encountered
                }
                k++;
            }

            if (flag == 1) {
                count++;
            }
        }
        return count;
    }
}

