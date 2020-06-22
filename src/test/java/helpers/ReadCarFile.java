package helpers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadCarFile {

    public List<String> readFileFromPath (String filePath) throws IOException {

        List<String> listOfCarRegistrations = new ArrayList<String>();

        File file = new File(filePath);

        BufferedReader bufferedFile = new BufferedReader(new FileReader(file));

        String lineToBeParsed;
        while ((lineToBeParsed = bufferedFile.readLine()) != null) {

            List<String> regsFromFileLine = parseCarRegistrations(lineToBeParsed);
            listOfCarRegistrations.addAll(regsFromFileLine);
        }

        return listOfCarRegistrations;
    }

    public List<String> parseCarRegistrations (String fileLine) {

        //for the purposes of this parsing we will assume
        // that multiple spaces between the two parts of the registration code,
        // or that any characters may occur adjacent to the registration
        // as a result of typos.
        List<String> listOfCarRegistrationsFromFileLine = new ArrayList<String>();

        Pattern carRegParsePattern =
                Pattern.compile("(\\w{2}\\d{2}\\s*\\w{3})");

        Matcher regMatch = carRegParsePattern.matcher(fileLine);

        while(regMatch.find()){

            //delete any spaces from the registration
            String regWithNoSpace = regMatch.group().replaceAll("\\s+","");
            listOfCarRegistrationsFromFileLine.add(regWithNoSpace);
        }


        return listOfCarRegistrationsFromFileLine;
    }


}
