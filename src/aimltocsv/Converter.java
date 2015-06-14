package aimltocsv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Anthony Scully
 */
public class Converter {

    String filePath;

    public Converter(String filePath) {
        this.filePath = filePath;
    }

    private File copyFileForImporting(File file) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        File newFile = new File(filePath + "2");
        PrintWriter writer = new PrintWriter(newFile);
        String line = br.readLine();

        while (line != null) {
            if (line.contains("<aiml")) {
                writer.println("<aiml>");
            } else writer.println(line);
            line = br.readLine();
        }
        writer.close();

        return newFile;
    }

    public AIMLFile fileToObject() throws IOException {
        try {
            JAXBContext context = JAXBContext.newInstance(AIMLFile.class);
            Unmarshaller un = context.createUnmarshaller();

            File file = new File(filePath);
            File newFile = copyFileForImporting(file);
            AIMLFile temp = (AIMLFile) un.unmarshal(newFile);

            String fileName = file.getName();
            for (AIMLCategory c : temp.catergories) {
                c.aimlFilePath = fileName;
            }

            newFile.delete();
            return temp;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void ObjectToCSV(AIMLFile object, String destination) throws FileNotFoundException {
        File file = new File(destination);
        if (file.exists()) {
            file.delete();
        }
        PrintWriter writer = new PrintWriter(file);

        for (AIMLCategory c : object.catergories) {
            writer.println(c.toCSV());
        }
        writer.close();

    }

    /* Converts an entire folder into aiml.csv.*/
    public void convertFolder(String dirPath) {
        String seperator;
        if (System.getProperty("os.name").contains("Window")) {
            seperator = "\\";
        } else {
            seperator = "/";
        }
        
        
        File dirAIML = new File(dirPath + seperator + "aiml" );
        File[] listingAIML = dirAIML.listFiles();
        
        if (listingAIML != null) {
            for (File child : listingAIML) {
                if (child.isFile()) {
                    
                }
            }
        }
    }

}
