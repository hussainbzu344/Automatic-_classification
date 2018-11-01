package com.edu.autoclass.bean;

public class Framework {
    private int id;
    private String name;
    private String coreLibrary;
    private int typeId;

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoreLibrary() {
        return coreLibrary;
    }

    public void setCoreLibrary(String coreLibrary) {
        this.coreLibrary = coreLibrary;
    }
}
