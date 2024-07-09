package Principal;


import Servicios.ConsultaConversion;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        ConsultaConversion objCC = new ConsultaConversion();
        int opc;

        do {

            System.out.println(objCC.menuConversion());
            opc = scan.nextInt();
            double amount;

            if (opc == 8) {
                break;
            }

            switch (opc) {
                case 1:
                    amount = objCC.DineroAconvertir();
                    objCC.CreateLink("USD", "ARS", amount);
                    break;
                case 2:
                    amount = objCC.DineroAconvertir();
                    objCC.CreateLink("ARS", "USD", amount);
                    break;
                case 3:
                    amount = objCC.DineroAconvertir();
                    objCC.CreateLink("USD", "BRL", amount);
                    break;
                case 4:
                    amount = objCC.DineroAconvertir();
                    objCC.CreateLink("BRL", "USD", amount);
                    break;
                case 5:
                    amount = objCC.DineroAconvertir();
                    objCC.CreateLink("USD", "COP", amount);
                    break;
                case 6:
                    amount = objCC.DineroAconvertir();
                    objCC.CreateLink("COP", "USD", amount);
                    break;
                case 7:
                    try {
                        System.out.println("Ingrese la moneda base: ");
                        String op1 = scan.next().toUpperCase().replace(" ", "");
                        System.out.println("Ingrese la moneda objetivo: ");
                        String op2 = scan.next().toUpperCase().replace(" ", "");
                        amount = objCC.DineroAconvertir();
                        objCC.CreateLink(op1, op2, amount);

                    } catch (Exception e) {
                        throw new RuntimeException("Divisa no encontrada");
                    }

                    break;
                default:
                    System.out.println("""
                            Opción inválida
                            _________________________________________
                            """);

            }
        } while (opc != 9);
        if(objCC.getHistorial().isEmpty()){
            System.out.println("Historial vacio");
        } else {
            System.out.println("Historial de conversiones en esta sección: " + "\n" + objCC.getHistorial());
        }

    }
}

