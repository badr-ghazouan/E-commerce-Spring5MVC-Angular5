package pojos;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Concept {

    private String definition;
    private String domain;
    private String parent;

    public Concept() {}

    public Concept(String definition, String domain, String parent) {
        this.definition = definition;
        this.domain = domain;
        this.parent = parent;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }
}
