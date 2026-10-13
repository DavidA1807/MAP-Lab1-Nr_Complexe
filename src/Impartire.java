public class Impartire extends ExpresieComplexa{
    public Impartire(NumarComplex[] nrComplexe) {
        super(nrComplexe);
    }

    @Override
    protected NumarComplex ExecutaOperatie(NumarComplex n1, NumarComplex n2) {
        return n1.impartire(n2);
    }
}
