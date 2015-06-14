package aimltocsv;

import java.io.IOException;

/**
 *
 * @author Anthony Scully
 */
public class AIMLToCSV {

    public static void main(String[] arg) throws IOException {
        String filePath;
//        String filePath = arg[0];
        filePath
                = "/home/scully/NetBeansProjects/JarvisTest/program-ab/bots/jarvis/aiml/test.aiml";
        String newPath = getNewPath(filePath);

        Converter converter = new Converter(filePath);
        AIMLFile file = converter.fileToObject();
//        System.out.println(newPath);
        converter.ObjectToCSV(file, newPath);
//        
//        for (AIMLCategory c : file.catergories) {
//            System.out.println(c.toCSV());
//        }

    } // main

    private static String getNewPath(String path) {
        String newPath = "";
        String[] split;
        String seperator;
        if (System.getProperty("os.name").contains("Window")) {
            seperator = "\\";
        } else {
            seperator = "/";
        }

        split = path.split(seperator);
        String fileName = split[split.length - 1];

        for (int i = 0; i < split.length - 2; i++) {
            newPath += split[i] + seperator;
        }

        newPath += "aimlif" + seperator + fileName + ".csv";
        return newPath;
    }

}// class
