package testowe.TestyjednostkoweDlabibliotekiJava;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubstringTest {

    String string = "Dzban";


    @Test
    void shouldReturnFirstCharacter(){
     // stworzyc substring
     String result =  string.substring(0, 1);

     assertEquals("D", result);
     assertThat(result)
             .isEqualTo("D")
             .isEqualToIgnoringCase("d")
             .hasSize(1);


    }

}
