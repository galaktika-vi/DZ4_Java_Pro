public enum Alphabet {
    A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z;

    public int getLetterNumber() {
        return this.ordinal() + 1;
    }

    public static void main(String[] args) {
        System.out.println("Letter K has number: " + Alphabet.K.getLetterNumber());
        System.out.println("Letter O has number: " + Alphabet.O.getLetterNumber());
        System.out.println("Letter Z has number: " + Alphabet.Z.getLetterNumber());
    }
}
