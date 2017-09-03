import substances.material;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class main {

    public static void main(String[] args) {

        InputStream inputStream = main.class.getResourceAsStream("/resources/materials.dat");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String tempName;
            int  countOfMaterials;
            ArrayList<material> listOfMaterials = new ArrayList<>();

            countOfMaterials=Integer.parseInt(br.readLine());
            System.out.println("Будет обработано материалов: "+countOfMaterials);

            for (int i = 0; i < countOfMaterials; i++) {
                tempName=br.readLine();
                if (tempName.trim().contains(" ")) {
                    listOfMaterials.add(new material(
                            tempName,
                            Float.parseFloat(br.readLine()),
                            Integer.parseInt(br.readLine())
                            )
                    );
                } else  {
                    br.readLine();br.readLine();
                }
            }
            if (listOfMaterials.size()==0) {
                System.out.println("Заданных веществ не обнаружено");
            } else {
                printMaterialsArray(listOfMaterials);
                System.out.println();
                sortMaterialsArray(listOfMaterials);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printMaterialsArray (ArrayList<material> printList) {
        System.out.println("Собрано материалов: "+printList.size());
        System.out.println("Содержимое массива: ");
        for (material m:printList) {
            System.out.println(m);
        }
    }

    public static void sortMaterialsArray (ArrayList<material> inputList) {
        material[] sortedInputList= new material[inputList.size()];
        int counter=-1;
        for (material m:inputList) {
            sortedInputList[++counter]=m;
        }
        for (int i = 0; i < counter+1; i++) {
            for (int j = 0; j < counter; j++) {
                if (sortedInputList[i].getWeght()<sortedInputList[j].getWeght()) {
                    material material = sortedInputList[i];
                    sortedInputList[i]=sortedInputList[j];
                    sortedInputList[j]=material;
                    material=null;
                }
            }
        }
        System.out.println("Отсортированный массив");
        for (material m :sortedInputList) {
            System.out.println(m);
        }
    }


}
