package complexNumber;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class complecsNumber {
    //комплексное число - числа вида z= x + iy, где  x и y  — вещественные числа, i — мнимая единица
    private final double complexX, complexY;

    public double getComplexX() {
        return complexX;
    }

    public double getComplexY() {
        return complexY;
    }

    public complecsNumber(double x, double y) {
        this.complexX = x;
        this.complexY = y;

    }

    @Override
    public String toString() {
        if (complexY > 0 || complexY == 0) {
            return "(" + new DecimalFormat("#0.00").format(complexX) + "+" + new DecimalFormat("#0.00").format(complexY) + "i)";
        } else {
            return "(" + new DecimalFormat("#0.00").format(complexX) + new DecimalFormat("#0.00").format(complexY) + "i)";
        }
    }

    //два комплексных числа z1 = (x1, y1) и z2 = (x2, y2) называются равными, если x1 = x2 и y1 = y2;
    public boolean equals(complecsNumber cmplx) {
        if (this.complexX == cmplx.getComplexX() & this.complexY == cmplx.getComplexY()) {
            return true;
        } else {
            return false;
        }
    }

    //суммой комплексных чисел z1 и z2 называется комплексное число z вида z = (x1 + x2, y1 + y2);
    public complecsNumber summ(complecsNumber cmplx) {
        return new complecsNumber(
                this.complexX + cmplx.getComplexX(),
                this.complexY + cmplx.getComplexY()
        );
    }

    //Разностью комплексных чисел z1 и z2 называется комплексное число z такое, что z2 + z = z1, откуда находим z = z1 - z2 = (x1 - x2, y1 - y2).
    public complecsNumber diff(complecsNumber cmplx) {
        return new complecsNumber(
                this.complexX - cmplx.getComplexX(),
                this.complexY - cmplx.getComplexY()
        );
    }

    //произведением комплексных чисел z1 и z2 называется комплексное число
    //z = (x1x2 - y1y2, x1y2 + x2y1);

    public complecsNumber multiply(complecsNumber cmplx) {
        return new complecsNumber(
                this.complexX * cmplx.getComplexX() - this.complexY * cmplx.getComplexY(),
                this.complexX * cmplx.getComplexY() + this.complexY * cmplx.getComplexX()
        );
    }

    //Частным комплексных чисел z1 и z2 называется комплексное число z такое, что . Отсюда находим
    //z=(x1*x2+y1*y2/x2^2+y2^2,x2y1-x1*y2/x2^2+y2^2);
    public complecsNumber division(complecsNumber cmplx) {
        double cmplxX = cmplx.getComplexX();
        double cmplxY = cmplx.getComplexY();
        double base = cmplxX * cmplxX + cmplxY * cmplxY;

        return new complecsNumber(
                (this.complexX * cmplxX + this.complexY * cmplxY) / base,
                (cmplxX * this.complexY - this.complexX * cmplxY) / base
        );
    }

    //Чтение из файла

    public List<complecsNumber> readFromFile(InputStream input) {
        List<complecsNumber> nubersFromFile = new ArrayList<>();
        try (Scanner sc = new Scanner(input, System.getProperty("file.encoding"))) {

            while (sc.hasNextDouble()) {
                nubersFromFile.add(new complecsNumber(sc.nextDouble(), sc.nextDouble()));
            }
            if ((System.getProperty("java.specification.version").equals("1.8"))) {
                System.out.println("Считано чисел: " + nubersFromFile.size());
                nubersFromFile.stream().forEach(System.out::println);
                //nubersFromFile.stream().forEach((x) -> System.out.println (x));
            } else {
                for (int i = 0; i < nubersFromFile.size(); i++) {
                    System.out.println("Версия Java < 1.8");
                    System.out.println(nubersFromFile.get(i));
                }
            }

        } catch (Exception ex) {
            System.out.println("Ошибка метода:" + ex);
        }
        return nubersFromFile;
    }

    public void writeToFile(FileOutputStream fout) {
        try {
            fout.write((this.toString()).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

