package project;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class DisplayerTest {

    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

    CountDisplayStrategy countDisplayStrategy = mock(CountDisplayStrategy.class);
    ListDisplayStrategy listDisplayStrategy = mock(ListDisplayStrategy.class);

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void CountDisplay_Mock_Test() {
        Displayer player = new Displayer();
        doNothing().when(countDisplayStrategy).Display(new ArrayList<>());
        player.setDisplayStrategy(countDisplayStrategy);
        player.Display(new ArrayList<>());
        verify(countDisplayStrategy,times(1)).Display(new ArrayList<>());
    }

    @Test
    void ListDisplay_Mock_Test() {
        Displayer player = new Displayer();
        doNothing().when(listDisplayStrategy).Display(new ArrayList<>());
        player.setDisplayStrategy(listDisplayStrategy);
        player.Display(new ArrayList<>());
        verify(listDisplayStrategy,times(1)).Display(new ArrayList<>());
    }

    @Test
    void CountDisplay_Obj_Test() {
        Displayer player = new Displayer();

        player.setDisplayStrategy(new CountDisplayStrategy());
        player.Display( new ArrayList<>());

        assertEquals("Call CountDisplay", outputStreamCaptor.toString().trim());
    }

    @Test
    void ListDisplay_Obj_Test() {
        Displayer player = new Displayer();

        player.setDisplayStrategy(new ListDisplayStrategy());
        player.Display(new ArrayList<>());

        assertEquals("Call ListDisplay", outputStreamCaptor.toString().trim());
    }

    @Test
    void setDisplayStrategy() {
    }
}