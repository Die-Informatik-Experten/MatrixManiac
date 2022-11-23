package control;

import model.Matrix;
import model.QuadratischeMatrix;
import util.MyUtil;

public final class MatrixController
{
    private static final MatrixController INSTANCE = new MatrixController();

    public static MatrixController getInstance ()
    {
        return INSTANCE;
    }


    private MatrixController ()
    {
    }


    public QuadratischeMatrix erzeuge (float[] elemente, int rang)
    {
        return new QuadratischeMatrix(elemente, rang);
    }


    public QuadratischeMatrix erzeuge (int rang)
    {
        return new QuadratischeMatrix(rang);
    }


    public Matrix erzeuge (float[] elemente, int zeilenRang, int spaltenRang)
    {
        return new Matrix(elemente, zeilenRang, spaltenRang);
    }


    public Matrix erzeuge (int zeilenRang, int spaltenRang)
    {
        return new Matrix(zeilenRang, spaltenRang);
    }


    /**
     * Diese Methode erzeugt eine Einheitsmatrix
     * @param rang
     * @return
     */
    public QuadratischeMatrix erzeugeIdentitaet (int rang)
    {
        QuadratischeMatrix A = this.erzeuge(rang);

        for (int i = 0; i < rang; i++)
        {
            A.setElement(i, i, 1);
        }

        return A;
    }

    /**
     * Diese Methode befuellt die uebergebene Matrix mit zufaelligen Zahlen
     *
     * @param matrix
     */
    public void befuelleMatrix (Matrix matrix)
    {
        for (int zeile = 0; zeile < matrix.getZeilenRang(); zeile++)
        {
            for (int spalte = 0; spalte < matrix.getSpaltenRang(); spalte++)
            {
                matrix.setElement(zeile, spalte, MyUtil.erzeugeZufallsZahl());
            }
        }
    }

    /**
     * Diese Methode befuellt die uebergebene Matrix mit zufaelligen
     * Zahlen die kleiner als die Uebergebene Grenze sind und >= 0
     *
     * @param matrix
     * @param bound
     */
    public void befuelleMatrix (Matrix matrix, float bound)
    {
        for (int zeile = 0; zeile < matrix.getZeilenRang(); zeile++)
        {
            for (int spalte = 0; spalte < matrix.getSpaltenRang(); spalte++)
            {
                matrix.setElement(zeile, spalte, MyUtil.erzeugeZufallsZahl(bound));
            }
        }
    }


    public Matrix addiere (Matrix A, Matrix B) throws IllegalArgumentException
    {
        if (A.getZeilenRang() != B.getZeilenRang() || A.getSpaltenRang() != B.getSpaltenRang())
        {
            throw new IllegalArgumentException();
        } else
        {
            Matrix C = erzeuge(A.getZeilenRang(), A.getSpaltenRang());

            for (int zeile = 0; zeile < A.getZeilenRang(); zeile++)
            {
                for (int spalte = 0; spalte < B.getSpaltenRang(); spalte++)
                {
                    C.setElement(zeile, spalte, (A.getElement(zeile, spalte) + B.getElement(zeile, spalte)));
                }
            }

            return C;
        }
    }


    /**
     * Diese Methode gibt das Produkt zweier Matrizen zurueck.
     *
     * @param A
     * @param B
     * @return
     * @throws IllegalArgumentException
     */
    public Matrix multipliziere (Matrix A, Matrix B) throws IllegalArgumentException
    {
        if (A.getSpaltenRang() != B.getZeilenRang())
        {
            throw new IllegalArgumentException();
        }
        else
        {
            Matrix C = erzeuge(A.getZeilenRang(), B.getZeilenRang());

            for (int zeile = 0; zeile < B.getZeilenRang(); zeile++)
            {
                for (int spalte = 0; spalte < A.getSpaltenRang(); spalte++)
                {
                    for (int j = 0; j < A.getSpaltenRang(); j++)
                    {
                        C.setElement(zeile, spalte, C.getElement(zeile, spalte) + (A.getElement(zeile, j) * B.getElement(j, spalte)));
                    }
                }
            }
            return C;
        }
    }


    /**
     * Diese Methode gibt eine transponierte Matrix zurueck
     *
     * @param A
     * @return
     */
    public Matrix transponieren (Matrix A)
    {
        Matrix B = erzeuge(A.getSpaltenRang(), A.getZeilenRang());

        for (int zeile = 0; zeile < A.getZeilenRang(); zeile++)
        {
            for (int spalte = 0; spalte < A.getSpaltenRang(); spalte++)
            {
                B.setElement(spalte, zeile, A.getElement(zeile, spalte));
            }
        }

        return B;
    }
}
