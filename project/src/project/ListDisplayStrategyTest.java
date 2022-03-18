package project;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ListDisplayStrategyTest {

    ListDisplayStrategy strategy = mock(ListDisplayStrategy.class);

    @Test
    void CallListDisplayMethod() {
        doNothing().when(strategy).Display(new ArrayList<>());
        strategy.Display(new ArrayList<>());
        verify(strategy,times(1)).Display(new ArrayList<>());
    }
}