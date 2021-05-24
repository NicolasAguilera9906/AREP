package co.escuelaing.edu.demosecuritylife;

/**
 * Class that represents a User
 */
public class User {

    private String password;
    private String email;

    /**
     * Gets the password of the user
     * @return the password of the user
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user
     * @param password the password to be setted
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /***
     * Gets the email of the user
     * @return the email of the user
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the user
     * @param email email of the user
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
