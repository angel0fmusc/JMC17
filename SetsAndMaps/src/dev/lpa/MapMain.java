package dev.lpa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapMain {

    public static void main(String[] args) {

        // get a list of phone and email contacts, creating a
        // combined list
        List<Contact> phones = ContactData.getData("phone");
        List<Contact> emails = ContactData.getData("email");
        String lineSeparator = "-".repeat(30);

        List<Contact> fullList = new ArrayList<>(phones);
        fullList.addAll(emails);

        fullList.forEach(System.out::println);
        System.out.println(lineSeparator);

        HashMap<String, Contact> contacts = new HashMap<>();
        for(Contact contact : fullList){
            contacts.put(contact.getName(), contact);
        }

        contacts.forEach((k,v) -> System.out.println("key = " + k +
                ", value = " + v));

        System.out.println(lineSeparator);
        System.out.println(contacts.get("Charlie Brown"));

        System.out.println(contacts.get("Chuck Brown"));
        System.out.println(contacts.getOrDefault("Chuck Brown", new Contact("Chuck Brown")));

        System.out.println(lineSeparator);
        contacts.clear();
        for(Contact contact : fullList){
            Contact duplicate = contacts.put(contact.getName(), contact);
            if(duplicate != null){
//                System.out.println("duplicate = " + duplicate);
//                System.out.println("current = " + contact);
                contacts.put(contact.getName(), contact.mergeContactData(duplicate));
            }
        }

        contacts.forEach((k,v) -> System.out.println("key = " + k +
                ", value = " + v));

        System.out.println(lineSeparator);
        contacts.clear();

        for(Contact contact : fullList){
            Contact duplicate = contacts.putIfAbsent(contact.getName(), contact);
            if(duplicate != null){
                contacts.put(contact.getName(), contact.mergeContactData(duplicate));
            }
        }
        contacts.forEach((k,v) -> System.out.println("key = " + k +
                ", value = " + v));

        System.out.println(lineSeparator);
        contacts.clear();
        fullList.forEach(contact -> contacts.merge(contact.getName(), contact,
                Contact::mergeContactData
        ));
        contacts.forEach((k,v) -> System.out.println("key = " + k +
                ", value = " + v));

        // Compute methods
        System.out.println(lineSeparator);
        System.out.println("Compute methods");
        for(String contactName : new String[]{"Daisy Duck", "Daffy Duck", "Scrooge McDuck"}){
//            contacts.compute(contactName, (k, v) -> new Contact(k));
            contacts.computeIfAbsent(contactName, k -> new Contact(k));
        }
        contacts.forEach((k,v) ->System.out.println("key = " + k +
                ", value = " + v) );

        System.out.println(lineSeparator);
        System.out.println("computeIfPresent() method");
        for(String contactName : new String[]{"Daisy Duck", "Daffy Duck", "Scrooge McDuck"}){
            contacts.computeIfPresent(contactName, (k,v) -> {
                v.addEmail("Fun Place");
                return v;
            });
        }
        contacts.forEach((k,v) ->System.out.println("key = " + k +
                ", value = " + v) );

        System.out.println(lineSeparator);
        System.out.println("replaceAll() method");
        contacts.replaceAll((k,v) -> {
            String newEmail = k.replaceAll(" ","") + "@funplace.com";
            v.replaceEmailIfExists("DDuck@funplace.com", newEmail);
            return v;
        });

        contacts.forEach((k,v) ->System.out.println("key = " + k +
                ", value = " + v) );

        System.out.println(lineSeparator);
        Contact daisy = new Contact("Daisy Jane Duck", "daisyj@duck.com");

        Contact replacedContact = contacts.replace("Daisy Duck", daisy);
        System.out.println("daisy = " + daisy);
        System.out.println("replacedContact = " + replacedContact);
        contacts.forEach((k,v) -> System.out.println("key=" + k + ", value=" + v));

        System.out.println(lineSeparator);
        Contact updatedDaisy = replacedContact.mergeContactData(daisy);
        System.out.println("updatedDaisy = " + updatedDaisy);
        boolean success = contacts.replace("Daisy Duck" , daisy, updatedDaisy);
        if(success){
            System.out.println("Successfully replaced element");
        } else{
            System.out.printf("Did not match on both key: %s and value: %s%n".formatted("Daisy Duck",replacedContact));
        }
        contacts.forEach((k,v) -> System.out.println("key=" + k + ", value=" + v));

        System.out.println(lineSeparator);
        success = contacts.remove("Daisy Duck", daisy);
        if(success){
            System.out.println("Successfully removed element");
        } else{
            System.out.printf("Did not match on both key: %s and value: %s%n".formatted("Daisy Duck",replacedContact));
        }
        contacts.forEach((k,v) -> System.out.println("key=" + k + ", value=" + v));
    }
}
