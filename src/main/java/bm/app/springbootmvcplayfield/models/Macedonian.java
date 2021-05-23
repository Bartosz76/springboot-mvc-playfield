package bm.app.springbootmvcplayfield.models;

public class Macedonian {

    private String name;
    private int age;
    private String unitType;

    public Macedonian(String name, int age, String unitType) {
        this.name = name;
        this.age = age;
        this.unitType = unitType;
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
