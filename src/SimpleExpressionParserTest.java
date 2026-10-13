import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleExpressionParserTest {
    @Test
    void testExempleBasic()
    {
        double epsilon = 0.0001;
        ParsareExpresie parser = new SimpleExpressionParser();
        ExpresieComplexa exp1 = parser.parseaza("50+100*i + 70+60*i + 30+40*i + 50+1*i");
        NumarComplex rez1 = exp1.executa();
        assertEquals(200, rez1.getReal(), epsilon);
        assertEquals(201, rez1.getImg(), epsilon);

        ExpresieComplexa exp2 = parser.parseaza("100+100*i + -50+50*i + 300-20*i + -146+70*i + 0+1*i");
        NumarComplex rez2 = exp2.executa();
        assertEquals(204, rez2.getReal(), epsilon);
        assertEquals(201, rez2.getImg(), epsilon);

        ExpresieComplexa exp3 = parser.parseaza("-100+82*i + 300-250*i + 204-250*i");
        NumarComplex rez3 = exp3.executa();
        assertEquals(404, rez3.getReal(), epsilon);
        assertEquals(-418, rez3.getImg(), epsilon);

        ExpresieComplexa exp4 = parser.parseaza("1000+250*i - 582+50*i - 14-1*i");
        NumarComplex rez4 = exp4.executa();
        assertEquals(404, rez4.getReal(), epsilon);
        assertEquals(201, rez4.getImg(), epsilon);

        ExpresieComplexa exp5 = parser.parseaza("1000+0*i - 300+100*i - 200+100*i - 99+51*i - 100+51*i");
        NumarComplex rez5 = exp5.executa();
        assertEquals(301, rez5.getReal(), epsilon);
        assertEquals(-302, rez5.getImg(), epsilon);

        ExpresieComplexa exp6 = parser.parseaza("201+101*i * 1+i");
        NumarComplex rez6 = exp6.executa();
        assertEquals(100, rez6.getReal(), epsilon);
        assertEquals(302, rez6.getImg(), epsilon);

        ExpresieComplexa exp7 = parser.parseaza("91-131*i * 2-i * 1+i");
        NumarComplex rez7 = exp7.executa();
        assertEquals(404, rez7.getReal(), epsilon);
        assertEquals(-302, rez7.getImg(), epsilon);

        ExpresieComplexa exp8 = parser.parseaza("200-100*i * 1+i * 1-i * 0+1*i");
        NumarComplex rez8 = exp8.executa();
        assertEquals(200, rez8.getReal(), epsilon);
        assertEquals(400, rez8.getImg(), epsilon);

        ExpresieComplexa exp9 = parser.parseaza("-3+405*i / 1+i");
        NumarComplex rez9 = exp9.executa();
        assertEquals(201, rez9.getReal(), epsilon);
        assertEquals(204, rez9.getImg(), epsilon);

        ExpresieComplexa exp10 = parser.parseaza("802-836*i / 1+i / 1-i");
        NumarComplex rez10 = exp10.executa();
        assertEquals(401, rez10.getReal(), epsilon);
        assertEquals(-418, rez10.getImg(), epsilon);

        ExpresieComplexa exp11 = parser.parseaza("2508+2418*i / 1+i / 1-i / 3+0*i");
        NumarComplex rez11 = exp11.executa();
        assertEquals(418, rez11.getReal(), epsilon);
        assertEquals(403, rez11.getImg(), epsilon);

        ExpresieComplexa exp12 = parser.parseaza("2+3*i + 5-6*i + -2+i");
        NumarComplex rez12 = exp12.executa();
        assertEquals(5, rez12.getReal(), epsilon);
        assertEquals(-2, rez12.getImg(), epsilon);

        System.out.println("Teste trecute!");
    }
    @Test
    void testExempleInvalide() {
        ParsareExpresie parser = new SimpleExpressionParser();

        assertThrows(IllegalArgumentException.class, () -> {
            parser.parseaza("");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            parser.parseaza("2+3*i +");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            parser.parseaza("+ 2+3*i");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            parser.parseaza("2+3*i 5-6*i");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            parser.parseaza("2+3*i + + 5-6*i");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            parser.parseaza("2+3*j + 1+i");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            parser.parseaza("2+3*i % 1+i");
        });
        assertThrows(ArithmeticException.class, () -> {
            ExpresieComplexa exp = parser.parseaza("1+i / 0+0*i");
            exp.executa();
        });
    }
}