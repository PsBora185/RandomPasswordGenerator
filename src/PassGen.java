import java.util.Random;

public class PassGen {

    public static final  String LowerCase = "abcdefghijklmnopqrstuvwxyz";
    public static final  String UpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final  String Numbers = "1234567890";
    public static final  String Symbols = "~!@#$%^&*()_-+={}[];:,.<>/?";

    private final Random random;

    public PassGen(){
        random = new Random();
    }

    public String generate(int length, boolean incUpper,boolean incLower,boolean incNum,boolean incSym){
        StringBuilder passBuilder = new StringBuilder();
        String validChar = "";

        if (incUpper) validChar += UpperCase;
        if (incLower) validChar += LowerCase;
        if (incNum) validChar += Numbers;
        if (incSym) validChar += Symbols;

        // build password
        for (int i = 0; i < length; i++) {

            int idx = random.nextInt(validChar.length());

            passBuilder.append(validChar.charAt(idx));
        }
        return passBuilder.toString();
    }
}
