package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class AccountIO {

    public double readAccounts(String filePath)throws FileNotFoundException{

        List<String> lines=InputOutputReader.readFile(filePath);
        return Double.parseDouble(lines.get(0));
    }
}
