package com.home_work.authentication;

public class UserAccount {
    private String name;
    private String password;

    public UserAccount (String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserAccount that = (UserAccount) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return password != null ? password.equals(that.password) : that.password == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder passwordSecret = new StringBuilder();
        for (int i = 0; i <password.length(); i++) {
            passwordSecret.append("*");
        }
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + passwordSecret + '\'' +
                '}';
    }
}

