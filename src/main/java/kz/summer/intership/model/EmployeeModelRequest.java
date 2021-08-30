package kz.summer.intership.model;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EmployeeModelRequest {

    @NotNull(message="Fist name cannot be null")
    @Size(min = 2, max =16, message = "surname must be not less than two character")
    private String surname;

    @NotNull
    @Size(min = 2, message = "firstname must be not less than two character")
    private String firstname;

    @NotNull(message = "Электронная почта не может быть пустым")
    @Email
    private String email;

    @NotNull
    @Size(min = 2, message = "firstname must be not less than two characte")
    private String department;


    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
