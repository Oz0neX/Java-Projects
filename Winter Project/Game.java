import java.util.Scanner;
import java.io.IOException;
import java.lang.Math;

class Game {
    private static Scanner scan;

    public Game() {
        clearScreen();
        scan = new Scanner(System.in);
        
        System.out.println("NOTE: When you start this game, how quickly you respond to events will have an impact on the outcome.\n");
        if (!yesNoPrompt(scan)) {
            closingMessage();
        }

        clearScreen();
        System.out.println("Loading Assets...\n");
        // Initialize everything here
        Player player = new Player();
        player.setChief(Art.blue + "Charles" + Art.reset);
        player.promptTitle();
        Events events = new Events(player);

        // Start Game        
        clearScreen();
        Event ci = events.getEventByTitle("ChiefIntroduction");
        player.setName(ci.activate());
        
        clearScreen();
        System.out.println(player.getChief() + ": I present to you, your throne\n\n" + Art.throne + "\n\nIt's been passed down from generations of kings and queens the likes of yourself. Make yourself at home.\n\n*The Chief walks away*");
        player.addGoldPieces(1000);
        player.addReputation(100);
        clickEnterToContinue();
        
        clearScreen();
        player.newDay();
        Event be = events.getEventByTitle("Beggar");
        be.activate();
        clearScreen();
        System.out.println(Art.blue + player.getChief() + ":" + Art.reset + " My " + player.getTitle() + ", I'm sure you've noticed by now, but the decisions you make will have an impact on our kingdom's future.\n\nIt is your royal duty to keep our resources at balance and maintain a strong public figure.\nI apologize for telling you how to do your job, but I will always be here to advise you when times get tough.");
        clickEnterToContinue();
        clearScreen();
        // A random number of random events are activated before continuing with the storyline
        for (int i = 0; i < (int) (Math.random() * 8) + 2; i++) {
            Event e = events.getRandomEvent();
            //System.out.println(e.getName() + " " + e.isRandomEvent());
            //clickEnterToContinue();
            e.activate();
            clearScreen();
            if (i % ((int) (Math.random() * 3) + 2) == 0) {
                player.newDay();
            }
        }
        clearScreen();
        System.out.println(player.getChief() + ": My " + player.getTitle() + " your doing great so far my king! If you can keep this up for just a few more days, we will be a successful kingdom.\nIt is an honor serving under you " + player.getTitle() + " " + player.getName());
        clickEnterToContinue();
        clearScreen();
        for (int i = 0; i < (int) (Math.random() * 8) + 2; i++) {
            Event e = events.getRandomEvent();
            e.activate();
            clearScreen();
        }
        if (events.getEventByTitle("CharlesBetrayal").canActivate(player)) {
            events.getEventByTitle("CharlesBetrayal").activate();
        }
        System.out.println(player.getChief() + ": We're almost there " + player.getTitle() + " " + player.getName() + " just a few more days!");
        for (int i = 0; i < (int) (Math.random() * 8) + 2; i++) {
            Event e = events.getRandomEvent();
            e.activate();
            clearScreen();
        }
        player.setEnding("Everyone lived peacefully under your rule and the Kingdom continued to thrive", "Successful Kingdom");
        Game.end();
    }

    public static void end() {
        Player player = Player.getPlayer();
        clearScreen();
        player.printEnding();
        System.out.print("\n\n");
        closingMessage();
        System.exit(0);
    }

    public static boolean yesNoPrompt(Scanner scan) {
        System.out.print("Do you wish to continue? [Y/N]: ");
        return inputReader("y", "yes");
    }

    // If a passed string is the user's input, this function returns true. Otherwise returns false.
    public static boolean inputReader(String... args){
        String input = scan.nextLine();
        input = input.toLowerCase();
        for (int i = 0; i < args.length; i++) {
            if (args[i].toLowerCase().equals(input)) {
                return true;
            }
        }
        return false;
    }

    // Demands user of the argument results. If not given, it will not allow the user to continue.
    public static String prompt(String prompt, String... args) {
        if (args[0].equals("*")) { // Any input is allowed, just checks if its greater than 0
            while (true) {
                System.out.print(prompt);
                String input = scan.nextLine();
                if (input.length() > 0) {
                    return input;
                }

                System.out.print("\nERROR! Invalid Input \nPlease enter valid input and try again");
                clickEnterToContinue();
                clearScreen();
            }
        }
        while (true) {
            System.out.print(prompt);
            String input = scan.nextLine();
            for (int i = 0; i < args.length; i++) {
                if (input.toLowerCase().equals(args[i])) {
                    return input;
                }
            }
            System.out.print("\nERROR! Invalid Input \nPlease enter valid input and try again \n\n"+Art.blue+"[ PRESS ENTER TO CONTINUE ]"+Art.reset);
            // Wait for ENTER
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            clearScreen();
        }
    }

    public static void clickEnterToContinue() {
        System.out.println("\n\n"+Art.grey+"[ PRESS ENTER TO CONTINUE ]"+Art.reset);
        // Wait for ENTER
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void clearScreen() {
        System.out.print("\033[2J\033[H");
    }

    public static void closingMessage() {
        System.out.println("Thank you for playing! Created by Me :)");
    }
    
}

// Just here if you want to check game line count
// find . -name '*.java' | xargs wc -l
