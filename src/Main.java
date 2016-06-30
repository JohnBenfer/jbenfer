import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {

        List<String> content = readFile("src/Contacts");
        List<Contact> contacts = createContacts(content);
        System.out.print(contacts);


    }



    public static List<Contact> createContacts(List<String> content) {
        if (content.size() % 3 == 0 ) {
            List<Contact> contacts = new ArrayList<>();
            for (int i = 0; i < content.size(); i = i + 3) {
                contacts.add(new Contact(content.get(i), content.get(i+1), content.get(i+2)));

            }
            return contacts;

        } else {
            System.out.println("File is invalid");
            return new ArrayList<>();
        }
    }




    public static List<String> readFile(String fileName) {

        // This will reference one line at a time
        String line;
        List<String> content = new ArrayList<>();
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                content.add(line);

            }

            // Always close files.
            bufferedReader.close();

        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" +
                fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '"
                + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
        return content;
    }
}
