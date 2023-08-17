import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите букву (A/B/C/D/E/F/G/H/I/J/K/L/M/N/O/P/Q/R/S/T/U/V/W/X/Y/Z): ");
        char inputLetter = scanner.next().charAt(0);

        Alphabet letter = null;

        switch (inputLetter) {
            case 'A':
                letter = Alphabet.A;
                break;
            case 'B':
                letter = Alphabet.B;
                break;
            case 'C':
                letter = Alphabet.C;
                break;
            case 'D':
                letter = Alphabet.D;
                break;
            case 'E':
                letter = Alphabet.E;
                break;
            case 'F':
                letter = Alphabet.F;
                break;
            case 'G':
                letter = Alphabet.G;
                break;
            case 'H':
                letter = Alphabet.H;
                break;
            case 'I':
                letter = Alphabet.I;
                break;
            case 'J':
                letter = Alphabet.J;
                break;
            case 'K':
                letter = Alphabet.K;
                break;
            case 'L':
                letter = Alphabet.L;
                break;
            case 'M':
                letter = Alphabet.M;
                break;
            case 'N':
                letter = Alphabet.N;
                break;
            case 'O':
                letter = Alphabet.O;
                break;
            case 'P':
                letter = Alphabet.P;
                break;
            case 'Q':
                letter = Alphabet.Q;
                break;
            case 'R':
                letter = Alphabet.R;
                break;
            case 'S':
                letter = Alphabet.S;
                break;
            case 'T':
                letter = Alphabet.T;
                break;
            case 'U':
                letter = Alphabet.U;
                break;
            case 'V':
                letter = Alphabet.V;
                break;
            case 'W':
                letter = Alphabet.W;
                break;
            case 'X':
                letter = Alphabet.X;
                break;
            case 'Y':
                letter = Alphabet.Y;
                break;
            case 'Z':
                letter = Alphabet.Z;
                break;
            default:
                System.out.println("Неправильный ввод.");
                break;
        }

        if (letter != null) {
            System.out.println("Порядковый номер буквы: " + letter.ordinal());
        }

        scanner.close();
    }
}
