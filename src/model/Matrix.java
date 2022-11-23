package model;

public class Matrix
{
    private float[][] matrix = null;

    /**
     * Dieser Konstruktor erzeugt aus einem 1d-Array eine nxm-Matrix.
     * Die Matrix wird aus den Elementen Zeilen orientiert befuellt.
     *
     * @param elemente    Array mit float Werten (length = zeilenRang * spaltenRang)
     * @param zeilenRang  >= 1
     * @param spaltenRang >= 1
     */
    public Matrix (float[] elemente, int zeilenRang, int spaltenRang) throws IllegalArgumentException
    {
        // ueberpruefe Eingabe Werte
        if (zeilenRang < 1 || spaltenRang < 1 || elemente.length != zeilenRang * spaltenRang)
        {
            throw new IllegalArgumentException();
        }
        else
        {
            this.matrix = new float[zeilenRang][spaltenRang];
            for (int zeile = 0; zeile < zeilenRang; zeile++)
            {
                for (int spalte = 0; spalte < spaltenRang; spalte++)
                {
                    this.matrix[zeile][spalte] = elemente[zeile * zeilenRang + spalte];
                }
            }
        }
    }

    /**
     * Dieser Konstruktor erzeugt eine Nullmatrix vom Rang nxm.
     *
     * @param zeilenRang >= 1
     * @param spaltenRang >= 1
     */
    public Matrix (int zeilenRang, int spaltenRang) throws IllegalArgumentException
    {
        if (zeilenRang < 1 || spaltenRang < 1)
        {
            throw new IllegalArgumentException();
        }
        else
        {
            this.matrix = new float[zeilenRang][spaltenRang];
        }
    }

    /**
     * Diese Methode setzt den Wert eines Elements auf den uebergebenen @param wert
     *
     * @param zeile
     * @param spalte
     * @param wert
     */
    public void setElement(int zeile, int spalte, float wert)
    {
        this.matrix[zeile][spalte] = wert;
    }

    /**
     * Diese Methode gibt den Wert eines Elements zurueck
     *
     * @param zeile
     * @param spalte
     * @return
     */
    public float getElement (int zeile, int spalte)
    {
        return this.matrix[zeile][spalte];
    }

    public int getZeilenRang()
    {
        return this.matrix.length;
    }


    public int getSpaltenRang()
    {
        return this.matrix[0].length;
    }

    @Override
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();

        for (int zeile = 0; zeile < this.getZeilenRang(); zeile++)
        {
            for (int spalte = 0; spalte < this.getSpaltenRang(); spalte++)
            {
                stringBuilder.append(String.format("%7.2f\t", this.getElement(zeile, spalte)));
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

}
