
import java.util.Objects;

public class PhoneContact implements IContact,Comparable<PhoneContact> {

    public String contactPhoneNumber;
    private String contactSurName;
    private String contactFirstName;

    PhoneContact() {}

    PhoneContact(String contactPhoneNumber, String contactSurName, String contactFirstName) {
        this.contactPhoneNumber = contactPhoneNumber;
        this.contactSurName = contactSurName;
        this.contactFirstName = contactFirstName;
    }

    static PhoneContact getInstance(){
        return new PhoneContact();
    }

    @Override
    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    @Override
    public String getContactSurName() {
        return contactSurName;
    }

    void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }
    void setContactSurName(String contactSurName) {
        this.contactSurName = contactSurName;
    }
    //public String getContactFirstName() {return contactFirstName;}
    void setContactFirstName(String contactFirstName) {
        this.contactFirstName = contactFirstName;
    }

    @Override
    public String toString() {
        return "PhoneContact{" +
                "contactPhoneNumber='" + contactPhoneNumber + '\'' +
                ", contactSurName='" + contactSurName + '\'' +
                ", contactFirstName='" + contactFirstName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhoneContact)) return false;
        PhoneContact contact = (PhoneContact) o;
        return getContactPhoneNumber().equals(contact.getContactPhoneNumber()) &&
                getContactSurName().equals(contact.getContactSurName()) &&
                contactFirstName.equals(contact.contactFirstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getContactPhoneNumber(), getContactSurName(), contactFirstName);
    }

    @Override
    public int compareTo(PhoneContact  PC){
        return this.getContactSurName().compareTo(PC.getContactSurName());
    }
}

