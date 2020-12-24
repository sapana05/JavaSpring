package com.techgig.women.test;

public class RandomString {
private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
public static String randomAlphaNumeric(String count) {
StringBuilder builder = new StringBuilder();
//while (count-- != 0) {
int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
builder.append(ALPHA_NUMERIC_STRING.charAt(character)+count.hashCode());
//}
return builder.toString();
}

}
