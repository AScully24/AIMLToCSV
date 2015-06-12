package aimltocsv;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "aiml" )
public class AIMLFile {
    
    @XmlElement (name = "category")
    public List<AIMLCategory> catergories;

    
}
