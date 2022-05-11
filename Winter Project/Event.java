import java.io.IOException;

class Event {
    // The event class can be any event triggered, it will feature methods to alter the players wealth and reputation, as well as create a chance for another event randomly later.
    private String name, header, prompt;
    private String[] promptResponses;
    private int timeLimit, timesOccurred, stage, minRep, minGold, maxRep, maxGold;
    private boolean random, hasPrompt, inTime, enabled;

    public Event() {
        this("Default", 0, false);
    }

    public Event(String n, int t) {
        this(n, t, false);
    }

    public Event(String n, boolean r) {
        this(n, 0, r);
    }

    public Event(String n, int t, boolean r) {
        this.name = n;
        this.timeLimit = t;
        this.random = r;
        this.timesOccurred = 0;
        this.stage = 0;
        this.hasPrompt = false;
        this.enabled = true;
    }
    
    // The activate method checks if the user responds to the event correctly within the alotted time.
    // Returns boolean of user consequence, true for positive, false for negative.
    public String activate() {
        Player player = Player.getPlayer();
        if (hasPrompt) {
            this.timesOccurred += 1;
            long startTime = System.nanoTime();

            System.out.print(header + "\n");
            player.printStats();
            String result = Game.prompt(prompt, promptResponses);

            long endTime = System.nanoTime();
            long duration = ((endTime - startTime) / 1000000); // In milliseconds
            if (duration > timeLimit) {
                this.inTime = false;
            } else {
                this.inTime = true;
            }

            Events.chance(this, result.toLowerCase());
            return result;
        }
        
        // No prompt, just print header and press spacebar to continue
        System.out.print(header);
        player.printStats();
        Events.chance(this, "");
        Game.clickEnterToContinue();
        return "";
    }
    
    public void setName(String s) {
        this.name = s;
    }

    public void setStage(int n) {
        this.stage = n;
    }

    public void setRandomStatus(boolean b) {
        this.random = b;
    }

    public void setMinMaxGold(int min, int max) {
        this.minGold = min;
        this.maxGold = max;
    }

    public void setMinMaxRep(int min, int max) {
        this.minRep = min;
        this.maxRep = max;
    }

    // Event header when event is activated
    public void setEventHeader(String h) {
        this.hasPrompt = false;
        this.header = h;
    }

    // Event header and prompt when event is activated
    public void setEventHeader(String h, String p) {
        this.hasPrompt = true;
        this.header = h;
        this.prompt = p;
    }

    // Set the responses allowed for an event prompt.
    public void setPromptResponses(String... args) {
        this.promptResponses = args;
    }

    public String getName() {
        return name;
    }

    public int getStage() {
        return stage;
    }

    public void enable() {
        this.enabled = true;
    }

    public void disable() {
        this.enabled = false;
    }
    
    public boolean canActivate(Player p) {
        if (minGold > 0 || maxGold > 0) {
            if (!(p.getGoldPieces() > minGold && p.getGoldPieces() < maxGold)) {
                return false;
            }
        }
        if (minRep > 0 || maxRep > 0) {
            if (!(p.getReputation() > minRep && p.getReputation() < maxRep)) {
                return false;
            }
        }
        if (enabled) {
            return true;
        }
        return false;
    }

    public boolean isRandomEvent() {
        return random;
    }

    public boolean isOnTime() {
        return inTime;
    }
}
