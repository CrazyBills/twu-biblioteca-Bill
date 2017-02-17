package com.twu.biblioteca.model;

public class User {

    String name;
    String account_id;
    String password;
    String email;
    String phone;
    Boolean isAdmin = false;

    public User(String name, String account_id, String password, String email, String phone, Boolean isAdmin) {
        this.name = name;
        this.account_id = account_id;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.isAdmin = isAdmin;
    }

    public User(String name, String account_id, String password, String email, String phone) {
        this(name, account_id, password, email, phone, false);
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getAccount_id() {
        return account_id;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!name.equals(user.name)) return false;
        if (!account_id.equals(user.account_id)) return false;
        if (!password.equals(user.password)) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (phone != null ? !phone.equals(user.phone) : user.phone != null) return false;
        return isAdmin != null ? isAdmin.equals(user.isAdmin) : user.isAdmin == null;

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + account_id.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (isAdmin != null ? isAdmin.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("name='").append(name).append('\'');
        sb.append(", account_id='").append(account_id).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        return sb.toString();
    }
}
