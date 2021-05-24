package co.escuelaing.edu.demosecuritylife;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Class to generate hash of passwords
 */
public class PasswordService {

    /**
     * Generate hash of password SHA
     * @param pass password to be hashed
     * @return password hashed
     */
    public static  String hashPass(String pass){
        MessageDigest mDigest = null;
        try {
            mDigest = MessageDigest.getInstance("SHA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] result = mDigest.digest(pass.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

    /**
     * Validate if a hash is valid
     * @param pass password to be validated
     * @return Success if it is valid , Fail if not
     */
    public static String validateHash(String pass){
        if(pass.equals("7288edd0fc3ffcbe93a0cf06e3568e28521687bc")){
            return  "Success";
        }
        else {
            return "Fail";
        }
    }

}