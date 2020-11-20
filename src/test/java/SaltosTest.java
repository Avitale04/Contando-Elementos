import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;

import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SaltosTest {

    @Mock
    HojaCercana hojaCercana;

    @InjectMocks
    Saltos saltos;

    @Before
    public void init(){
        reset(hojaCercana);
        when(hojaCercana.hojaMasCercana(eq(5))).thenReturn(true);
        when(hojaCercana.hojaMasCercana(eq(0))).thenReturn(false);
    }

    @Test
    public void LaRanaSaltaEnLaHoja6() {

        //given
        int[] hojas = {0,0,0,0,0,0,5,0,0,0,0};

        //when
        int brincar = saltos.momentoDeSaltar(hojas);

        //then
        assertEquals(6,brincar);
        verify(hojaCercana,times(1)).hojaMasCercana(eq(5));
        verify(hojaCercana,times(6)).hojaMasCercana(eq(0));

    }

    @Test
    public void LaRanaSaltaEnLaUltimaHoja() {

        //given
        int[] hojas = {0,0,0,0,0,0,0,0,0,0,5};

        //when
        int brincar = saltos.momentoDeSaltar(hojas);

        //then
        assertEquals(10,brincar);
        verify(hojaCercana,times(1)).hojaMasCercana(eq(5));
        verify(hojaCercana,times(10)).hojaMasCercana(eq(0));

    }

    @Test
    public void LaRanaSaltaEnLaPrimeraHoja() {

        //given
        int[] hojas = {5,0,0,0,0,0,0,0,0,0,0};

        //when
        int brincar = saltos.momentoDeSaltar(hojas);


        //then
        assertEquals(0,brincar);
        verify(hojaCercana,times(1)).hojaMasCercana(eq(5));
        verify(hojaCercana,times(0)).hojaMasCercana(eq(0));

    }

    @Test
    public void LaRanaNuncaSalta() {

        //given
        int[] hojas = {0,0,0,0,0,0,0,0,0,0,0};

        //when
        int brincar = saltos.momentoDeSaltar(hojas);


        //then
        assertEquals(-1,brincar);
        verify(hojaCercana,times(0)).hojaMasCercana(eq(5));
        verify(hojaCercana,times(11)).hojaMasCercana(eq(0));

    }
    //prueba de branch pasada al master y prueba de reset
}