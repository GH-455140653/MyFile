import static org.junit.Assert.*;

import org.junit.Test;

public class HelloTextTest {

    @Test
    public void testCreateAndStoreUser() {
        HelloText helloText = new HelloText();
        helloText.save();
    }

    @Test
    public void testGet() {
        HelloText helloText = new HelloText();
        helloText.get();
    }

    @Test
    public void testUp() {
        HelloText helloText = new HelloText();
        helloText.up();
    }

    @Test
    public void testDel() {
        HelloText helloText = new HelloText();
        helloText.del();
    }
}
