package util;

import java.util.Random;

public class MyUtil
{

    public static float erzeugeZufallsZahl ()
    {
        return new Random().nextBoolean() ? new Random().nextFloat() : (new Random().nextFloat() * (-1));
    }


    public static float erzeugeZufallsZahl (float bound)
    {
        return new Random().nextBoolean() ? new Random().nextFloat(bound) : (new Random().nextFloat(bound) * (-1));
    }
}
