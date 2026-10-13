public class Adunare extends ExpresieComplexa{

    public Adunare(NumarComplex[] nrComplexe) {
        super(nrComplexe);
    }

    @Override
    protected NumarComplex ExecutaOperatie(NumarComplex n1, NumarComplex n2) {
        return n1.adunare(n2);
    }
}
