/*
 * Name: Alec Farfan, Jiwon Yoo, Luis Pena, Wenbo Yang
 * Date: 04/07/15
 * Purpose: Chess GamePiece Class
 */

package Chess.Game.Pieces;

// Import libraries
import Chess.Game.State.GameState;
import java.awt.Color;
import javax.swing.JButton;
import java.util.ArrayList;

public abstract class GamePiece{

    String piece;
    Color piece_color;
    GameState state;
    int index;
    
    abstract ArrayList get_moves();
    
}