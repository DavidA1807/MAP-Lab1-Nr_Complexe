public abstract class ExpresieComplexa {
    protected NumarComplex[] nrComplexe;

    public ExpresieComplexa(NumarComplex[] nrComplexe) {
        this.nrComplexe = nrComplexe;
    }
    protected abstract NumarComplex ExecutaOperatie(NumarComplex n1, NumarComplex n2);
    public NumarComplex executa()
    {
        NumarComplex rezultat = nrComplexe[0];
        for(int i = 1; i < nrComplexe.length; i++)
            rezultat = ExecutaOperatie(rezultat, nrComplexe[i]);
        return rezultat;
    }
}
