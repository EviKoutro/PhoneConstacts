
import java.util.ArrayList;
import java.util.*;

public class MobilePhone implements IPhone {
    private  List<IContact> myGenericIContactList = new ArrayList<>();
    private List<PhoneContact> myGenericPhoneContact=new ArrayList<>();
    private int findContact(String contactPhoneNumber){
        for(int i = 0; i<this.myGenericIContactList.size(); i++)
            if ( contactPhoneNumber.equals(this.myGenericIContactList.get(i).getContactPhoneNumber() ))
                return i;
        return (-1);
    }

    @Override
    public boolean addNewContact( IContact contact){
        if (this.findContact(contact.getContactPhoneNumber()) < 0 ) {
            myGenericIContactList.add(contact);
            return true;
        }
        else {
            System.out.println("Contact already in Mobile-Phone");
            return false;
        }
    }

    @Override
    public boolean updateContact(IContact oldContact, IContact newContact){
        int foundPosition = this.findContact(oldContact.getContactPhoneNumber());

        if (foundPosition < 0) {
            System.out.println("Contact not found");
            return false;
        }

        IContact tmp = this.myGenericIContactList.set(foundPosition, newContact);
        System.out.println(oldContact.getContactPhoneNumber() + " was replaced with "
                + tmp.getContactPhoneNumber());
        return true;
    }

    @Override
    public boolean removeContact ( IContact contact){
        int foundPosition = this.findContact(contact.getContactPhoneNumber());

        if (foundPosition >= 0) {
            myGenericIContactList.remove(foundPosition);
            System.out.println(contact.getContactPhoneNumber() + " was deleted");
            return true;
        }
        else {
            System.out.println(contact.getContactPhoneNumber() + " was not found");
            return false;
        }
    }

    @Override
    public IContact getContactBySurName( String surName){

        for (IContact c: myGenericIContactList){
            if (surName.equals(c.getContactSurName())) return c;
        }
        return null;
    }

    @Override
    public boolean contactNumberExists( String contactPhoneNumber){
        for (IContact c: myGenericIContactList){
            if (contactPhoneNumber.equals(c.getContactPhoneNumber())) return true;
        }
        return false;
    }

    @Override
    public void printContactList(){
        myGenericIContactList.forEach(System.out::println);
    /*
        for (IContact c: myGenericIContactList){
            System.out.println(c);
        }
    */
    }

    @Override
    public IContact getContactByPhoneNumber( String contactPhoneNumber){
        for (IContact c: myGenericIContactList){
            if (contactPhoneNumber.equals(c.getContactPhoneNumber())) return c;
        }
        return null;
    }

    @Override
    public void sortContactsBySurName(){
        for (IContact p : myGenericIContactList)
            myGenericPhoneContact.add((PhoneContact) p);

        System.out.println("Πριν την ταξινόμηση");
        printContactList();

        Collections.sort(myGenericPhoneContact);
        //Collections.sort(myProductList, Comparator.reverseOrder());
        Collections.copy(myGenericIContactList, myGenericIContactList);

        System.out.println("Μετά την ταξινόμηση");
        printContactList();
    }
}

