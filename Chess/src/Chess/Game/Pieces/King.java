/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Chess.Game.Pieces;

import Chess.Game.State.GameState;
import java.awt.Color;
import java.util.ArrayList;

public class King extends GamePiece{
    
    Color other_color;
    public King(String piece,Color piece_color,GameState state,int index){
        this.piece = piece;
        this.piece_color = piece_color;
        this.state = state;
        this.index = index;
        if(piece_color==Color.WHITE){
            other_color = Color.BLACK;
        }
        else{
            other_color = Color.WHITE;
        }
    }
    @Override
    public ArrayList get_moves(){
        
        ArrayList<ArrayList<Integer>> legal_moves = new ArrayList();
        legal_moves.add(new ArrayList());
        legal_moves.add(new ArrayList());
        
        if(index<56){
            if(state.get_array_index(index+8).getText().equals("")){
               legal_moves.get(0).add(index+8);
            }
            if(state.get_array_index(index+8).getForeground().equals(other_color)){
               legal_moves.get(1).add(index+8); 
            }
            if(!((index)%8==0)){
               if(state.get_array_index(index+7).getText().equals("")){
                    legal_moves.get(0).add(index+7);
                }
               if(state.get_array_index(index+7).getForeground().equals(other_color)){
                   legal_moves.get(1).add(index+7);
               }
            }
            if(!((index+1)%8==0)){
                if(state.get_array_index(index+9).getText().equals("")){
                    legal_moves.get(0).add(index+9);
                }
                if(state.get_array_index(index+9).getForeground().equals(other_color)){
                    legal_moves.get(1).add(index+9);
                }
            }
        }
        if(index>8){
            if(state.get_array_index(index-8).getText().equals("")){
                legal_moves.get(0).add(index-8);
            }
            if(state.get_array_index(index-8).getForeground().equals(other_color)){
                legal_moves.get(1).add(index-8);
            }
            if(!((index+1)%8==0)){
                if(state.get_array_index(index-7).getText().equals("")){
                    legal_moves.get(0).add(index-7);
                }
                if(state.get_array_index(index-7).getForeground().equals(other_color)){
                    legal_moves.get(1).add(index-7);
                }
            }
            if(!(index%8==0)){
                if(state.get_array_index(index-9).getText().equals("")){
                    legal_moves.get(0).add(index-9);
                }
                if(state.get_array_index(index-9).getForeground().equals(other_color)){
                    legal_moves.get(1).add(index-9);
                }
            }
        }
        if(!((index+1)%8==0)){
            if(state.get_array_index(index+1).getText().equals("")){
                legal_moves.get(0).add(index+1);
            }
            if(state.get_array_index(index+1).getForeground().equals(other_color)){
                legal_moves.get(1).add(index+1);
            }
        }
        if(!(index%8==0)){
            if(state.get_array_index(index-1).getText().equals("")){
                legal_moves.get(0).add(index-1);
            }
            if(state.get_array_index(index-1).getForeground().equals(other_color)){
                legal_moves.get(1).add(index-1);
            }
        }
        
        return legal_moves;
    }
}
