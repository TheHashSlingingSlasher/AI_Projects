/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Chess.Game.Pieces;

import Chess.Game.State.GameState;
import java.awt.Color;
import java.util.ArrayList;

public class Queen extends GamePiece{
    
    Color other_color;
    public Queen(String piece,Color piece_color,GameState state,int index){
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
        
        // Add horizontal-left movements to legal moves list
        boolean last = false;
        int i = index;
        while(!last){
            if((i+1)%8==0){
                last = true;
                break;
            }
            if(state.get_array_index(i+1).getText().equals("")){
                legal_moves.get(0).add(i+1);
            }
            if(state.get_array_index(i+1).getForeground()==other_color){
                legal_moves.get(1).add(i+1);
                last = true;
            }
            if(state.get_array_index(i+1).getForeground()==piece_color){
                last = true;
            }
            i++;
        }
        // Add horizontal-right movements to legal moves list
        i = index;
        last = false;
        while(!last){
            if(i%8==0){
                last = true;
                break;
            }
            if(state.get_array_index(i-1).getText().equals("")){
                legal_moves.get(0).add(i-1);
            }
            if(state.get_array_index(i-1).getForeground()==other_color){
                legal_moves.get(1).add(i-1);
                last = true;
            }
            if(state.get_array_index(i-1).getForeground()==piece_color){
                last = true;
            }
            i--;
        }
        // Add vertical-upward movements to legal moves list
        i = index;
        last = false;
        while(!last){
            if(i>55){
                last = true;
                break;
            }
            if(state.get_array_index(i+8).getText().equals("")){
                legal_moves.get(0).add(i+8);
            }
            if(state.get_array_index(i+8).getForeground()==other_color){
                legal_moves.get(1).add(i+8);
                last = true;
            }
            if(state.get_array_index(i+8).getForeground()==piece_color){
                last = true;
            }
            i += 8;
        }
        // Add vertical-downward movements to legal moves list
        i = index;
        last = false;
        while(!last){
            if(i<8){
                last = true;
                break;
            }
            if(state.get_array_index(i-8).getText().equals("")){
                legal_moves.get(0).add(i-8);
            }
            if(state.get_array_index(i-8).getForeground()==other_color){
                legal_moves.get(1).add(i-8);
                last = true;
            }
            if(state.get_array_index(i-8).getForeground()==piece_color){
                last = true;
            }
            i -= 8;
        }
        // Add horizontal-left movements to legal moves list
        last = false;
        i = index;
        while(!last){
            if((i+1)%8==0||i<8){
                last = true;
                break;
            }
            if(state.get_array_index(i-7).getText().equals("")){
                legal_moves.get(0).add(i-7);
            }
            if(state.get_array_index(i-7).getForeground()==other_color){
                legal_moves.get(1).add(i-7);
                last = true;
            }
            if(state.get_array_index(i-7).getForeground()==piece_color){
                last = true;
            }
            i -= 7;
        }
        // Add horizontal-right movements to legal moves list
        i = index;
        last = false;
        while(!last){
            if(i%8==0||i<8){
                last = true;
                break;
            }
            if(state.get_array_index(i-9).getText().equals("")){
                legal_moves.get(0).add(i-9);
            }
            if(state.get_array_index(i-9).getForeground()==other_color){
                legal_moves.get(1).add(i-9);
                last = true;
            }
            if(state.get_array_index(i-9).getForeground()==piece_color){
                last = true;
            }
            i -= 9;
        }
        // Add vertical-upward movements to legal moves list
        i = index;
        last = false;
        while(!last){
            if((i+1)%8==0||i>55){
                last = true;
                break;
            }
            if(state.get_array_index(i+9).getText().equals("")){
                legal_moves.get(0).add(i+9);
            }
            if(state.get_array_index(i+9).getForeground()==other_color){
                legal_moves.get(1).add(i+9);
                last = true;
            }
            if(state.get_array_index(i+9).getForeground()==piece_color){
                last = true;
            }
            i += 9;
        }
        // Add vertical-downward movements to legal moves list
        i = index;
        last = false;
        while(!last){
            if(i%8==0||i>56){
                last = true;
                break;
            }
            if(state.get_array_index(i+7).getText().equals("")){
                legal_moves.get(0).add(i+7);
            }
            if(state.get_array_index(i+7).getForeground()==other_color){
                legal_moves.get(1).add(i+7);
                last = true;
            }
            if(state.get_array_index(i+7).getForeground()==piece_color){
                last = true;
            }
            i += 7;
        }
        
        return legal_moves;
    }
}
