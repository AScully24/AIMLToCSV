package aimltocsv;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "aiml" )
public class AIMLFile {
    
    
    List<AIMLCategory> catergories;

    public void setCatergories(List<AIMLCategory> catergories) {
        this.catergories = catergories;
    }

    @XmlElement (name = "category")
    public List<AIMLCategory> getCatergories() {
        return catergories;
    }
    
    
    
}
