package chatbot;

import java.util.*;
import java.util.logging.Logger;

public class TestBot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userInput = "";
        MyBot chatbot = new MyBot();
 
        while(!userInput.equalsIgnoreCase("stop it")) {
            System.out.println("User: ");
            userInput = sc.nextLine();
            chatbot.answer(userInput);
        }
        sc.close();
    }
}

