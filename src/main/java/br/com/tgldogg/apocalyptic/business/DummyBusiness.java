package br.com.tgldogg.apocalyptic.business;

@Component
public class DummyBusiness {

    private static final int NUMBER_OF_CHARACTERS = 256;
    private static final int INPUT_MAX_SIZE = 1_000_000;

    public boolean isStringPalindromeAnagram(final String str) {
        checkInputSize(str);
        checkInputIsMadeOfLetters(str);

        final int[] count = new int[NUMBER_OF_CHARACTERS];

        // For each character in input strings, increment count in the corresponding
        // count array
        for (int i = 0; i < str.length(); i++)
            count[str.charAt(i)]++;

        // Count odd occurring characters, there can be a maximum of one.
        int odds = 0;
        for (int i = 0; i < count.length; i++) {
            if (isOdd(count[i]))
                odds++;

            if (odds > 1)
                return false;
        }

        return true;
    }

    private void checkInputSize(final String str) {
        if (str.length() > INPUT_MAX_SIZE) {
            throw new RuntimeException("Input size must be lower than " + INPUT_MAX_SIZE);
        }
    }

    private void checkInputIsMadeOfLetters(final String str) {
        final boolean allLetters = str.chars().allMatch(Character::isLetter);

        if (!allLetters) {
            throw new RuntimeException("Input must be formed by letters.");
        }
    }

    private boolean isOdd(final int number) {
        return (number & 1) != 0;
    }
}
