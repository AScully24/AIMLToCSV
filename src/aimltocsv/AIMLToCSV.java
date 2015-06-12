package aimltocsv;

import java.io.IOException;

/**
 *
 * @author Anthony Scully
 */
public class AIMLToCSV {
    
    public static void main(String[] arg) throws IOException {
        Converter converter = new Converter("H:\\My Documents\\NetBeansProjects\\JarvisTest\\program-ab\\bots\\jarvis\\aiml\\request.aiml");
        AIMLFile file = converter.fileToObject();
        
        for (AIMLCategory c : file.catergories) {
            System.out.println(c.toString());
        }
    } // main

}// class
