import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static void main(String[] args)
    {
//        try{
//            File fisier = new File("expresie.txt");
//            Scanner scanner = new Scanner(fisier);
//
//            if(scanner.hasNextLine())
//            {
//                String expresieText = scanner.nextLine();
//
//                ParsareExpresie parser = new SimpleExpressionParser();
//                ExpresieComplexa expresie = parser.parseaza(expresieText);
//                NumarComplex rezultat = expresie.executa();
//                System.out.println("Rezultatul expresiei: " + expresieText + " este: " + rezultat);
//            }
//            scanner.close();
//        }catch (FileNotFoundException e)
//        {
//            System.out.println("Nu am gasit fisierul expresie.txt");
//        }

        SimpleExpressionParserTest test = new SimpleExpressionParserTest();
        test.testExempleBasic();
        test.testExempleInvalide();

    }
}
