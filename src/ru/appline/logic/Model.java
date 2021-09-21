package ru.appline.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Model implements Serializable {
    private static  final Model instatnce = new Model();

    private final Map<Integer, User> model;

    public static Model getInstance(){
        return instatnce;
    }

    private Model(){
        model = new HashMap<>();

        model.put(1, new User("tom", "tomy", 6666));
        model.put(2, new User("tom2", "tomy", 777));
        model.put(3, new User("tom3", "tomy", 66));
        model.put(4, new User("tom4", "tomy", 655));
    }

    public void add(User user, int id){
        model.put(id, user);
    }

    public void delete(int id){
        model.remove(id);
    }

    public void put(User user, int id){
        model.put(id, user);
    }

    public Map<Integer, User> getFromList(){
        return model;
    }
}
