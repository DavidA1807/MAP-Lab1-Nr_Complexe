public class ExpressionFactory {
    private static ExpressionFactory instance = new ExpressionFactory();
    public ExpressionFactory() {}
    public static ExpressionFactory getInstance()
    {
        return instance;
    }
    public ExpresieComplexa creeazaExpresie(Operatii operatie, NumarComplex[] numere)
    {
        switch(operatie)
        {
            case ADUNARE:
                return new Adunare(numere);
            case SCADERE:
                return new Scadere(numere);
            case INMULTIRE:
                return new Inmultire(numere);
            case IMPARTIRE:
                return new Impartire(numere);
            default:
                return null;
        }
    }
}
