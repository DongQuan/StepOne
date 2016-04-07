package jxuan95;

/**
 * Created by jxuan on 16-4-7.
 * test
 */
public class Test {

    private int id;
    private String name;
    private Boolean gender;

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

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Test(int id, String name, Boolean gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }
}
