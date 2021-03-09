public class IntegerDivision {
    private StringBuilder result;
    private StringBuilder quotient;

    public String getDivisionResult(int dividend, int divisor) {
        quotient = new StringBuilder();
        result = new StringBuilder();
        if (dividend < divisor) {
            zeroResultToViewFormat(dividend,0);
            quotient.append(dividend/divisor);
            convertResultToViewFormat(dividend, divisor);
            return result.toString();
        }
        String[] digitsOfDividend = String.valueOf(dividend).split("");
        StringBuilder subRemainder = new StringBuilder();

        for (int i = 0; i < digitsOfDividend.length; i++) {
            subRemainder.append(Integer.parseInt(digitsOfDividend[i]));
            int digit = Integer.parseInt(subRemainder.toString());
            int mod;
            int multiplyResult;
            if (digit >= divisor) {
                mod = digit%divisor;
                multiplyResult = digit/divisor * divisor;
                convertDivisionProcessToViewFormat(i, digit, multiplyResult);

                quotient.append(digit/divisor);
                subRemainder.replace(0, subRemainder.length(), String.valueOf(mod));
            }
            if (i == digitsOfDividend.length - 1) {
                result.append(String.format("%" + (i + 2) + "s", subRemainder.toString())).append("\n");
            }
        }
        convertResultToViewFormat(dividend, divisor);
        return result.toString();
    }

    private void convertResultToViewFormat(int dividend, int divisor) {
        int[] index = new int[3];
        for (int i = 0, j =0; i < result.length(); i++) {
            if (result.charAt(i) == '\n') {
                index[j] = i;
                j++;
            }
            if (j == 3)
                break;
        }

        int tabulation = (calculateNumberOfDigits(dividend) + 1 - index[0]);
        result.insert(index[2], assembleString(tabulation, ' ') + "|" + quotient.toString());
        result.insert(index[1], assembleString(tabulation, ' ') + "|" + assembleString(quotient.length(), '-'));
        result.insert(index[0], "|" + divisor);
        result.replace(1, index[0], String.valueOf(dividend));
    }

    private void convertDivisionProcessToViewFormat(int iteration, int digit, int multiplyResult) {
        String lastRemainder = String.format("%" + (iteration + 2) + "s", "_" + String.valueOf(digit));
        result.append(lastRemainder).append("\n");

        String multiplication = String.format("%" + (iteration + 2) + "d", multiplyResult);
        result.append(multiplication).append("\n");

        int tabulation = lastRemainder.length() - calculateNumberOfDigits(multiplyResult);
        result.append(makeDevider(digit, tabulation)).append("\n");
    }

    private void zeroResultToViewFormat(int digit, int multiplyResult) {
        String lastRemainder = String.format("%s", "_" + String.valueOf(digit));
        result.append(lastRemainder).append("\n");

        String multiplication = String.format("%" + 3 + "d", multiplyResult);
        result.append(multiplication).append("\n").append(makeDevider(0,3)).append("\n");
    }

    private int calculateNumberOfDigits(int someNumber) {
        return (int) Math.log10(someNumber) + 1;
    }

    private String assembleString(int numberOfSymbols, char symbol) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < numberOfSymbols; i++) {
            string.append(symbol);
        }
        return string.toString();
    }

    private String makeDevider(int remainder, int tabulation) {
        return assembleString(tabulation, ' ') + assembleString(calculateNumberOfDigits(remainder), '-');
    }
 }

