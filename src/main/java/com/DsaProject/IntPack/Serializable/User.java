package com.DsaProject.IntPack.Serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class User implements Serializable {

    transient String password;
    public void writeObject(ObjectOutputStream out) throws IOException
    {
        out.defaultWriteObject();
        String encryptedPassword = "encrypted" + password;

        out.writeObject(encryptedPassword);

    }

    public void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
    {
        in.defaultReadObject();

        String decryptedPassword = (String) in.readObject();

        this.password = decryptedPassword.replace("encrypted","");
    }
}
