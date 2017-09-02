import complexNumber.complecsNumber;

import java.io.*;

public class main {
    public static void main(String[] args) throws FileNotFoundException {
        complecsNumber cmplx = new complecsNumber(2.3,1.3);
        System.out.println("Комплексное число :"+cmplx);
        System.out.println("Сумма комплексного числа с самим собой"+cmplx.summ(cmplx));
        System.out.println("Разность комплексного числа"+cmplx.diff(cmplx.summ(cmplx)));
        System.out.println("Произведение комплексного числа"+cmplx.multiply(cmplx));
        System.out.println("Произведение комплексного числа"+cmplx.division(cmplx));
        System.out.println("Сравнеие двух компексных чисел - само с собой: "+cmplx.equals(cmplx));
        System.out.println("Сравнеие двух компексных чисел - само со своим квадратом: "+cmplx.equals(cmplx.multiply(cmplx)));
        System.out.println("Чтение из файла: ");
        InputStream inStream = main.class.getResourceAsStream("/resources/numbersIn.dat");
        cmplx.readFromFile(inStream);
        System.out.println("Запись в файл: ");
        File f = new File ("nubersOut.dat");
        System.out.println("Будет записан файл "+f.getAbsolutePath());
        FileOutputStream fout = new FileOutputStream(f);
        cmplx.writeToFile(fout);
        cmplx.summ(cmplx).writeToFile(fout);
        cmplx.diff(cmplx.summ(cmplx)).writeToFile(fout);
        cmplx.multiply(cmplx).writeToFile(fout);
        cmplx.division(cmplx).writeToFile(fout);

    }

}
