package cohortapp;

import org.json.simple.JSONObject;

public class Mentors {

    private String code;
    private String name;
    private String lastName;
    private String phoneNumber;
    private String email;

    public Mentors(JSONObject json) {

        code = (String) json.get("cohort");
        name = (String) json.get("name");
        lastName = (String) json.get("lastName");
        phoneNumber = (String) json.get("phoneNumber");
        email = (String) json.get("email");

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
