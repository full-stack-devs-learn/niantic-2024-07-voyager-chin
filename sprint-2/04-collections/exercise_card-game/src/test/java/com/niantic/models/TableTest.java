package com.niantic.models;

import com.niantic.application.CardGameApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TableTest {

    Table table = new Table();

    @Test
    public void playedCards_shouldAssign_correctPlayerAndCard()
    {
        // Arrange
        Player expectedBotPlayer = new Player("-Ultron-");
        Player expectedUserPlayer = new Player("Spongebob");
        Card expectedBotCard = new Card(8);
        Card expectedUserCard = new Card(22);

        // Act
       table.playedCards(expectedBotPlayer, expectedBotCard);
       table.playedCards(expectedUserPlayer, expectedUserCard);

       Player actualBotPlayer = table.botPlayer;
       Player actualUserPlayer = table.userPlayer;
       Card actualBotCard = table.botCard;
       Card actualUserCard = table.playerCard;

        // Assert
        assertSame(expectedBotPlayer, actualBotPlayer);
        assertSame(expectedUserPlayer, actualUserPlayer);
        assertSame(expectedBotCard, actualBotCard);
        assertSame(expectedUserCard, actualUserCard);
    }

    @Test
    public void addToRow_shouldAdd_cardsToRows()
    {
        // Arrange
        Card expectedCardA = new Card(5);
        Card expectedCardB = new Card(12);
        Card expectedCardC = new Card(18);
        Card expectedCardD = new Card(23);

        // Act
        table.addToRowA(expectedCardA);
        table.addToRowB(expectedCardB);
        table.addToRowC(expectedCardC);
        table.addToRowD(expectedCardD);

        Card actualCardA = table.rowA.getLast();
        Card actualCardB = table.rowB.getLast();
        Card actualCardC = table.rowC.getLast();
        Card actualCardD = table.rowD.getLast();

        // Assert
        assertSame(expectedCardA, actualCardA);
        assertSame(expectedCardB, actualCardB);
        assertSame(expectedCardC, actualCardC);
        assertSame(expectedCardD, actualCardD);
    }

    @Test
    public void placeCardsToRow_shouldAdd_cardsToCorrectRows()
    {
        // Arrange
        // Setup table cards
        Card card5 = new Card(5);
        Card card18 = new Card(18);
        Card card23 = new Card(23);
        Card card12 = new Card(12);
        table.addToRowA(card5);
        table.addToRowB(card18);
        table.addToRowC(card23);
        table.addToRowD(card12);
        // Player turns
        Player player1 = new Player("-Ultron-");
        Player player2 = new Player("Spongebob");
        Card player1Card = new Card(20);
        Card player2Card = new Card(15);
        int expectedLastCardRowA = card5.getValue();
        int expectedLastCardRowB = player1Card.getValue();
        int expectedLastCardRowC = card23.getValue();
        int expectedLastCardRowD = player2Card.getValue();

        // Act
        table.playedCards(player1, player1Card);
        table.playedCards(player2, player2Card);
        table.placeCardsToRow();
        int actualLastCardRowA = table.getRowEndCardA().getValue();
        int actualLastCardRowB = table.getRowEndCardB().getValue();
        int actualLastCardRowC = table.getRowEndCardC().getValue();
        int actualLastCardRowD = table.getRowEndCardD().getValue();

        // Assert
        assertSame(expectedLastCardRowA, actualLastCardRowA);
        assertSame(expectedLastCardRowB, actualLastCardRowB);
        assertSame(expectedLastCardRowC, actualLastCardRowC);
        assertSame(expectedLastCardRowD, actualLastCardRowD);
    }
}
