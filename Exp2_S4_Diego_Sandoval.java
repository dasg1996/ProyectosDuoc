
import java.util.Scanner;

public class Exp2_S4_Diego_Sandoval {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcion;
        boolean otraCompra = true;

        double PRECIO_A = 20000;
        double PRECIO_B = 15000;
        double PRECIO_C = 10000;

        while (otraCompra) {
            System.out.println("   TEATRO MORO - MENÚ PRINCIPAL   ");
            System.out.println("1. Comprar entrada");
            System.out.println("2. Salir");
            System.out.print(" Seleccione una opción: ");
            opcion = entrada.nextInt();

            if (opcion == 1) {
                String zona = "";
                int edad;
                double precioBase = 0;
                double descuento = 0;

                boolean zonaValida = false;
                while (!zonaValida) {
                    System.out.println("Zonas disponibles:");
                    System.out.println("A - Platea VIP ($20,000)");
                    System.out.println("B - Platea Media ($15,000)");
                    System.out.println("C - Platea Baja ($10,000)");
                    System.out.print("➤ Ingrese zona (A/B/C): ");
                    zona = entrada.next().toUpperCase();

                    if (zona.equals("A") || zona.equals("B") || zona.equals("C")) {
                        zonaValida = true;
                        switch (zona) {
                            case "A":
                                precioBase = PRECIO_A;
                                break;
                            case "B":
                                precioBase = PRECIO_B;
                                break;
                            case "C":
                                precioBase = PRECIO_C;
                                break;
                        }
                    } else {
                        System.out.println("Error: Zona no válida.");
                    }
                }

                boolean edadValida = false;
                while (!edadValida) {
                    System.out.print(" Ingrese su edad: ");
                    if (entrada.hasNextInt()) {
                        edad = entrada.nextInt();
                        if (edad > 0 && edad < 120) {
                            edadValida = true;
                            if (edad >= 65) {
                                descuento = precioBase * 0.15;
                            } else if (edad <= 25) {
                                descuento = precioBase * 0.10;
                            }
                        } else {
                            System.out.println("Error: Edad no válida.");
                        }
                    } else {
                        System.out.println("Error: Ingrese un número.");
                        entrada.next();
                    }
                }

                double precioFinal = precioBase - descuento;
                System.out.println("  RESUMEN DE COMPRA:");
                System.out.println("  Zona: " + zona);
                System.out.printf("  Precio base: $%.0f\n", precioBase);
                System.out.printf("  Descuento: $%.0f\n", descuento);
                System.out.printf("  Total a pagar: $%.0f\n", precioFinal);

               
                boolean entradaValida = false;
                while (!entradaValida) {
                    System.out.print("¿Desea realizar otra compra? (Sí=1/No=2): ");
                    if (entrada.hasNextInt()) {
                        int continuar = entrada.nextInt();
                        if (continuar == 1 || continuar == 2) {
                            otraCompra = (continuar == 1);
                            entradaValida = true;
                        } else {
                            System.out.println("Error: Opción no válida. Ingrese 1 o 2.");
                        }
                    } else {
                        System.out.println("Error: Debe ingresar un número (1 o 2).");
                        entrada.next();
                    }
                }

            } else if (opcion == 2) {
                otraCompra = false;
            } else {
                System.out.println("Opción no válida.");
            }
        }
        System.out.println("¡Gracias por usar el sistema!");
        entrada.close();
    }
}

