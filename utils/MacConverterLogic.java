package utils;

public class MacConverterLogic {

    public static String MacToDot(String input) {
        String mac_address = stripHex(input);
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < mac_address.length()) {
            if (i % 4 == 0 & i != 0) result.append('.');
            result.append(mac_address.charAt(i));
            i++;
        }
        return result.toString();
    }

    // so expensive function, but still correct, union 2 functions = clearing format + hex
    // it can be as binary or octal, nobody cares (don't checking format, but await it)
    static String hex = "0123456789ABCDEF";
    public static String stripHex(String input) {
        input = input.toUpperCase().trim();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
            for (int h = 0; h < hex.length(); h++)
                if (letter == hex.charAt(h))
                    result.append(letter);
        }
        return result.toString();
    }
}
