import java.lang.ArrayIndexOutOfBoundsException;
import java.lang.NullPointerException;

class Player {
    private static Player player;
    private String name, title, ending, chief;
    private int reputation, days, goldPieces;
    public Event[][] calendar = new Event[2][2];
    
    public Player() {
        player = this;
        this.name = "Default";
        this.title = "Default";
        this.ending = "Default";
        this.chief = "Default";
        this.reputation = 0;
        this.days = 0;
        this.goldPieces = 0;
    }

    public void checkEnding() {
        if (goldPieces <= 0) {
            if (ending.equals("Default")) {
                this.setEnding("The kingdom is now peniless! There are riots everywhere and our enemies are going to conquer our territory! How could you let this happen???", "Peniless");
            }
            Game.end();
        } else if (reputation <= 0) {
            if (ending.equals("Default")) {
                this.setEnding("I'm afraid the people cannot bear you any longer my " + this.getTitle() + " the people have decided to execute you.", "Executed");
            }
            Game.end();
        }
    }

    public void promptTitle() {
        Game.clearScreen();
        String input = Game.prompt("Are you a King or Queen?: ", "k", "king", "q", "queen");
        switch (input.toLowerCase()) {
            case "k": player.setTitle("King");
            break;
            case "king": player.setTitle("King");
            break;
            case "q": player.setTitle("Queen");
            break;
            case "queen": player.setTitle("Queen");
            break;
        }
    }

    public void newDay() {
        this.days += 1;
        Game.clearScreen();
        System.out.println("You've lived to see another dawn\n\nDay: "+Art.blue+days+Art.reset);
        addGoldPieces(50);
        Game.clickEnterToContinue();
        Game.clearScreen();

        Event[][] newCalendar = new Event[calendar.length + 1][];
        for (int i = 0; i < calendar.length; i++) {
            newCalendar[i] = calendar[i];
        }
        newCalendar[calendar.length] = new Event[1];
        calendar = newCalendar;

        for (int i = 0; i < calendar[days].length; i++) {
            if (calendar[days][i] != null) {
                Events.getVisit(calendar[days][i]); // Allow all opening events that day to occur.
            }
        }
    }

    public void addEventOnDay(int d, Event event) {
        if (d < days) {
            System.out.println("ERROR addEventOnDay Broken.");
        }
        
        Event[][] newCalendar;
        try {
            newCalendar = new Event[d + 1][calendar[d].length + 1];
        } catch (ArrayIndexOutOfBoundsException e) {
            newCalendar = new Event[d + 1][1];
        }

        for (int i = 0; i < calendar.length; i++) { // For every day...
            // Insert the event array for every day inside the new calendar
            for (int x = 0; x < calendar[i].length; x++) {
                calendar[i][x] = event;
            }
        }

        calendar = newCalendar;
        calendar[d][calendar[d].length - 1] = event;
    }

    public void addGoldPieces(int gold) {
        this.goldPieces += gold;
        System.out.print(Art.bgreen + "\nGOLD +" + gold + Art.reset);
    }

    public void addReputation(int rep) {
        this.reputation += rep;
        System.out.print(Art.bgreen + "\nREPUTATION +" + rep + Art.reset);
    }

    public void removeGoldPieces(int gold) {
        this.goldPieces -= gold;
        System.out.print(Art.red + "\nGOLD -" + gold + Art.reset);
        this.checkEnding();
    }

    public void removeReputation(int rep) {
        this.reputation -= rep;
        System.out.print(Art.red + "\nREPUTATION -" + rep + Art.reset);
        this.checkEnding();
    }

    public void setName(String s) {
        this.name = s;
    }

    public void setTitle(String s) {
        this.title = s;
    }

    public void setEnding(String s, String e) {
        this.ending = s + "\n\n" + Art.nEndingAchieved + Art.yellow + e + Art.reset;
    }

    public void setChief(String s) {
        this.chief = s;
    }
    
    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getChief() {
        return chief;
    }

    public int getDays() {
        return days;
    }

    public int getGoldPieces() {
        return goldPieces;
    }

    public int getReputation() {
        return reputation;
    }
 
    public void printStats() {
        String goldDashes = "+";
        String repDashes = "";
        for (int i = 0; i < String.valueOf(goldPieces).length(); i++)
            goldDashes += "-";
        for (int i = 0; i < String.valueOf(reputation).length(); i++)
            repDashes += "-";
        System.out.print(goldDashes + "--------+--------------"+repDashes+"+\n| "+ Art.yellow + "Gold: " + goldPieces + Art.reset + " | "+ Art.green + "Reputation: " + reputation + Art.reset + " |\n"+ goldDashes + "--------+--------------" + repDashes + "+\n\n");
    }

    public void printEnding() {
        System.out.print(ending);
    }

    public static Player getPlayer() {
        return player;
    }
}
