/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Chess.PlayerData;

import java.io.Serializable;
import javax.swing.*;

/**
 *
 * @author rcc
 */
public class GameStateSerializable implements Serializable {
    private int turns;
    private boolean player_turn;
    private int select_index;
    private int move_index;
    private JButton chosen_piece;
    private JButton previous_piece;
    public JButton array_board[];
    
    // no-argument contructor calls other contstructor w/ default values
    public GameStateSerializable() {
        // default
        this( 0, false, 0, 0, null, null, new JButton[64]);
    } // end no-argument constructor
    
    // seven-argument constructor : initializes a record
    public GameStateSerializable(int _turns, boolean _player_turn, int _select_index,
            int _move_index, JButton _chosen_piece, JButton _previous_piece,
            JButton _array_board[]) {
        setTurns( _turns );
        setPlayer_turn( _player_turn );
        setSelect_index( _select_index );
        setMove_index( _move_index );
        setChosen_piece( _chosen_piece );
        setPrevious_piece( _previous_piece );
        setArray_board( _array_board );
    } // end seven-argument constructor

    // setter and getter functions for each record
    public void setTurns(int turns) {
        this.turns = turns;
    }
    
    public int getTurns() {
        return turns;
    }

    public void setPlayer_turn(boolean player_turn) {
        this.player_turn = player_turn;
    }

    public boolean getPlayer_turn() {
        return player_turn;
    }
    
    public void setSelect_index(int select_index) {
        this.select_index = select_index;
    }
    
    public int getSelect_index() {
        return select_index;
    }
    
    public void setMove_index(int move_index) {
        this.move_index = move_index;
    }
    
    public int getMove_index() {
        return move_index;
    }

    public void setChosen_piece(JButton chosen_piece) {
        this.chosen_piece = chosen_piece;
    }
    
    public JButton getChosen_piece() {
        return chosen_piece;
    }
    
    public void setPrevious_piece(JButton previous_piece) {
        this.previous_piece = previous_piece;
    }
    
    public JButton getPrevious_piece() {
        return previous_piece;
    }

    public void setArray_board(JButton[] array_board) {
        this.array_board = array_board;
    }
    
    public JButton[] getArray_board() {
        return array_board;
    }
} // end class GameStateSerializable
