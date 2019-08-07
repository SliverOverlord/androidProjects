package edu.mnstate.rm8834yy.denioa4recyclerview;

public class Puppies {
    private String Name;
    private String size;
    private String hairType;

    public Puppies(String name, String size, String hairType) {
        Name = name;
        this.size = size;
        this.hairType = hairType;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getHairType() {
        return hairType;
    }

    public void setHairType(String hairType) {
        this.hairType = hairType;
    }
}
