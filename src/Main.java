import models.Snickers;
import service.SnickersService;
import service.impl.SnickersServiceImpl;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SnickersService snickersService = new SnickersServiceImpl();
        Scanner scInt = new Scanner(System.in);
        Scanner scStr = new Scanner(System.in);
        boolean isTrue = true;
        while(isTrue){
            System.out.println("""
                    \nSelect the command:
                    1.Create;
                    2.Get All;
                    3.Get By;
                    4.Update;
                    5.Delete;
                    6.Exit.
                    """);
            int command = new Scanner(System.in).nextInt();
            switch (command){
                case 1: {
                    Snickers snickers = new Snickers();
                    while(true){
                        try {
                            System.out.println("Enter id: ");
                            snickers.setId(Long.parseLong(scInt.nextLine()));
                            if (snickers.getId() < 1) {
                                throw new RuntimeException("Id less than 1. Try again!");
                            }
                            snickers.setId(scInt.nextLong());
                            break; //выход из цикла после правильного ввода id
                        } catch (NumberFormatException e) {
                            System.err.println("You didn't enter a number!");
                        } catch (RuntimeException e) {
                            System.err.println(e.getMessage());
                        }
                    }
                    System.out.println("Enter name-type: ");
                    snickers.setNameType(scStr.nextLine());
                    System.out.println("Enter weight: ");
                    snickers.setWeight(scInt.nextDouble());
                    System.out.println("Enter barcode: ");
                    snickers.setBarcode(scStr.nextLine());
                    System.out.println("Enter price: ");
                    snickers.setPrice(scInt.nextInt());
                    System.out.println("Enter product quantity: ");
                    snickers.setCount(scInt.nextInt());
                    snickersService.createSnickers(snickers);
                } break;
                case 2:
                    System.out.println(Arrays.toString(snickersService.getAllSnickers()));
                    break;
                case 3:
                    System.out.println("Enter snickers name-type for searching: ");
                    System.out.println(snickersService.getByNameSnickers(new Scanner(System.in).nextLine()));
                    break;
                case 4: {
                    System.out.println("UPDATE: ");
                    Snickers updateSnickers = new Snickers();
                    System.out.println("Write old name-type: ");
                    String oldName = new Scanner(System.in).nextLine();
                    System.out.println("Enter new name: ");
                    updateSnickers.setNameType(new Scanner(System.in).nextLine());
                    System.out.println("Enter new weight: ");
                    updateSnickers.setWeight(new Scanner(System.in).nextDouble());
                    System.out.println("Enter new barcode: ");
                    updateSnickers.setBarcode(new Scanner(System.in).nextLine());
                    System.out.println("Enter new price: ");
                    updateSnickers.setPrice(new Scanner(System.in).nextInt());
                    System.out.println("Enter new quantity: ");
                    updateSnickers.setCount(new Scanner(System.in).nextInt());
                    snickersService.updateSnickersByName(oldName, updateSnickers);
                } break;
                case 5: {
                    System.out.println("DELETE: ");
                    System.out.println("Enter barcode for deleting: ");
                    snickersService.deleteSnickersByBarcode(new Scanner(System.in).nextLine());
                    break;
                }
                case 6: isTrue = false;
                    System.out.println("Program is stoped!");
                    break;
                default:
                    System.out.println("Command not found!");
            }
        }
    }
}