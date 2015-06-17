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
public class ReadDataFile {
    private ObjectInputStream input;
    
    // open file for gamestate data
    public void openFile(GameStateSerializable gamestate) {
        try // open file
        {
             input = new ObjectInputStream(new FileInputStream("gamestate_data.txt"));
        } // end try
        catch (IOException ie) {
            System.err.println("Error opening file.");
        } // end catch
    } // end method openFile
    
    // read record from option_data file
    public GameStateSerializable readRecords(GameStateSerializable gamestate) {
        GameStateSerializable record;
        
        try // input the values from the file
        {
            while(true) {
                record = (GameStateSerializable) input.readObject();
                return record;
            }// end while
        } // end try
        catch ( EOFException eofe) {
            return null; // end of file was reached
        } // end catch
        catch (ClassNotFoundException ce) {
            System.err.println("Unable to create object.");
        } // end catch
        catch (IOException ie) {
            System.err.println("Error during read from file");
        } // end catch
        return null;
    } // end method readRecords()
    
    // close file 
    public void closeFile() {
        try // close file and exit
        {
            if(input != null)
                input.close();
        } // end try
        catch (IOException ie) {
            System.err.println("Error closing file");
            System.exit(0);
        } // end catch
    } // end method closeFile
    
} // end cclass ReadDataFile
