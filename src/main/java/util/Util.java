package util;

public class Util {

    /**
     * Convert a string to title case
     * @param str input string
     * @return the string in title case
     */
    public static String toTitleCase(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        String temp = "";
        String[] strings = str.split(" ");

        for (String string : strings) {
           if (!string.isEmpty()) {
               temp += string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase() + " ";
           }
        }

        str = temp;
        return str;
    }
}
