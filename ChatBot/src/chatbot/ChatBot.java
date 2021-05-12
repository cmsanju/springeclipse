package chatbot;

/*
 * ChatBot is a simple chat bot that takes
 * console input and outputs preprogrammed 
 * responses which are found in the separate 
 * responses.txt file.
 */

import java.io.*;

class ChatBot {
    
    // Print menu to the console.
    private static void displayMenu(boolean startup) {
        if(startup) {
            System.out.println("Please enter a command.");
        }
        System.out.print("> ");
    }
    
    // Get total number of lines in filename.
    private static int getLines(String filename) {
        int lines = 0;
        
        try(BufferedReader br = new BufferedReader(
                new FileReader(filename))) {
            while(br.readLine() != null) lines++;
        } catch(IOException exc) {
            System.out.println("I/O Exception: " + exc);
        }
        
        return lines;
    }
    
    // Get user input from the console.
    private static String getUserInput() {
        String userInput = null;
        
        try {
            BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
            
            userInput = br.readLine();
        } catch(IOException exc) {
            System.out.println("I/O Exception: " + exc);
        }
        
        return userInput;
    }
    
    // Get all response lines from filename.
    private static String[] getResponsesArray(String filename, int lines) {
        int lineCount = 0;
        
        String line;
        String[] responsesArray = new String[lines];
        
        try(BufferedReader br = new BufferedReader(
                new FileReader(filename))) {
            
            do {
                line = br.readLine();
                
                if(line != null) {
                    responsesArray[lineCount] = line;
                    lineCount++;
                }
            } while(line != null);
        } catch(FileNotFoundException exc) {
            System.out.println("FileNotFoundException: " + exc);
        } catch(IOException exc) {
            System.out.println("I/O Exception: " + exc);
        }
        
        return responsesArray;
    }
    
    // Get ChatBot response given user-defined input command
    private static String getResponse(String[] responses, String userInput) {
        String tag, response;
        String[] array;
        
        for(String responseLine: responses) {
            if(responseLine != null) {
                array = responseLine.split(" - ");
                tag = array[0];
                response = array[1];
                
                if(tag.compareToIgnoreCase(userInput) == 0) {
                    return response;
                }
            }
        }
        
        return "No response...";
    }
    
    // Run ChatBot methods.
    public static void main(String args[]) {
        
        // Set program variables.
        String userInput, response;
        String filename = "src/responses.txt";
        
        int lines = getLines(filename);
        String[] responsesArray = getResponsesArray(filename, lines);
        
        // Display menu with startup message.
        displayMenu(true);
        
        // ChatBot loop.
        do {
            userInput = getUserInput();
            response = getResponse(responsesArray, userInput);
            
            System.out.println("Chatbot : " + response);

            if(!userInput.equals("bye")) {
                displayMenu(false);
            }
        } while(!userInput.equals("bye"));
    }
}