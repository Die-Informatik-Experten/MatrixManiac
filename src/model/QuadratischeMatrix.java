package model;

public class QuadratischeMatrix extends Matrix
{
    /**
     * Dieser Konstruktor erzeugt aus einem 1d-Array eine nxm-Matrix.
     * Die Matrix wird aus den Elementen Zeilen orientiert befuellt.
     *
     * @param elemente
     * @param rang
     */
    public QuadratischeMatrix (float[] elemente, int rang)
    {
        super(elemente, rang, rang);
    }


    /**
     * Dieser Konstruktor erzeugt eine Nullmatrix vom Rang nxn.
     *
     * @param rang
     */
    public QuadratischeMatrix (int rang)
    {
        super(rang, rang);
    }
}
