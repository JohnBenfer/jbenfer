import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        List<String> content = readFile("src/Contacts");
        List<Contact> contacts = createContacts(content);
        System.out.print(contacts);
    }


    public static List<Contact> createContacts(List<String> content) {
        List<Contact> contacts = new ArrayList<>();

        if (content.size() % 3 == 0) {
            for (int i = 0; i < content.size(); i = i + 3) {
                contacts.add(new Contact(content.get(i), content.get(i + 1), content.get(i + 2)));
            }

        } else {

            System.out.println("File is invalid");
        }
        return contacts;
    }


    public static List<String> readFile(String fileName) {
        // This will reference one line at a time
        String line;
        List<String> content = new ArrayList<>();

        try {
            // FileReader reads text files in the default encoding.
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

            while ((line = bufferedReader.readLine()) != null) {
                content.add(line);
            }

            // Always close files.
            bufferedReader.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        }

        return content;
    }
}
