/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Chess.GamePiece;

import java.awt.Color;
import java.util.ArrayList;
import Chess.Game.*;

public class Knight extends GamePiece{
    
    Color other_color;
    public Knight(String piece,Color piece_color,GameState state,int index){
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
        if(index>7){
            if(!((index+1)%8==0||(index+2)%8==0)){
               if(state.get_array_index(index-6).getText().equals("")){
                   legal_moves.get(0).add(index-6);
               } 
               if(state.get_array_index(index-6).getForeground().equals(other_color)){
                   legal_moves.get(1).add(index-6);
               }
            }
            if(!(index%8==0||(index-1)%8==0)){
                if(state.get_array_index(index-10).getText().equals("")){
                    legal_moves.get(0).add(index-10);
                }
                if(state.get_array_index(index-10).getForeground().equals(other_color)){
                    legal_moves.get(1).add(index-10);
                }
            }
        }
        if(index>15){
            if(!((index+1)%8==0)){
                if(state.get_array_index(index-15).getText().equals("")){
                    legal_moves.get(0).add(index-15);
                }
                if(state.get_array_index(index-15).getForeground().equals(other_color)){
                    legal_moves.get(1).add(index-15);
                }
            }
            if(!(index%8==0)){
                if(state.get_array_index(index-17).getText().equals("")){
                   legal_moves.get(0).add(index-17);
                }
                if(state.get_array_index(index-17).getForeground().equals(other_color)){
                    legal_moves.get(1).add(index-17);
                }
            }     
        }
        if(index<53){
            if(!((index+1)%8==0||(index+2)%8==0)){
                if(state.get_array_index(index+10).getText().equals("")){
                    legal_moves.get(0).add(index+10);
                }
                if(state.get_array_index(index+10).getForeground().equals(other_color)){
                    legal_moves.get(1).add(index+10);
                }
            }
            if(!(index%8==0||(index-1)%8==0)){
                if(state.get_array_index(index+6).getText().equals("")){
                    legal_moves.get(0).add(index+6);
                }
                if(state.get_array_index(index+6).getForeground().equals(other_color)){
                    legal_moves.get(1).add(index+6);
                }
            }
        }
        if(index<47){
            if(!(index%8==0)){
                if(state.get_array_index(index+15).getText().equals("")){
                    legal_moves.get(0).add(index+15);
                }
                if(state.get_array_index(index+15).getForeground().equals(other_color)){
                    legal_moves.get(1).add(index+15);
                }
            }
            if(!((index+1)%8==0)){
                if(state.get_array_index(index+17).getText().equals("")){
                   legal_moves.get(0).add(index+17);
                }
                if(state.get_array_index(index+17).getForeground().equals(other_color)){
                   legal_moves.get(1).add(index+17); 
                }
            }
            
        }
        return legal_moves;
    }
}
