import java.util.ArrayList;
import java.util.Scanner;

class Contact {
     private String name;
     private String phoneNumber;
     private String emailAddress;

     public Contact(String name, String phoneNumber, String emailAddress) {
          this.name = name;
          this.phoneNumber = phoneNumber;
          this.emailAddress = emailAddress;
     }

     public String getName() {
          return name;
     }

     public String getPhoneNumber() {
          return phoneNumber;
     }

     public String getEmailAddress() {
          return emailAddress;
     }

     @Override
     public String toString() {
          return "Name: " + name + ", Phone Number: " + phoneNumber + ", Email Address: " + emailAddress;
     }
}

class AddressBook {
     private ArrayList<Contact> contacts;

     public AddressBook() {
          contacts = new ArrayList<>();
     }

     public void addContact(Contact contact) {
          contacts.add(contact);
     }

     public void removeContact(String name) {
          contacts.removeIf(contact -> contact.getName().equals(name));
     }

     public Contact searchContact(String name) {
          for (Contact contact : contacts) {
               if (contact.getName().equals(name)) {
                    return contact;
               }
          }
          return null;
     }

     public void displayAllContacts() {
          for (Contact contact : contacts) {
               System.out.println(contact);
          }
     }
}

public class Akps_AddressBook {
     public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);
          AddressBook addressBook = new AddressBook();

          while (true) {
               System.out.println("Address Book System");
               System.out.println("1. Add Contact");
               System.out.println("2. Remove Contact");
               System.out.println("3. Search Contact");
               System.out.println("4. Display All Contacts");
               System.out.println("5. Exit");
               System.out.print("Select an option: ");
               int choice = scanner.nextInt();
               scanner.nextLine();

               switch (choice) {
                    case 1:
                         System.out.print("Enter contact name: ");
                         String name = scanner.nextLine();
                         System.out.print("Enter phone number: ");
                         String phoneNumber = scanner.nextLine();
                         System.out.print("Enter email address: ");
                         String emailAddress = scanner.nextLine();
                         Contact newContact = new Contact(name, phoneNumber, emailAddress);
                         addressBook.addContact(newContact);
                         System.out.println("Contact added successfully.");
                         break;

                    case 2:
                         System.out.print("Enter name of contact to remove: ");
                         String removeName = scanner.nextLine();
                         addressBook.removeContact(removeName);
                         System.out.println("Contact removed successfully.");
                         break;

                    case 3:
                         System.out.print("Enter name of contact to search: ");
                         String searchName = scanner.nextLine();
                         Contact searchedContact = addressBook.searchContact(searchName);
                         if (searchedContact != null) {
                              System.out.println("Contact found: " + searchedContact);
                         } else {
                              System.out.println("Contact not found.");
                         }
                         break;

                    case 4:
                         System.out.println("List of all contacts:");
                         addressBook.displayAllContacts();
                         break;

                    case 5:
                         System.out.println("Exiting the application.");
                         scanner.close();
                         return;

                    default:
                         System.out.println("Invalid choice. Please select a valid option.");
                         break;
               }
          }
     }
}
