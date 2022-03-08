public interface IPhone {
    boolean addNewContact(IContact contact);
    boolean updateContact(IContact oldContact, IContact newContact);
    boolean removeContact(IContact contact);
    IContact getContactByPhoneNumber(String contactPhoneNumber);
    IContact getContactBySurName(String surName);
    boolean contactNumberExists(String contactPhoneNumber);
    void printContactList();
    void sortContactsBySurName();
}

