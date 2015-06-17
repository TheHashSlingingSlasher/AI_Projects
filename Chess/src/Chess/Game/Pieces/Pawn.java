/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Chess.Game.Pieces;

import Chess.Game.State.GameState;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;

public class Pawn extends GamePiece{
    
    public Pawn(String piece,Color piece_color,GameState state,int index){
        this.piece = piece;
        this.piece_color = piece_color;
        this.state = state;
        this.index = index;
    }
    @Override
    public ArrayList get_moves(){
        
        ArrayList<ArrayList<Integer>> legal_moves = new ArrayList();
        legal_moves.add(new ArrayList());
        legal_moves.add(new ArrayList());
        if(piece_color==Color.WHITE){
            if(index<56){
                if(state.get_array_index(index+8).getText().equals("")){
                    legal_moves.get(0).add(index+8);
                }
                if(index<16&&state.get_array_index(index+16).getText().equals("")){
                    legal_moves.get(0).add(index+16);
                }
                if(!(index%8 == 0) && state.get_array_index(index+7).getForeground()==Color.BLACK){
                    legal_moves.get(1).add(index+7);
                }
                if(!((index+ 1 ) % 8 == 0) && state.get_array_index(index+9).getForeground()==Color.BLACK){
                    legal_moves.get(1).add(index+9);
                }     
            }
            
       }
       else{
           if(index>8){
               if(state.get_array_index(index-8).getText().equals("")){
                    legal_moves.get(0).add(index-8);
                }
                if(index>47&&state.get_array_index(index-16).getText().equals("")){
                    legal_moves.get(0).add(index-16);
                }
                if(!((index + 1) % 8 == 0) && state.get_array_index(index-7).getForeground()==Color.WHITE){
                    legal_moves.get(1).add(index-7);
                }
                if(!(index%8 == 0) && state.get_array_index(index-9).getForeground()==Color.WHITE){
                    legal_moves.get(1).add(index-9);
                }     
           }
                
       } 
        
        return legal_moves;
    }
    
}
