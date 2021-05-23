package bm.app.springbootmvcplayfield.models;

import java.util.ArrayList;
import java.util.List;

public class Macedonian {

    private String name;
    private int age;
    private String unitType;
    private static List<Macedonian> macedonians = new ArrayList<>();

    static {
        macedonians.add(new Macedonian("Teukos", 24, "Phalangite"));
        macedonians.add(new Macedonian("Nikanor", 26, "Hetairoi"));
        macedonians.add(new Macedonian("Amyntas", 32, "Hypaspist"));
    }

    public Macedonian(String name, int age, String unitType) {
        this.name = name;
        this.age = age;
        this.unitType = unitType;
    }

    public static List<Macedonian> getMacedonians() {
        return macedonians;
    }

    public static void setMacedonians(List<Macedonian> macedonians) {
        Macedonian.macedonians = macedonians;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    @Override
    public String toString() {
        return "Macedonian{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", unitType='" + unitType + '\'' +
                '}';
    }
}
