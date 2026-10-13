public class SimpleExpressionParser implements ParsareExpresie{
    @Override
    public ExpresieComplexa parseaza(String text) {
        if (text == null || text.trim().isEmpty())
        {
            throw new IllegalArgumentException("no arguments.");
        }
        String[] elemente = text.split(" ");

        if (elemente[0].equals("+") || elemente[0].equals("-") || elemente[0].equals("*") || elemente[0].equals("/")) {
            throw new IllegalArgumentException("the expression starts with an operator.");
        }

        if (elemente.length % 2 == 0) {
            throw new IllegalArgumentException("the expression ends with an operator or an operator is missing.");
        }

        for (int i = 1; i < elemente.length; i += 2) {
            String op = elemente[i];

            if (op.contains("i") || op.contains("j")) {
                throw new IllegalArgumentException("two operators in a row or missing operator.");
            }
            if (!op.equals("+") && !op.equals("-") && !op.equals("*") && !op.equals("/")) {
                throw new IllegalArgumentException("an unknown operator.");
            }
        }
        String simbol = elemente[1];
        Operatii operatie = null;
        if(simbol.equals("+"))
            operatie = Operatii.ADUNARE;
        else if(simbol.equals("-")) {
            operatie = Operatii.SCADERE;
        } else if (simbol.equals("*")) {
            operatie = Operatii.INMULTIRE;
        } else if (simbol.equals("/")) {
            operatie = Operatii.IMPARTIRE;
        }
        NumarComplex[] numere = new NumarComplex[(elemente.length / 2) + 1];
        for(int i = 0; i < elemente.length; i += 2)
            try{
                numere[i / 2] = extrageNumar(elemente[i]);
            } catch(Exception e)
            {
                throw new IllegalArgumentException("format incorect");
            }

        return ExpressionFactory.getInstance().creeazaExpresie(operatie, numere);
    }
    private NumarComplex extrageNumar(String text) {
        text = text.replace("+i", "+1i").replace("-i", "-1i");
        text = text.replace("*i", "").replace("i", "");
        String[] parti;
        if (text.contains("+")) {
            parti = text.split("\\+");
            return new NumarComplex(Double.parseDouble(parti[0]), Double.parseDouble(parti[1]));
        } else {
            int ultimulMinus = text.lastIndexOf('-');
            String real = text.substring(0, ultimulMinus);
            String imaginar = text.substring(ultimulMinus);
            return new NumarComplex(Double.parseDouble(real), Double.parseDouble(imaginar));
        }
    }
}
