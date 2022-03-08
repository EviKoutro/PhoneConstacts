import java.lang.*;
import java.util.Scanner;

public class MobilePhoneDemo {
   private static IPhone phonelist = new MobilePhone();
    private static Scanner in = new Scanner(System.in);
public static void main(String [] args){
    while(true){
        try {
            MobilePhoneDemo.doAll();
        }
        catch(Exception e){
            System.out.println("give a number between 0 to 7");
            in.next();
        }
    }
}

    private static void printChoices() {
        System.out.print("\nPress \n");
        System.out.print("0 - To print the choice options \n");
        System.out.print("1 - To print the list of Contacts \n");
        System.out.print("2 - To add a new Contact \n");
        System.out.print("3 - To modify a Contact \n");
        System.out.print("4 - To remove a Contact \n");
        System.out.print("5 - To search for a Contact by Surname\n");
        System.out.print("6 - To sort Contacts by Surname\n");
        System.out.print("7 - To quit the application\n");
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
    public static void doAll() {

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
                    printContacts(); break;
                case 2:
                    addContact(); break;
                case 3:
                    modifyContact(); break;
                case 4:
                    deleteContact(); break;
                case 5:
                    searchContact(); break;
                case 6:
                    sortBySurName(); break;
                case 7:
                    quit = true;
                default:
                    printChoices(); break;
            }
        }
        while (!quit) ;

        System.exit(0);
    }
private static void addContact(){
    String firstname;
    String phonenumber;
    String surname;
    System.out.println("give the contact");
    firstname=in.next();
    phonenumber=in.next();
    surname=in.next();
    PhoneContact c= new PhoneContact(firstname,phonenumber,surname);
    if(phonelist.addNewContact(c)){
        System.out.println("η επαφη μπηκε επιτυχως");
    }
}
private static void printContacts(){
phonelist.printContactList();
System.out.println();
}

private static void deleteContact(){
    String firstname;
    String phonenumber;
    String surname;
    System.out.println("give the contact");
    firstname=in.next();
    phonenumber=in.next();
    surname=in.next();
    PhoneContact c= new PhoneContact(firstname,phonenumber,surname);
    if(phonelist.removeContact(c)){
        System.out.println("η επαφη διαγραφτηκε επιτυχως");
    }
}
private static void searchContact(){
    System.out.print("\nEnter product name\n");
    String contact = in.next();

    if(phonelist.getContactBySurName(contact) != null) {
        System.out.println("Item  " + contact + " has been found");
        System.out.println(phonelist.getContactBySurName(contact));
    }
    else
        System.out.println("Item with product name: " + contact +
                " has not been found");
}



private static void sortBySurName(){
    phonelist.sortContactsBySurName();
    System.out.println();

}
private static void modifyContact(){


    String contact;
    System.out.println("give the contact");
    contact=in.next();
    if(phonelist.contactNumberExists(contact)){
        System.out.println("give new firstname,new number and new surname");
        String newfirstname;
        String newphonenumber;
        String newsurname;
        System.out.println("give the contact");
        newfirstname=in.next();
        newphonenumber=in.next();
        newsurname=in.next();
        PhoneContact nc= new PhoneContact(newfirstname,newphonenumber,newsurname);
        if(phonelist.updateContact(phonelist.getContactByPhoneNumber(contact),nc)){
            System.out.println("Successfully Updated");
        }
        else{
            System.out.println("Not successfully updated");
        }}
 else {
        System.out.println("Product does not exist");
    }
        }

}



