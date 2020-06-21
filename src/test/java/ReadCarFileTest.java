import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReadCarFileTest {

    @Test
    void parseCarRegistrationsCorrectNoSpace() {

        ReadCarFile rcf = new ReadCarFile();
        List<String> expectedResult = new ArrayList<String>();
        expectedResult.add("WR60DKU");
        String exampleLine = "this string contains a single car reg: WR60DKU";
        List<String> results = rcf.parseCarRegistrations(exampleLine);

        assert(results.equals(expectedResult));
    }

    @Test
    void parseCarRegistrationsCorrectWithSpace() {

        ReadCarFile rcf = new ReadCarFile();
        List<String> expectedResult = new ArrayList<String>();
        expectedResult.add("AX60VKB");
        String exampleLine = "this string contains a single car reg: AX60 VKB";
        List<String> results = rcf.parseCarRegistrations(exampleLine);

        assert(results.equals(expectedResult));
    }

    @Test
    void parseCarRegistrationsCorrectWithTyposAndExtraSpaces() {

        ReadCarFile rcf = new ReadCarFile();
        List<String> expectedResult = new ArrayList<String>();
        expectedResult.add("BV79HXD");
        String exampleLine = "this string contains a single car regBV79    HXD";
        List<String> results = rcf.parseCarRegistrations(exampleLine);

        assert(results.equals(expectedResult));
    }

    @Test
    void parseMultipleCarRegistrationsCorrectWithOrWithoutSpaces() {

        ReadCarFile rcf = new ReadCarFile();
        List<String> expectedResult = new ArrayList<String>();
        expectedResult.add("TH98FGH");
        expectedResult.add("PE12LNC");
        expectedResult.add("WE54HDS");
        String exampleLine = "this string contains multiple reg: TH98 FGH and also PE12 LNC finally WE54 HDS";
        List<String> results = rcf.parseCarRegistrations(exampleLine);

        assert(results.equals(expectedResult));
    }
}