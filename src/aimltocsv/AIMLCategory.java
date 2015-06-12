package aimltocsv;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement( name = "category" )
public class AIMLCategory {
    public int usageCount;
    @XmlElement( name = "pattern" )
    public String pattern;
    public String star1,star2;
    
    @XmlMixed 
    @XmlElementRef( type=String.class, name = "template")
    public String template;
    public String aimlFilePath;
    
    @Override
    public String toString() {
        return "AIMLCategory{" + "usageCount=" + usageCount + ", pattern=" + pattern + ", star1=" + star1 + ", star2=" + star2 + ", template=" + template + ", aimlFilePath=" + aimlFilePath + '}';
    }
    
    
    
}
