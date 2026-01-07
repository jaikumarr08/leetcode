class Solution {
    public int myAtoi(String s) {
        int i = 0;
        int n = s.length();
        int sign = 1;
        int num = 0;

        // 1️⃣ Skip leading spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // 2️⃣ Check sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // 3️⃣ Read digits
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // 4️⃣ Overflow check
            if (num > Integer.MAX_VALUE / 10 ||
               (num == Integer.MAX_VALUE / 10 && digit > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            num = num * 10 + digit;
            i++;
        }

        return num * sign;
    }
}
