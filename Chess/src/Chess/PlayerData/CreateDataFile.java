/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Chess.PlayerData;

import java.io.*;

/**
 *
 * @author rcc
 */
public class CreateDataFile {
    private ObjectOutputStream output; // outputs data to file
    private GameStateSerializable game_state_record; // obj to be written to file
    
    // open file for gamestate data
    public void openFile(GameStateSerializable gamestate) {
        try // open file
        {
            output = new ObjectOutputStream(
                new FileOutputStream("gamestate_data.txt"));
        } // end try
        catch (IOException ie){
            System.err.println("Error opening file.");
        } // end catch
    } // end method openFile
    
    // add records to file for gamestate data
    public void addRecords(GameStateSerializable _record) {        
        try // output values to file
        {            
            game_state_record = new GameStateSerializable( _record.getTurns(),
                    _record.getPlayer_turn(), _record.getSelect_index(), _record.getMove_index(),
                    _record.getChosen_piece(), _record.getPrevious_piece(), _record.getArray_board() );
            output.writeObject(game_state_record);
        } // end try
        catch ( IOException ie ) {
            System.err.println("Error writing to file.");
            return;
        } // end catch
    } // end methd addRecords
    
    // close file
    public void closeFile() {
        try // close file
        {
            if( output != null )
                output.close();
        } // end try
        catch (IOException ie) {
            System.err.println("Error closing file");
            System.exit(0);
        } // end catch
    } // end method closeFile
} // end class CreateDataFile
