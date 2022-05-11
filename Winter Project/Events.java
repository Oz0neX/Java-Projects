import java.lang.Math;

class Events {
    // This class contains each event that can be triggered by the User
    private static Events eventsObj;
    private Event[] events;
    private final int eventCount = 11;
    private static Player player;
    
    public Events(Player p) {
        eventsObj = this;
        this.events = new Event[eventCount];
        player = p;

        // Event 1
        events[0] = new Event("ChiefIntroduction", 10000, false);
        events[0].setEventHeader(
            Art.chief + "\n\nWelcome" + ", I am " + player.getChief() + ". Your Chief Commander and Head Advisor.\nFor us to be properly acquainted, it would be best for me to know your name as well.\n",
            "What shall I call you?: ");
        events[0].setPromptResponses("*");
        
        // Event 2
        events[1] = new Event("Beggar", 10000, true);
        events[1].setEventHeader(
            Art.beggar + "\n\n"+Art.nBeggar+": Hello your execellency! I am in need of some coins. I will pay you back!\n\n",
            "Lend the beggar some coins? [Y/N]: ");
        events[1].setPromptResponses("y", "yes", "n", "no");

        // Event 3
        events[2] = new Event("SupplyTroops", true);
        events[2].setEventHeader(
            player.getChief() + ": My " + player.getTitle() + "! Our troops are in need of funding, we need to supply them with the resources to defend our kingdom from our enemy adversaries!",
            "Fund kingdom troops? [Y/N]: ");
        events[2].setPromptResponses("y", "yes", "n", "no");

        // Event 4
        events[3] = new Event("KingdomTakeover", 15000, false);
        events[3].setEventHeader(
            "*Gunfire and Rumbling*\n\n" + player.getChief() + ": Our enemies are attacking!",
            "What shall we do? [Fight / Run / Surrender]: ");
        events[3].setPromptResponses("f", "fight", "r", "run", "s", "surrender");
        events[3].disable();

        // Event 5
        events[4] = new Event("CharlesBetrayal", 0, true);
        events[4].setEventHeader(
            player.getChief() + ": Did you really think I ENJOYED serving under you? How foolish of you.\n\nI'm afraid we must part ways here. I have a kingdom to rule\n\n");
        events[4].setMinMaxRep(0, 50);
        events[4].disable();

        // Event 6
        events[5] = new Event("WalkOutdoors", true);
        events[5].setEventHeader(
            "As you were taking a walk out, you were ambushed by a man with a knife.\n\n"+Art.nThief+": Give me yer coin now or I'll take it from ye.",
            "What should you do? [Refuse / Give Coins / Attack]: "
        );
        events[5].setPromptResponses("r", "refuse", "g", "give coins", "givecoins", "a", "attack");

        // Event 7
        events[6] = new Event("KingdomParade", true);
        events[6].setEventHeader(player.getChief() + ": My " + player.getTitle() + ", Our kingdom is experiencing an large increase in trade volume. \n\nWe can use the profits from this to hold a kingdom parade! I believe it would be good for your reputation.",
        "Host a Parade? [Party! / No]: ");
        events[6].setPromptResponses("p", "party", "party!", "n", "no");

        // Event 8
        events[7] = new Event("PopularitySoar", true);
        events[7].setEventHeader("Your popularity has soared throughout the country, people are proud to be under your rule\n\n");

        // Event 9
        events[8] = new Event("PopularityCrash", 10000, true);
        events[8].setEventHeader("A man in the town is speaking out against you. He is gaining popularity very quickly",
        "What will you do? [Nothing / Speak To / Hang]: ");
        events[8].setPromptResponses("n", "nothing", "s", "speakto", "speak to", "h", "hang");

        // Event 10
        events[9] = new Event("TreasuryThief", 10000, true);
        events[9].setEventHeader(player.getChief() + ": A thief has stolen from the Treasury!\n\nWe can hire a bounty hunter to track them down, but it will cost us.",
        "Hire a bounty hunter? [Y/N]: ");
        events[9].setPromptResponses("y", "yes", "n", "no");

        // Event 11
        events[10] = new Event("EnemyTax", 10000, false);
        events[10].setEventHeader(Art.nSeniorCommander + ": We have come to collect our taxes from your kingdom.");
        events[10].disable();
    }

