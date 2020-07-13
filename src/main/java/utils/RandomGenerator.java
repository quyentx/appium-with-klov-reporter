package utils;

public class RandomGenerator {

    private static final String ALPHABET_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnoupqrstuvxyz";
    private static final String NUMERIC_STRING = "123456789";

    public static String randString(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int)(Math.random()* ALPHABET_STRING.length());
            builder.append(ALPHABET_STRING.charAt(character));
        }
        return builder.toString();
    }

    public static String randPhoneNumb(){
        int count = 7;
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character =(int)(Math.random()* NUMERIC_STRING.length());
            builder.append(NUMERIC_STRING.charAt(character));
        }
        return "091"+builder.toString();
    }

    public static String randPaymentCode(String service){
        int count = 7;
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character =(int)(Math.random()* NUMERIC_STRING.length());
            builder.append(NUMERIC_STRING.charAt(character));
        }
        return service+builder.toString();
    }

    public static String randNumb(int count){
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character =(int)(Math.random()* NUMERIC_STRING.length());
            builder.append(NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

    public static String randEmail(){
        int count = 8;
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character =(int)(Math.random()* ALPHABET_STRING.length());
            builder.append(ALPHABET_STRING.charAt(character));
        }
        return builder.toString()+"@testmail.tmn";
    }

    public static String randPassId(){
        int count = 7;
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character =(int)(Math.random()* NUMERIC_STRING.length());
            builder.append(NUMERIC_STRING.charAt(character));
        }
        return "B"+builder.toString();
    }
}
