import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Sound s = new Sound();

        System.out.println(
                "The original array of samples is " + Arrays.toString(s.getSamples()));

        s.trimSilenceFromBeginning();
        System.out.println(
                "The new array of samples is " + Arrays.toString(s.getSamples()));
        System.out.println(
                "The length of the new array should be 12 and is "
                        + s.getSamples().length);
    }
}