package aaaa;

import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class TestClass {

    public static void test1() {
        System.setProperty("http.agent", "chrome");
        String msg = "";
        int count = 0;
        String temp;
        try {
            URL url = new URL("https://coderbyte.com/api/challenges/json/age-counting");
            try {
                URLConnection connection = url.openConnection();
                InputStream inputStream = connection.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                String str = "";
                while (null != (str = br.readLine())) {
                    msg = msg + str;
                }
            } catch (IOException ioEx) {
            }
        } catch (MalformedURLException malEX) {
        }
        String[] str = msg.split(" ");
        for (int i = 0; i < str.length; i++) {
            if (str[i].contains("age=") && str[i].endsWith(",")) {
                temp = str[i].substring(str[i].indexOf('=') + 1, str[i].indexOf(','));
                if (Integer.parseInt(temp) >= 50) {
                    count++;
                }
            } else if (str[i].contains("age=") && str[i].endsWith("\"}")) {
                temp = str[i].substring(str[i].indexOf('=') + 1, str[i].indexOf('}') - 1);
                if (Integer.parseInt(temp) >= 50) {
                    count++;
                }
                System.out.println(count);
            }
        }
    }


    public static boolean EvenPairs(String str) {
        List<Object> obj = new ArrayList<>();
        int num;
        String result = "N";
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i)) && (Integer.parseInt("" + str.charAt(i))) % 2 == 0) {
                result = "Y";
                obj.add(result);
            } else if (!Character.isDigit(str.charAt(i)))
                obj.add(" ");
            else if (Character.isDigit(str.charAt(i)) && (Integer.parseInt("" + str.charAt(i))) % 2 == 1) {
                result = "N";
                obj.add(result);
            }


        }
        boolean result2 = false;
        Outer:
        for (int b = 0; b < obj.size(); b++) {
            if (obj.get(b).equals(" ")) {
                continue;
            } else if (obj.get(b).equals("Y")) {
                result2 = true;
                if (obj.get(b + 1) != null && obj.get(b + 1).equals("Y")) {
                    result2 = true;
                    break Outer;
                } else if (obj.get(b + 1) != null && obj.get(b + 1).equals("N")) {
                    result2 = false;
                }
            }

        }
        System.out.println(obj);

        return result2;
    }

    public static String EvenPairs2(String str) {

        char[] chars = str.toCharArray();
        boolean firstPair = false;
        boolean secondPair = false;

        for (int i = 0; i < chars.length; i++) {

            if (!Character.isDigit(chars[i])) {
                firstPair = false;
                secondPair = false;
            } else if (Integer.valueOf(chars[i]) % 2 == 0) {
                if (!firstPair) firstPair = true;
                else secondPair = true;
            }
            if (firstPair && secondPair) break;
        }
        if (firstPair && secondPair) str = "true";
        else str = "false";

        return str;
    }

    public static void main(String[] args) {
        System.out.println(EvenPairs2("f09111111111111110r27i8e67"));
    }

}
