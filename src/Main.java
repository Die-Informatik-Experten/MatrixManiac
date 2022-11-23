import control.MatrixController;
import model.Matrix;
import model.QuadratischeMatrix;
import view.MyIO;

public class Main
{
    public static void main (String[] args)
    {
//        testeMatrix();
        zaubern();
    }


    private static void testeMatrix()
    {
        Matrix A = MatrixController.getInstance().erzeuge(2, 2);
        MatrixController.getInstance().befuelleMatrix(A);
        MyIO.ausgabe(A.toString());

        Matrix B = MatrixController.getInstance().erzeuge(2, 3);
        MatrixController.getInstance().befuelleMatrix(B, 10.5f);
        MyIO.ausgabe(B.toString());

//        Matrix C = MatrixController.getInstance().addiere(A, B);
//        MyIO.ausgabe(C.toString());

        Matrix D = MatrixController.getInstance().multipliziere(A, B);
        MyIO.ausgabe(D.toString());

        Matrix E = MatrixController.getInstance().transponieren(B);
        MyIO.ausgabe(E.toString());

        QuadratischeMatrix F = MatrixController.getInstance().erzeugeIdentitaet(4);
        MyIO.ausgabe(F.toString());
    }

    private static void zaubern ()
    {
        Matrix A = new QuadratischeMatrix(2);
        QuadratischeMatrix B = (QuadratischeMatrix) A;
        Matrix C = new Matrix(2, 2);
        QuadratischeMatrix D = (QuadratischeMatrix) C;
    }
}