public abstract class Person {
    // abstract because the system does not create a person only admin tech and customner
    private String name;
    private String email;
    private String dateOfBirth;

    public Person(String name, String email, String dateOfBirth) {
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void displayPersonData() {
        System.out.println("Name: " + name + " Email: " + email + " Date of Birth: " + dateOfBirth);
    }
}
