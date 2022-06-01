/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package src.utility;


import src.soccer.Player;
import src.soccer.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author Administrator
 */
public class PlayerDatabase {

    String authorList =
        "Agatha Christie," +
        "Alan Patton," +
        "Alexander Solzhenitsyn," +
        "Arthur Conan Doyle," +
        "Anthony Trollope," +
        "Baroness Orczy," +
        "Brendan Behan," +
        "Brian Moore," +
        "Boris Pasternik," +
        "Charles Dickens," +
        "Charlotte Bronte," +
        "Dorothy Parker," +
        "Emile Zola," +
        "Frank O'Connor," +
        "Geoffrey Chaucer," +
        "George Eliot," +
        "G. K. Chesterton," +
        "Graham Green," +
        "Henry James," +
        "James Joyce," +
        "J. M. Synge," +
        "J. R. Tolkien," +
        "Jane Austin," +
        "Leo Tolstoy," +
        "Liam O'Flaherty," +
        "Marcel Proust," +
        "Mark Twain," +
        "Oscar Wilde," +
        "O. Henry," +
        "Samuel Beckett," +
        "Sean O'Casey," +
        "William Shakespeare," +
        "William Makepeace Thackeray," +
        "W. B. Yeats," +
        "Wilkie Collins";









    /* TODO Practice 11-2. Declare an ArrayList here */
    private  List<Player> players;

    /* TODO Practice 11-2. Add Constructor here */
    public PlayerDatabase() {
        StringTokenizer authorTokens= new StringTokenizer(this.authorList,",");
        this.players = new ArrayList<>();
        while (authorTokens.hasMoreTokens()){
            players.add(new Player(authorTokens.nextToken()));
        }
    }
    /* TODO Practice 11-2. Add getTeam() method here */
    public Player[] getTeam(int numberOfPlayers){
        Player[] players = new Player[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers;i++){
            int playerIndex = (int) Math.random() * this.players.size();
            players[i] = this.players.get(playerIndex);
            this.players.remove(playerIndex);
        }
        return players;
    }
}
