/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Chess.AI;

// Import libraries
import Chess.Game.Pieces.Bishop;
import Chess.Game.Pieces.Queen;
import Chess.Game.Pieces.Rook;
import Chess.Game.Pieces.Knight;
import Chess.Game.Pieces.Pawn;
import Chess.Game.Pieces.King;
import Chess.Game.State.GameState;
import java.util.ArrayList;
import javax.swing.JButton;
import java.awt.Color;

/**
 *
 * @author Alec
 */
public class Game_Tree {
 
    public class Node{
        Game_Tree[] children;
        int num_children;
        GameState state;
        float value;
        int previous;
        int current;
    }
    
    public Node root;
    
    public Game_Tree(GameState state,int depth, float utility,int previous,int current){
        
           root = new Node();
           root.state = state;
           root.value = utility;
           root.previous = previous;
           root.current = current; 
        
       if(depth < 3){
           
           
           ArrayList<ArrayList<JButton>> children = new ArrayList(); 
           ArrayList<Float> utilities = new ArrayList();
           ArrayList<Integer> start_indeces = new ArrayList();
           ArrayList<Integer> end_indeces = new ArrayList();
           Color piece_color;
           if(depth % 2 == 0)
               piece_color = Color.BLACK;
           else
               piece_color = Color.WHITE;
           
           for(int i = 0;i < 64 ; i++){
               if(state.array_board[i].getForeground() == piece_color){
                   ArrayList<ArrayList<Integer>> legal_moves = 
                                                 get_moves(state.array_board,i);
                   for(int j = 0;j < legal_moves.get(0).size(); j++){
                       children.add(get_boards(state.array_board, i, legal_moves.get(0).get(j)));
                       if(depth % 2 == 0)
                           utilities.add(score(list_to_array(children.get(children.size()-1)),i));
                       else
                           utilities.add((-1)*score(list_to_array(children.get(children.size()-1)),i));
                       
                       start_indeces.add(i);
                       end_indeces.add(legal_moves.get(0).get(j));
                   }
                   for(int j =0;j < legal_moves.get(1).size(); j++){
                       children.add(get_boards(state.array_board, i, legal_moves.get(1).get(j)));
                       if(depth % 2 == 0)
                           utilities.add(score(list_to_array(children.get(children.size()-1)),i));
                       else
                           utilities.add((-1)*score(list_to_array(children.get(children.size()-1)),i));
                       start_indeces.add(i);
                       end_indeces.add(legal_moves.get(1).get(j));
                   }
               }
           }

           root.num_children = children.size();
           root.children = new Game_Tree[root.num_children];
           
           for(int i = 0;i < children.size();i++){
               GameState child = new GameState();
               child.set_array_board(list_to_array(children.get(i)));
               Game_Tree sub_tree = new Game_Tree(child, depth + 1,utilities.get(i),start_indeces.get(i), end_indeces.get(i));
               root.children[i] = sub_tree;
           }    
       }
       else{
           root.num_children = 0;
       }
       
    }
    
    public ArrayList<ArrayList<Integer>> get_moves(JButton[] board,
                                                   int start_index){
        
        // Declare arrays to hold legal moves
        ArrayList<ArrayList<Integer>> legal_moves = new ArrayList();
        legal_moves.add(new ArrayList());
        legal_moves.add(new ArrayList()); 
        
        // Declare color for coloring a new piece
        Color piece_color;
        piece_color = Color.BLACK;
 
        String buttonText = board[start_index].getText();
            switch(buttonText){
                case "\u2659":
                    Pawn new_pawn = new Pawn(buttonText,piece_color,root.state,start_index);
                    legal_moves = new_pawn.get_moves();
                    break;
                case "\u2656":
                    Rook new_rook = new Rook(buttonText,piece_color,root.state,start_index);
                    legal_moves = new_rook.get_moves();
                    break;
                case "\u2657":
                    Bishop new_bishop = new Bishop(buttonText,piece_color,root.state,start_index);
                    legal_moves = new_bishop.get_moves();
                    break;
                case "\u2655":
                    King new_king = new King(buttonText,piece_color,root.state,start_index);
                    legal_moves = new_king.get_moves();
                    break;
                case "\u2654":
                    Queen new_queen = new Queen(buttonText,piece_color,root.state,start_index);
                    legal_moves = new_queen.get_moves();
                    break;
                case "\u2658":
                    Knight new_knight = new Knight(buttonText,piece_color,root.state,start_index);
                    legal_moves = new_knight.get_moves();
               }       
        
       return legal_moves;
        
    }
    
    public ArrayList<JButton> get_boards(JButton[] previous, int start_index, int end_index){
        
        ArrayList<JButton> board = array_to_list(previous);
//        if(previous[end_index].getText().equals("")){
            JButton temp = board.get(start_index);
            board.set(start_index,board.get(end_index));
            board.set(end_index,temp);
//        }
//        else{
//            System.out.println(start_index + "  " + previous[end_index].getText());
//            JButton temp = board.get(start_index);
//            temp.setText("");
//            board.set(end_index,previous[start_index]);
//            board.set(start_index,temp);
//            
//        }
        
        return board;
    }
    
    public float score(JButton[] board,int index){
        
        String buttonText = board[index].getText();
        switch(buttonText){
                case "\u2659": // pawn
                    return 1;
                case "\u2656": // Rook
                    return 5;
                case "\u2657": // Bishop
                    return 3;
                case "\u2655": // King
                    return 1000;
                case "\u2654": // Queen
                    return 8;
                case "\u2658": // Knight
                    return 3;
                default:
                    return 0;
            }
        
    }
    
    public int[] evaluate(Node start){
        
        int move_pair[] = new int[2];
        int max_index = 0;
        float max = chain(start.children[0].root);
        float score = 0;
        
        for(int i = 0;i < start.num_children; i++){
            score = chain(start.children[i].root);
            //System.out.println(i + "  " + score);
            if(score > max){
                max = score;
                max_index = i;
            }
        }
        move_pair[0] = start.children[max_index].root.previous;
        move_pair[1] = start.children[max_index].root.current;
        return move_pair;
        
    }
    
    public float chain(Node start){
        
        float score = 0;
        float max = -100000;
        int max_index = 0;
        
        for(int i = 1;i < start.num_children; i++){
              if(start.children[i].root.num_children != 0){
                   score = start.value + chain(start.children[i].root);
              }
              else{
                  return start.value;
              }
              if(score > max){
                  max = score;
              }
        }

        return max;
        
    }
    
    public JButton[] list_to_array(ArrayList<JButton> j_list){
        
        JButton[] j_array = new JButton[64];
        for(int i=0;i < 64;i++){
            j_array[i] = j_list.get(i);
        }
        
        return j_array;
        
    }
    
    public ArrayList<JButton> array_to_list(JButton[] j_array){
        
        ArrayList<JButton> j_list = new ArrayList();
        for(int i=0;i<64;i++){
            j_list.add(j_array[i]);    
        }
        
        return j_list;
        
    }
    
    public void print_board(JButton[] board){
        
        for(int i = 0;i < 64; i++){
            System.out.print(board[63-i].getText().equals("")? "#* " : board[63-i].getText()+ " ");
            if(i % 8 == 7){
                System.out.print("\n");
            }
        }
        
        System.out.print("______________________\n");
        
    }
}
