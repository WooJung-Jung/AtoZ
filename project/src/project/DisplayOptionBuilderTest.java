package project;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DisplayOptionBuilderTest {

    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void changeDisplayStrategy_ListDisplay_Obj_Test() {
        DisplayOptionBuilder displayOptionBuilder = new DisplayOptionBuilder();
        displayOptionBuilder.changeDisplayStrategy(true);
        Displayer obj = displayOptionBuilder.getPlayer();
        obj.Display(new ArrayList<>());

        assertEquals("Call ListDisplay", outputStreamCaptor.toString().trim());
    }

    @Test
    void changeDisplayStrategy_CountDisplay_Obj_Test() {
        DisplayOptionBuilder displayOptionBuilder = new DisplayOptionBuilder();
        displayOptionBuilder.changeDisplayStrategy(false);
        Displayer obj = displayOptionBuilder.getPlayer();
        obj.Display(new ArrayList<>());

        assertEquals("Call CountDisplay", outputStreamCaptor.toString().trim());
    }

}