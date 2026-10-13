public class Scadere extends ExpresieComplexa{

    public Scadere(NumarComplex[] nrComplexe) {
        super(nrComplexe);
    }

    @Override
    protected NumarComplex ExecutaOperatie(NumarComplex n1, NumarComplex n2) {
        return n1.scadere(n2);
    }
}
