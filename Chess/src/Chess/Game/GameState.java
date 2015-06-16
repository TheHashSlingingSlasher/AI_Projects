/*
 * Name: Alec Farfan, Jiwon Yoo, Luis Pena, Wenbo Yang
 * Date: 04/07/15
 * Purpose: Chess GameState Class
 */

package Chess.Game;

import javax.swing.JButton;
import java.util.ArrayList;

public class GameState {

    private boolean winner;
    private int turns;
    private boolean player_turn;
    private int select_index;
    private int move_index;
    private JButton chosen_piece;
    private JButton previous_piece;
    public JButton array_board[];
    private ArrayList<ArrayList<Integer>> move_array;
    
    public GameState(){
        winner = false;
        turns = 0;
        player_turn = false;
        move_index = 0;
        select_index = 0;
        chosen_piece = null;
        array_board = new JButton[64];
        
    }
    public void set_winner(boolean value){
        winner = value;
    }
    public boolean get_winner(){
        return winner;
    }
    public void set_turns(int new_turns){
        turns = new_turns;
        if(turns%2==0){
            player_turn = false;
        }
        else{
            player_turn = true;
        }
        
    }
    public int get_turns(){
        return turns;
    }
    public void set_player_turn(boolean new_turn){
        player_turn = new_turn;
    }
    public boolean get_player_turn(){
        return player_turn;
    }
    public void set_move_index(int new_index){
        move_index = new_index;
    }
    public int get_move_index(){
        return move_index;
    }
    public void set_select_index(int new_index){
        select_index = new_index;
    }
    public int get_select_index(){
        return select_index;
    }
    public void set_chosen_piece(JButton new_piece){
        chosen_piece = new_piece;
    }
    public JButton get_chosen_piece(){
        return chosen_piece;
    }
    
    public void set_previous_piece(JButton new_piece){
    
        previous_piece = new_piece;
    
    }
    
    public JButton get_previous_piece(){
    
        return previous_piece;
    
    }
    
    public void set_array_board(JButton[] array_board){
        
        this.array_board = array_board;
        
    }
    
    public JButton[] get_array_board(){
        
        return array_board;
    
    }
    
    public JButton get_array_index(int index){
        
        return array_board[index];
    
    }
    
    public void set_move_array(ArrayList<ArrayList<Integer>> legal_moves){
    
        move_array = legal_moves;
    
    }
    
    public ArrayList<ArrayList<Integer>> get_move_array(){
    
        return move_array;
    
    }
}
