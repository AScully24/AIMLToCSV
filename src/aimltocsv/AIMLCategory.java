package aimltocsv;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement( name = "category" )
public class AIMLCategory {
    int usageCount;
    String pattern;
    String star1,star2;
    String template;
    String aimlFilePath;
    
    public void setUsageCount(int usageCount) {
        this.usageCount = usageCount;
    }

    @XmlElement( name = "pattern" )
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
    
    public void setStar1(String star1) {
        this.star1 = star1;
    }
    
    public void setStar2(String star2) {
        this.star2 = star2;
    }

    @XmlElement( name = "template" )
    public void setTemplate(String template) {
        this.template = template;
    }
    
    public void setAimlFilePath(String aimlFilePath) {
        this.aimlFilePath = aimlFilePath;
    }

    public int getUsageCount() {
        return usageCount;
    }

    public String getPattern() {
        return pattern;
    }

    public String getStar1() {
        return star1;
    }

    public String getStar2() {
        return star2;
    }

    public String getTemplate() {
        return template;
    }

    public String getAimlFilePath() {
        return aimlFilePath;
    }

    @Override
    public String toString() {
        return "AIMLCategory{" + "usageCount=" + usageCount + ", pattern=" + pattern + ", star1=" + star1 + ", star2=" + star2 + ", template=" + template + ", aimlFilePath=" + aimlFilePath + '}';
    }
    
    
    
}
