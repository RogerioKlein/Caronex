/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apoio;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 *
 * @author roger
 */
public class Criptografia {

    public static String criptoMD5(String senha) {
        String senhacrip = "";
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
            senhacrip = hash.toString(16);
        } catch (Exception e) {

        }
        return senhacrip;
    }

}
