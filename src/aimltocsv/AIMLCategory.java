package aimltocsv;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "category")
public class AIMLCategory {

    public int usageCount;
    @XmlElement(name = "pattern")
    public String pattern;
    public String that;
    public String star2;

    @XmlAnyElement(TemplateHandler.class)
    public String template;
    public String aimlFilePath;

    public String toCSV() {
        /* Tidy up template before CSV conversion.*/
        template = template.replace("\n", "");
        template = template.replace("\t", "");
        return usageCount + "," + pattern + ",*,*," + template + "," + aimlFilePath;
    }
}
