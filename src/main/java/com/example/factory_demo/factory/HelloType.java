package com.example.factory_demo.factory;

public enum HelloType {
    HELLO_WORLD("Hello World", "HELLO_WORLD"),
    HELLO_YAN("Hello YAN", "HELLO_YAN");
    private String name;
    private String value;


    HelloType(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