    // If an event is triggered, this function handles the events chance to mutate into a larger problem for the player.
    public static void chance(Event event, String response) {
        switch (event.getName()) {
        case "ChiefIntroduction": {
            if (!event.isOnTime()) {
                Game.clearScreen();
                System.out.println("You were hesitant to reply with your name. The Chief will remember this.");
                Game.clickEnterToContinue();
            }
            break;
        }
        case "Beggar": {
            switch (event.getStage()) {
            case -2:
                player.setEnding(Art.dungeonPlayer + "\n\nYou were locked up in a dungeon For eternity.", "Overthrown");
                player.removeGoldPieces(999999999);
                break;
            case -1: // From here the beggar can become an evil beggar.
                if (response.equals("y") || response.equals("yes")) {
                    event.setRandomStatus(false); // Disable this event from ever being triggered on random.
                    player.removeReputation(4);
                    break;
                }

                if (odds(50)) { // He stays a bad beggar
                    event.setEventHeader(
                        Art.badBeggar + "\n\nGuards: My " + player.getTitle() + ", we caught this man trying to steal weapons from our armory. \n\nBeggar: But I was only trying to find you your excellency.\nI just got lost coming through the castle. Please forgive me!",
                        "Throw beggar in the dungeon? [Y/N]: ");
                    event.setPromptResponses("y", "yes", "n", "no");

                } else { // He becomes evil
                    event.setStage(-2);
                    event.setEventHeader(
                        Art.evilBeggar + " The time has come to rule the world! We have hated the likes of you so called ROYALS and how you've treated our people from the beginning. \n\nA NEW ERA HAS EMERGED, and we have decided to leave. you. out of it. I'm afraid this is the end of you, " + player.getTitle() + " " + player.getName() + "\n\nSoldiers, throw this one into the dungeon. Make sure they never see the light of day again.\n\n"
                    );
                }
                break;
            case 0:
                // Percent chances for mutations
                int GoodOdds = 0;
                int NeutralOdds = 0;
                int BadOdds = 0;

                if (response.equals("y") || response.equals("yes")) { // Player says yes to beggar
                    player.removeGoldPieces(50);
                    player.addReputation(4);
                    GoodOdds = 40;
                    NeutralOdds = 50;
                    BadOdds = 10;
                } else { // Player says no to beggar
                    player.removeReputation(8);
                    GoodOdds = 0;
                    NeutralOdds = 60;
                    BadOdds = 40;
                }

                if (GoodOdds + NeutralOdds + BadOdds != 100) {
                    System.out.println("\n\n"+Art.red+"[ERROR]"+ Art.reset +" The Odds do not add up to 100!\n");
                }

                if (odds(GoodOdds)) {
                    player.addEventOnDay(player.getDays() + 3, event); // In three days, return the gold.
                    event.setStage(1);
                    event.setEventHeader(
                        Art.happyBeggar + "\n\nMy " + player.getTitle() + ", I have good news! I've done well starting my own business thanks to your generous donation!\n\nHere's your money back. [ With a little extra :) ]\n\n");
                } else if (odds((int)((double) NeutralOdds/(100-GoodOdds)*100))) {
                    // Beggar doesn't pay him back.
                    event.setEventHeader(
                        Art.beggar + "\n\nOh! How great it is to see you again your excellency. I haven't been able to make the money back but I promise next time I will. \n\nActually, I'm back here to ask... for more coins. My family barely has enough to eat. Please help us!\n\n",
                        "Give the beggar more money? [Y/N]: ");
                    event.setPromptResponses("y", "yes", "n", "no");
                } else {
                    event.setStage(-1);
                    event.setEventHeader(
                        Art.badBeggar + "\n\nGuards: My " + player.getTitle() + ", we caught this man trying to steal weapons from our armory. \n\nBeggar: But I was only trying to find you your excellency.\nI just got lost coming through the castle. Please forgive me!",
                        "Throw beggar in the dungeon? [Y/N]: ");
                    event.setPromptResponses("y", "yes", "n", "no");
                }
                Game.clickEnterToContinue();
                break;
            case 1: // The beggar stays as a positive influence to the community.
                player.addGoldPieces(80);
                break;
            }
            break;
        }
        case "SupplyTroops": {
            if (response.equals("y") || response.equals("yes")) {
                player.removeGoldPieces(200);
                player.addReputation(2);
                eventsObj.getEventByTitle("KingdomTakeover").disable();
                Game.clickEnterToContinue();
            } else {
                eventsObj.getEventByTitle("KingdomTakeover").enable();
                player.removeReputation(2);
                Game.clickEnterToContinue();
            }
            break;
        }
        case "KingdomTakeover": {
            if (response.equals("f") || response.equals("fight")) {
                if (odds(50)) { // 50% Chance of Success
                    player.removeGoldPieces(100);
                    player.addReputation(30);
                    Game.clickEnterToContinue();
                } else {
                    player.setEnding("The castle was overrun by our kingdom's adversaries. Maybe if our troops had weapons... we'd survive.", "Taken Over");
                    player.removeGoldPieces(999999999);
                }
            } else if (response.equals("r") || response.equals("run")) {
                player.setEnding("You tried to run, but the townspeople spotted your unheroic actions.\nThey grabbed you and brought you to the enemy where you would be lynched.", "Executed");
                player.removeGoldPieces(999999999);
                player.removeReputation(999999999);
            } else if (response.equals("s") || response.equals("surrender")) {
                Event e = new Event("KTSurrender", 15000);
                e.setEventHeader("Enemy Leader: You who they call " + player.getTitle() + " " + player.getName() + ", We do not normally spare people, but in this case, the town seems to like you. \nWe cannot have citizens acting against us. With that being said we'd like you to join our ranks and control this sector of our empire.",
                "What do you say to this? [Accept / Decline / %*$! OFF]: ");
                e.setPromptResponses("a", "accept", "d", "decline", "f", "off");
                e.activate();
            }
            break;
        }
        case "KTSurrender": {
            if (!event.isOnTime()) {
                Event e = new Event();
                e.setEventHeader("Enemy Leader: No words? Ah well, so be it.\n*You took too long to reply*");
                e.activate();
                player.setEnding("You thought of yourself as a mighty " + player.getTitle() + " until your head rolled on the ground without a body", "Beheaded");
                player.removeGoldPieces(999999999);
            }
            if (odds(75)) { // Live under their rule, enforces taxes
                Event e = new Event();
                e.setEventHeader("Senior Commander: Welcome to our ranks commander.\nWe will be imposing a weekly tax on your kingdom, effective immediately\n\n");
                e.activate();
                eventsObj.getEventByTitle("EnemyTax").enable();
                player.setTitle("Commander");
                player.removeGoldPieces(150);
                Game.clickEnterToContinue();
            } else {
                Event e = new Event();
                e.setEventHeader("Enemy Leader: \"Well you see, I've changed my mind...\"");
                player.removeGoldPieces(999999999);
            }
            break;
        }
        case "CharlesBetrayal": {
            player.setEnding("You were executed by your chief, " + player.getChief(), "Executed");
            player.removeGoldPieces(999999999);
            break;
        }
        case "WalkOutdoors": {
            if (response.equals("r") || response.equals("refuse")) {
                if (odds(60)) { // 40% Chance for it to go wrong
                    Event e = new Event();
                    e.setEventHeader("While your guards we're patrolling the town in search for you they found you along with the thief\nwho quickly scurried away at the sight of your men\n\n");
                    e.activate();
                    Game.clickEnterToContinue();
                } else {
                    player.setEnding("You were found dead on the side of the road with holes for pockets", "Stickup");
                    player.removeGoldPieces(999999999);
                }
            } else if (response.equals("g") || response.equals("give coin") || response.equals("givecoin")) {
                System.out.println("Give COIN!!!");
                player.removeGoldPieces(300);
                Game.clickEnterToContinue();
            } else if (response.equals("a") || response.equals("attack")) {
                if (odds(40)) {
                    Event e = new Event();
                    e.setEventHeader("You were able to successfully apprehend the thief, who's also a criminal with a bounty on his head from a neighboring kingdom\n\n");
                    e.activate();
                    player.addGoldPieces(200);
                    Game.clickEnterToContinue();
                } else {
                    player.setEnding("You were found dead on the side of the road with holes for pockets", "Stickup");
                    player.removeGoldPieces(999999999);
                }
            }
            break;
        }
        case "TreasuryThief": {
            player.removeGoldPieces(400);
            if (response.equals("y") || response.equals("yes")) {
                player.removeGoldPieces(200);
                if (odds(50)) {
                    Event e = new Event();
                    e.setEventHeader("Your gold was found lying next to a booby trap. Lucky you!");
                    e.activate();
                    player.addGoldPieces(400);
                }
                Game.clickEnterToContinue();
            } else if (response.equals("n") || response.equals("no")) {
                player.removeReputation(2);
                Game.clickEnterToContinue();
            }
            break;
        }
        case "PopularitySoar": {
            player.addReputation(35);
            break;
        }
        case "PopularityCrash": {
            if (response.equals("n") || response.equals("nothing")) {
                player.removeReputation(60);
                Game.clickEnterToContinue();
            } else if (response.equals("s") || response.equals("speakto") || response.equals("speak to")) {
                if (odds(60)) {
                    Event e = new Event();
                    e.setEventHeader("You successfully calmed the upriser down after inviting him over for dinner\n\n");
                    e.activate();
                } else {
                    Event e = new Event();
                    e.setEventHeader("After leaving your house from dinner, the upriser claimed to the public that you tried to silence him.");
                    e.activate();
                    player.removeReputation(90);
                }
            } else if (response.equals("h") || response.equals("hang")) {
                player.removeReputation(30);
                Game.clickEnterToContinue();
            }
            break;
        }
        case "KingdomParade": {
            if (response.equals("p") || response.equals("party") || response.equals("party!")) {
                player.addReputation(60);
            } else {
                player.addGoldPieces(500);
                player.removeReputation(10);
                Game.clickEnterToContinue();
            }
            break;
        }
        case "EnemyTax": {
            player.removeGoldPieces(150);
            Game.clickEnterToContinue();
            break;
        }
        case "Default": {
            break; // Do nothing, it's likely just a prompt.
        }
        default: {
            System.out.println("\n\nAction not taken for: " + event.getName());
            Game.clickEnterToContinue();
            break;
        }
        }
    }

    public static boolean odds(int chanceOfSuccess) {
        int r = (int) (Math.random() * 101);
        //System.out.println("Odds" + r + "Chance: "+chanceOfSuccess + " Result: " + (r <= chanceOfSuccess));
        //Game.clickEnterToContinue();
        return (r <= chanceOfSuccess);
    }

    public static void getVisit(Event event) {
        switch (event.getName()) {
            case "Beggar": {

            }
        }
    }

    public Event getEventByTitle(String s) {
        Event e = new Event();
        for (int i = 0; i < events.length; i++) {
            if (events[i] != null && events[i].getName().equals(s)) {
                e = events[i];
                break;
            }
        }
        return e;
    }

    public Event getRandomEvent() {
        int r = (int) (Math.random() * eventCount);
        while (events[r] == null || !events[r].isRandomEvent() || !events[r].canActivate(player)) {
            r = (int) (Math.random() * eventCount);
        }
        return events[r];
    }
}
