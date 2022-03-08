package gr.aueb.elearn.chap13.supermarket;

import java.io.*;
import java.util.Scanner;

public class ProductListDemo {
    private static IProductList myProductList = new ProductListHash();
    private static Scanner in = new Scanner(System.in);

    private static void printChoices() {
        System.out.print("\nPress \n");
        System.out.print("0 - To print the choice options \n");
        System.out.print("1 - To print the list of items \n");
        System.out.print("2 - To add a new item \n");
        System.out.print("3 - To modify an item \n");
        System.out.print("4 - To remove an item \n");
        System.out.print("5 - To search for an item \n");
        System.out.print("6 - To save productList to a file \n");
        System.out.print("7 - To read productList from a file \n");
        System.out.print("8 - To sort by product name \n");
        System.out.print("9 - To sort by product price \n");
        System.out.print("10 - To sort by product type \n");
        System.out.print("11 - To sort by product quantity \n");
        System.out.print("12 - To quit the application\n");
    }

    private static void addItem() {
        ProductType productType;
        boolean productTypeFound = false;

        System.out.println("Enter new bar code ");
        String s = in.next();
        BarCode b = new BarCode(s);

        if (!myProductList.productCodeExists(b)) {
            System.out.println("Δώστε product type");
            String sProType = in.next();

            try {
                //productType =
                ProductType.valueOf(sProType.toUpperCase());
                productTypeFound = true;
            } catch (IllegalArgumentException e) {
                //System.out.println(e.getMessage());
                //found = false;
            }

            if (productTypeFound) {
                productType = ProductType.valueOf(sProType.toUpperCase());
                System.out.println("Δώστε product name, price, and quantity");
                String productName = in.next();
                double productPrice = in.nextDouble();
                //String barCode = in.next();
                int productQuantity = in.nextInt();

                Product p = new Product();
                p.setProductType(productType);
                p.setProductName(productName);
                p.setProductPrice(productPrice);
                p.setProductBarCode(b);//new BarCode(barCode));
                p.setQuantity(productQuantity);

                if (myProductList.addNewProduct(p)) {
                    System.out.println("Item Added");
                }
            } else {
                System.out.println("Product Type not Found");
            }
         }
        else System.out.println("Product already exists");
    }


    private static void modifyItem() {
        boolean found = false;
        System.out.println("Enter current bar code");
        String s = in.next();
        BarCode b = new BarCode(s);
        ProductType productType;
        System.out.println("Δώστε product type");
        String proCode = in.next();

        if (myProductList.productCodeExists(b)){
            try {
                //productType =
                ProductType.valueOf(proCode.toUpperCase());
                found = true;
            } catch (IllegalArgumentException e) {
//               // System.out.println(e.getMessage());
                //found = false;
            }
            if (found) {
                productType = ProductType.valueOf(proCode.toUpperCase());
                System.out.println("Enter new item name, price, bar code and quantity");
                String newContact = in.next();

                Product p = new Product(productType, newContact, newPrice, new BarCode(newBarCode), productQuantity);
                if (myProductList.updateProduct(myProductList.getProductByBarCode(b), p)){
                    System.out.println("Successfully Updated");
                }
                else{
                    System.out.println("Not successfully updated");
                }
            } else {
                System.out.println("Product Type not Found");
            }
        } else {
            System.out.println("Product does not exist");
        }
    }

    private static void printItems(){
        myProductList.printProductList();
        System.out.println();
    }

    private static boolean isInt(String s) //throws NumberFormatException
    {
        try
        {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex)
        {
            return false;
        }
    }

    private static void copyToFile() {//throws IOException{
        try (
            FileOutputStream fileOut =  new FileOutputStream("C:/tmp/JavaSerializationDir/myProductsList.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut))
        {
            out.writeObject(myProductList);
            //out.close();  fileOut.close();  Δεν χρειάζονται γιατί κάνω try-with-resources
            System.out.println("Serialized data is saved in /tmp/JavaSerializationDir/myProductsList.ser");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    private static void readFromFile() {//throws IOException, ClassNotFoundException{
        try (
            FileInputStream fileIn = new FileInputStream("C:/tmp/JavaSerializationDir/myProductsList.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn))
        {
            myProductList = (IProductList) in.readObject();
            //in.close(); fileIn.close();
            System.out.println("ProductList was read successfully!");
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e2) {
            System.out.println("ProductList class not found");
            //e2.printStackTrace();
        }
    }

    private static void deleteItem(){
        System.out.print("\nEnter productCode to be removed\n");
        String  = in.next();
        Product p = new Product();
        p.setProductBarCode(new BarCode(productCode));
        if (myProductList.removeProduct(p))
            System.out.println("Deletion Completed");
    }

    private static void searchItem(){
        System.out.print("\nEnter product name\n");
        String productName = in.next();

        if (myProductList.getProductByName(productName) != null) {
            System.out.println("Item  " + productName + " has been found");
            System.out.println(myProductList.getProductByName(productName));
        }
        else
          System.out.println("Item with product name: " + productName +
                  " has not been found");
    }

    private static void sortByProductName(){myProductList.sortByProductName();}
    private static void sortByProductPrice(){
        myProductList.sortProductsByProductPrice();
    }
    private static void sortByProductType(){
        myProductList.sortProductsByProductType();
    }
    private static void sortByProductQuantity(){
        myProductList.sortProductsByProductQuantity();
    }


    public static void main(String[] args) {
        try{
            printChoices();
            boolean quit = false;
            int choice;

            do {
                System.out.println("Enter your choice");
                String s = in.next();

                if (isInt(s))  choice=Integer.parseInt(s);
                else {
                    System.out.println("Provide a number");
                    in.nextLine();
                    choice = 0;
                }

                switch (choice) {
                    case 0:
                        printChoices(); break;
                    case 1:
                        printItems(); break;
                    case 2:
                        addItem(); break;
                    case 3:
                        modifyItem(); break;
                    case 4:
                        deleteItem(); break;
                    case 5:
                        searchItem(); break;
                    case 6:
                        copyToFile(); break;
                    case 7:
                        readFromFile(); break;
                    case 8:
                        sortByProductName(); break;
                    case 9:
                        sortByProductPrice(); break;
                    case 10:
                        sortByProductType(); break;
                    case 11:
                        sortByProductQuantity(); break;
                    case 12:
                        quit = true;
                    default:
                        printChoices(); break;
                }
            }
            while (!quit) ;

            System.out.println("Adios");
        }
        catch (Exception e) {
           e.printStackTrace();
        }
    }
}

