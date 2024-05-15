package converter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String num;
        int base;
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        ConverterClass cv = new ConverterClass();

        //program main loop
        while (loop) {
            System.out.println("Do you want to convert /from decimal or /to decimal?" +
                    " (To quit type /exit)");
            String option = scanner.next();

            //process choice
            switch (option.toLowerCase()) {
                case "/to" :
                    System.out.println("Enter source number: ");
                    num = scanner.next();
                    System.out.println("Enter source base: ");
                    base = scanner.nextInt();
                    switch (base) {
                        case 2:
                            System.out.println("Conversion to decimal result: " + cv.bin2Dec(num) + "\n");
                            break;
                        case 8:
                            System.out.println("Conversion to decimal result: " + cv.oct2Dec(num) + "\n");
                            break;
                        case 16:
                            System.out.println("Conversion to decimal result: " + cv.hex2Dec(num) + "\n");
                    }
                    break;
                case "/from" :
                    System.out.println("Enter a number in the decimal system: ");
                    int dec = scanner.nextInt();
                    System.out.println("Enter the target base: ");
                    base = scanner.nextInt();
                    if (base != 16) {
                        System.out.println("Conversion result: " + cv.radixConverter(dec,base) + "\n");
                    } else {
                        System.out.println("Conversion result: " + cv.conv2Hex(dec) + "\n");
                    }
                    break;
                case "/exit" :
                    loop = false;
            }

        }
    }
}

