package com.example.office_web.utils.reflex;



public class Book implements ReflexInteface{

    private String id;

    private String name;


    private Book(String name, String id) {
        this.name = name;
        this.id = id;
    }


    public Book(){

    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int test(int i){
        return i;
    }
}
