package zcdl;

public class Person {
    private String name;
    private String userName;
    private String password;

    public Person(String name, String userName, String password) {
        this.name = name;
        this.userName = userName;
        this.password = password;
    }

    public Person(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "个人信息：{" +
                "姓名='" + name + '\'' +
                ", 用户='" + userName + '\'' +
                ", 密码='" + password + '\'' +
                '}';
    }
}
