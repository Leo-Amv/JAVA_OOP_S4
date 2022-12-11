package ru.gb.oseminar4.data;

public class User {
    private String firstName;
    private String lastName;
    private final Long userId;
    private static Long id =0L;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userId = ++id;
    }

    public User(String firstName, String lastName, Long userId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + "\tuserId:\t"+userId;

    }
}
