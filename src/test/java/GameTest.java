import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void firstPlayerToWin() {
        Player alex = new Player(14, "Alex", 475);
        Player sergei = new Player(13678, "Sergei", 243);
        Game game = new Game();

        game.register(alex);
        game.register(sergei);

        int actual = game.round("Alex", "Sergei");
        int expected = 1;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void secondPlayerToWin() {
        Player alex = new Player(14, "Алекс", 24);
        Player sergei = new Player(13678, "Сергей", 290);
        Game game = new Game();

        game.register(alex);
        game.register(sergei);

        int expected = 2;
        int actual = game.round("Алекс", "Сергей");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void equalStrengthAtBothPlayers() {
        Player alex = new Player(14, "Алекс", 290);
        Player sergei = new Player(13678, "Сергей", 290);
        Game game = new Game();

        game.register(alex);
        game.register(sergei);

        int expected = 0;
        int actual = game.round("Алекс", "Сергей");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void firstPlayerNotRegistered() {
        Player alex = new Player(14, "Алекс", 290);
        Player sergei = new Player(13678, "Сергей", 290);
        Game game = new Game();

        game.register(sergei);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Алекс", "Сергей"));
    }
    @Test
    public void secondPlayerNotRegistered() {
        Player alex = new Player(14, "Алекс", 290);
        Player sergei = new Player(13678, "Сергей", 290);
        Game game = new Game();

        game.register(alex);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Алекс", "Сергей"));
    }
}