package cohortapp;

import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Students {

    private String cohort;
    private String name;
    private String lastName;
    private String phoneNumber;
    private String email;
    private ArrayList<Address> address;
    private String company;
    private String mentorCode;
    private ArrayList<Stages> stage;

    public Students(JSONObject json) {

        cohort = (String) json.get("cohort");
        name = (String) json.get("name");
        lastName = (String) json.get("lastName");
        phoneNumber = (String) json.get("phoneNumber");
        email = (String) json.get("email");

        address = new ArrayList<>();

        JSONArray addressArray = (JSONArray) json.get("address");
        for (int i = 0; i < addressArray.size(); i++) {
            JSONObject addressObj = (JSONObject) addressArray.get(i);
            address.add(new Address(addressObj));
        }

        company = (String) json.get("company");
        mentorCode = (String) json.get("mentorCode");

        stage = new ArrayList<>();

        JSONArray stageArray = (JSONArray) json.get("stages");
        for (Object stg : stageArray) {
            JSONObject st = (JSONObject) stg;
            stage.add(new Stages(st));
        }
    }

    public String getCohort() {
        return cohort;
    }

    public void setCohort(String cohort) {
        this.cohort = cohort;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getMentorCode() {
        return mentorCode;
    }

    public ArrayList<Address> getAddress() {
        return address;
    }

    public void setAddress(ArrayList<Address> adr) {
        this.address = adr;
    }

    public void setMentorCode(String mentorCode) {
        this.mentorCode = mentorCode;
    }

    public ArrayList<Stages> getStage() {
        return stage;
    }

    public void setStage(ArrayList<Stages> stage) {
        this.stage = stage;
    }

    //////////////////////////////////////////////INNER CLASS STAGES///////////////////////////////////////////////////////
    public class Stages {

        String stage;
        String status;

        public Stages(JSONObject stg) {

            stage = (String) stg.get("stage");
            status = (String) stg.get("status");

        }

        public String getStage() {
            return stage;
        }

        public void setStages(String stages) {
            this.stage = stages;
        }

        public String getstatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

//////////////////////////////////////////////////////////// INNER CLASS ADDRESS ////////////////////////////////////////////////
    public class Address {

        String streetName;
        String city;
        String state;
        String zipCode;

        public Address(JSONObject addr) {

            streetName = (String) addr.get("streetAddress");
            city = (String) addr.get("city");
            state = (String) addr.get("state");
            zipCode = (String) addr.get("zipCode");
        }

        public String getStreetName() {
            return streetName;
        }

        public void setStreetName(String streetName) {
            this.streetName = streetName;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }
    }
}
