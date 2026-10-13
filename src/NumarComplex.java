public class NumarComplex {
    private double real;
    private double img;

    public NumarComplex(double real, double img)
    {
        this.real = real;
        this.img = img;
    }
    public NumarComplex adunare(NumarComplex nr)
    {
        double realNou = this.real + nr.real;
        double imgNou = this.img + nr.img;
        return new NumarComplex(realNou, imgNou);
    }
    public NumarComplex scadere(NumarComplex nr)
    {
        double realNou = this.real - nr.real;
        double imgNou = this.img - nr.img;
        return new NumarComplex(realNou, imgNou);
    }
    public NumarComplex inmultire(NumarComplex nr)
    {
        double realNou = (this.real * nr.real) - (this.img * nr.img);
        double imgNou = this.real * nr.img + this.img * nr.real;
        return new NumarComplex(realNou, imgNou);
    }
    public NumarComplex impartire(NumarComplex nr) {
        double numitor = (nr.real * nr.real) + (nr.img * nr.img);
        double realNou = ((this.real * nr.real) + (this.img * nr.img)) / numitor;
        double imaginarNou = ((this.img * nr.real) - (this.real * nr.img)) / numitor;
        return new NumarComplex(realNou, imaginarNou);
    }
    @Override
    public String toString()
    {
        if(img < 0)
            return real + " - " + Math.abs(img) + "*i";
        else
            return real + " + " + img + "*i";
    }
}
