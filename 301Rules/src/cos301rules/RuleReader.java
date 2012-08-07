package cos301rules;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class RuleReader {

    private String confFileName = "ABSARules.ini";
    private String[] tokenedRules = null;

    public void iniRules() throws IOException {
        File locationFile = new File("");
        String fileLocation = locationFile.getCanonicalPath().toString() + "\\" + confFileName;

        File toReadFile = new File(fileLocation);
        Scanner lineScanner = new Scanner(toReadFile);
        lineScanner.useDelimiter(" ");

        int size = this.rulesSize();
        tokenedRules = new String[size];

        for (int a = 0; a < size; a++) {
            tokenedRules[a] = lineScanner.next();
        }
    }

    private int rulesSize() throws IOException {
        int result = 0;

        File locationFile = new File("");
        String fileLocation = locationFile.getCanonicalPath().toString() + "\\" + confFileName;

        File toReadFile = new File(fileLocation);
        Scanner lineScanner = new Scanner(toReadFile);
        lineScanner.useDelimiter(" ");

        while (lineScanner.hasNext()) {
            result += 1;
            lineScanner.next();
        }
        return result;
    }

    public String getConfFileName() {
        return confFileName;
    }

    public String[] getTokenedRules() {
        return tokenedRules;
    }
}
