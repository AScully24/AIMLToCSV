package aimltocsv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
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
    
    
    private File copyFileForImporting(File file) throws FileNotFoundException, IOException{
        BufferedReader br = new BufferedReader(new FileReader(file));
        File newFile = new File(filePath+"2");
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
            AIMLFile emp = (AIMLFile) un.unmarshal(newFile);
            
            newFile.delete();
            return emp;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    

}
