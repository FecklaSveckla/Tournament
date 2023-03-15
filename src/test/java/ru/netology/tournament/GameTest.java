package ru.netology.tournament;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.exception.NotRegisterException;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Game game = new Game();
    Player player1 = new Player( 1, "Petya", 10 );
    Player player2 = new Player( 2, "Kolya", 20 );
    Player player3 = new Player( 3, "Olya", 15 );
    Player player4 = new Player( 4, "Misha", 10 );

    @BeforeEach
    public void setUp() {

        game.register( player1 );
        game.register( player2 );
        game.register( player3 );
        game.register( player4 );
    }

    @Test
    void shouldShowResultWhenFirstPlayerIsStronger() {

        int expected = 1;
        int actual = game.round( "Kolya", "Olya" );

        Assertions.assertEquals( expected, actual );

    }

    @Test
    void shouldShowResultWhenSecondPlayerIsStronger() {

        int expected = 2;
        int actual = game.round( "Petya", "Kolya" );

        Assertions.assertEquals( expected, actual );

    }

    @Test
    void shouldShowResultWhenPlayersAreEqual() {

        int expected = 0;
        int actual = game.round( "Petya", "Misha" );

        Assertions.assertEquals( expected, actual );

    }



    @Test
    void shouldThrowNotRegisteredExceptionOne() {
        assertThrows( NotRegisterException.class, () -> {
            game.round( "Ivan", "Petya" );
        } );
    }

    @Test
    void shouldThrowNotRegisteredExceptionTwo() {
        assertThrows( NotRegisterException.class, () -> {
            game.round( "Kolya", "Ivan" );
        } );
    }


}