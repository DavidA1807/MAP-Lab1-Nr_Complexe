public class Inmultire extends ExpresieComplexa{
    public Inmultire(NumarComplex[] nrComplexe) {
        super(nrComplexe);
    }

    @Override
    protected NumarComplex ExecutaOperatie(NumarComplex n1, NumarComplex n2) {
        return n1.inmultire(n2);
    }
}
