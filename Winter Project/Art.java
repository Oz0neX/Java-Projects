class Art {
    // The art class simply holds all of the askey art of the game to prevent filling up the code with non-sense characters.
    public static final String reset = "\033[0m";
    public static final String black = "\033[30m";
    public static final String red = "\033[31m";
    public static final String bred = "\033[91m";
    public static final String green = "\033[32m";
    public static final String bgreen = "\033[92m";
    public static final String yellow = "\033[93m";
    public static final String blue = "\033[34m";
    public static final String purple = "\033[35m";
    public static final String cyan = "\033[36m";
    public static final String bcyan = "\033[96m";
    public static final String grey = "\033[90m";

    public static String nBeggar = purple + "Beggar" + reset;
    public static String nEnemyCommander = bred + "Enemy Leader" + reset;
    public static String nSeniorCommander = bred + "Senior Commander" + reset;
    public static String nThief = red + "Thief" + reset;
    public static String nEndingAchieved = bcyan + "ENDING ACHIEVED: " + reset;

    public static String chief = toString(
        "______",
        "CHIEF",
        "IMAGE",
        "HERE",
        "______");

    public static String throne = toString(
        "                    ░░░░░░                            ",
        "                    ▒▒▓▓▒▒░░                          ",
        "                  ▒▒▓▓▓▓▓▓▒▒▒▒                        ",
        "                ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒    ░░                ",
        "          ▒▒  ▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓    ▒▒                ",
        "          ██    ██▓▓▓▓▓▓▒▒▒▒▓▓▓▓    ▒▒                ",
        "          ▓▓    ░░▒▒▓▓▓▓▓▓▒▒▓▓      ▓▓                ",
        "          ▓▓  ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒  ▓▓                ",
        "          ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓                ",
        "          ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▓▓▓▓▓▓▓▓▓▓                ",
        "          ▓▓▒▒▓▓▓▓▓▓▒▒▓▓▓▓░░▒▒▒▒▒▒▒▒▓▓                ",
        "          ▓▓░░▒▒▓▓▓▓▒▒▓▓▒▒▒▒▒▒▒▒▓▓░░▓▓                ",
        "          ▓▓  ▓▓▒▒▓▓▒▒▒▒▒▒▒▒░░▒▒▓▓  ▓▓                ",
        "          ▓▓  ▓▓▓▓▓▓▒▒▓▓▓▓▒▒░░▒▒▒▒  ▓▓                ",
        "          ▓▓  ▒▒▓▓▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒░░▓▓                ",
        "          ▓▓  ▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▓▓  ▓▓                ",
        "          ▒▒  ▒▒▓▓▓▓▒▒▒▒░░▒▒▒▒▒▒▒▒  ▓▓                ",
        "          ▒▒  ▒▒▓▓▒▒▒▒░░▒▒░░░░▒▒▒▒  ▓▓                ",
        "          ▓▓░░▓▓▓▓▓▓░░▒▒▒▒░░░░▒▒▓▓  ▓▓                ",
        "        ░░▓▓░░▓▓▓▓▓▓░░▒▒▒▒░░░░▒▒▒▒░░▓▓░░              ",
        "        ░░▒▒▒▒▓▓▓▓▓▓▒▒░░░░░░░░▒▒▒▒▒▒▓▓░░              ",
        "        ░░▒▒▒▒▓▓▓▓▓▓░░░░░░░░░░▒▒▒▒░░▒▒▒▒              ",
        "        ░░▓▓▒▒▒▒▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▒▒              ",
        "        ░░▓▓▒▒▓▓▓▓▓▓▒▒▒▒▒▒░░▒▒▒▒▓▓▒▒▓▓▒▒              ",
        "        ░░▓▓▒▒▓▓▓▓▓▓░░▒▒▒▒▒▒░░▒▒▒▒░░▓▓▒▒              ",
        "        ░░▓▓▒▒▓▓▓▓▓▓░░▒▒▒▒▒▒░░▒▒▒▒░░▓▓▓▓              ",
        "        ░░▓▓▒▒▓▓▓▓▓▓░░▒▒▒▒▒▒░░▒▒▒▒▒▒▓▓▒▒              ",
        "        ░░▓▓▒▒▒▒▒▒▓▓▒▒▒▒▒▒░░░░▒▒▒▒░░▓▓▓▓              ",
        "        ░░▓▓░░▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▓▓▓▓  ▒▒▒▒░░            ",
        "  ▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▒▒▒▒▒▒▓▓▒▒▒▒▓▓▓▓░░▓▓▒▒▒▒▒▒▒▒▒▒▒▒▓▓░░",
        "  ▓▓▓▓▒▒▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓██░░  ░░░░▓▓▓▓▒▒▒▒",
        "  ░░▒▒▒▒▒▒▒▒▓▓▒▒▓▓▒▒░░▒▒▒▒░░▓▓▓▓▒▒▓▓██      ░░▒▒▒▒▒▒░░",
        "  ▒▒▓▓▓▓▒▒▓▓░░    ▒▒▓▓▓▓▓▓▓▓▓▓░░░░  ▓▓▒▒    ░░▓▓▓▓▓▓░░",
        "  ▒▒▓▓▓▓▒▒▓▓▒▒░░░░▒▒░░░░░░░░░░░░░░░░▒▒▒▒    ░░▓▓▓▓▓▓░░",
        "  ▒▒▓▓▓▓▒▒▒▒░░▒▒▒▒▒▒▒▒▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░    ▓▓▓▓▒▒░░",
        "  ▒▒▒▒▒▒▒▒░░▒▒░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒▒▒▒▒  ▒▒▒▒▒▒░░",
        "  ▒▒▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░░░░░░░▒▒▒▒▒▒▓▓▓▓▓▓▓▓▒▒▒▒▒▒░░",
        "  ░░▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓▒▒▓▓░░",
        "  ░░▓▓▓▓▒▒▓▓██████▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▓▓██▓▓▒▒▒▒░░",
        "  ░░▓▓▓▓▓▓▓▓░░                      ██▓▓██████▓▓▓▓▓▓░░",
        "  ░░▓▓▓▓▓▓▓▓░░░░        ░░▒▒░░      ██░░▓▓▓▓▓▓██▓▓▓▓▒▒",
        "  ░░▓▓▓▓▓▓▓▓▓▓▓▓▓▓░░  ▒▒▓▓▓▓▓▓▓▓░░  ▓▓▒▒▓▓▓▓▓▓▓▓▓▓▓▓░░",
        "  ░░▓▓▓▓▓▓▓▓▒▒▒▒▓▓▓▓▓▓▓▓▒▒▓▓▓▓▒▒▒▒▒▒▒▒▓▓▒▒▒▒▓▓▓▓▓▓▓▓░░",
        "  ░░▓▓▓▓▒▒▓▓▓▓  ▒▒▒▒▓▓▒▒▓▓▓▓▓▓▒▒▒▒▒▒▓▓▒▒  ░░▓▓▓▓▓▓▓▓  ",
        "  ░░▓▓▓▓░░██░░    ▓▓▓▓▒▒▓▓▓▓▓▓▒▒▒▒▒▒▓▓        ▓▓▓▓▓▓  ",
        "    ▓▓▓▓  ██        ▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒██        ▓▓▓▓▓▓  ",
        "    ▓▓▓▓              ░░  ▒▒▒▒  ░░            ▒▒▓▓▓▓  ",
        "    ▒▒▓▓                                      ▒▒▓▓▒▒  ",
        "    ▓▓▓▓                                        ▓▓▓▓  ",
        "    ▓▓▓▓                                      ░░▓▓▓▓  ",
        "    ▓▓▓▓░░                                    ░░▓▓██░░");

    public static String happyBeggar = toString(
        "______",
        "HAPPY BEGGAR",
        "IMAGE",
        "HERE",
        "______");

    public static String beggar = toString(
    "\n\n\n",
    "                            ▒▒▒▒▒▒░░       ",
    "                               ▓▓▓▓▓▓▒▒▒▒    ",
    "                             ░░▓▓▓▓▓▓▓▓▓▓░░  ",
    "                           ▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓  ",
    "                       ░░▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓       ",
    "                       ░░▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓░░            ",
    "                       ░░██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓░░            ",
    "                       ██▓▓▒▒██▒▒▓▓▓▓▓▓▓▓▓▓ ",
    "                   ▓▓▓▓██▓▓▒▒██▒▒░░░░▓▓▓▓▓▓              ",
    "                ▓▓▓▓▓▓▓▓██▓▓▒▒▓▓░░░░▒▒▒▒░░                ",
    "              ▒▒▓▓▓▓▓▓▓▓████▓▓▓▓░░░░░░░░▒▒                ",
    "            ▓▓▓▓▓▓▓▓▓▓▓▓██████▓▓░░▒▒▒▒░░░░                ",
    "          ▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓████▓▓▓▓████▓▓▓▓                ",
    "          ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓████▓▓▓▓████▓▓██                ",
    "          ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓████████████▒▒██                ",
    "          ▓▓▓▓▓▓▓▓▓▓▓▓▓▓██████████████████                ",
    "          ▓▓▓▓▓▓▓▓▓▓▓▓▓▓████████████████                  ",
    "          ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██▓▓████████                  ",
    "          ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓░░░░                  ",
    "          ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓                      ",
    "          ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▓▓▓▓                      ",
    "          ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▓▓▓▓▓▓                      ",
    "          ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▓▓▓▓▓▓▓▓████                        ▒▒░░  ",
    "          ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒  ",
    "          ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓░░░░░░░░░░▒▒▒▒  ",
    "          ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓░░░░▒▒▒▒▒▒░░░░  ",
    "          ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓░░▒▒░░▒▒░░░░░░  ",
    "          ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒          ",
    "          ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒      ",
    "            ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒  ");

    public static String badBeggar = toString(
        "______",
        "BAD BEGGAR",
        "IMAGE",
        "HERE",
        "______");


    public static String evilBeggar = toString(
        "______",
        "EVIL BEGGAR",
        "IMAGE",
        "HERE",
        "______");

    public static String happyPlayer = toString(
        "______",
        "HAPPY PLAYER",
        "IMAGE",
        "HERE",
        "______");

    public static String dungeonPlayer = toString(
        "______",
        "DUNGEON & PLAYER",
        "IMAGE",
        "HERE",
        "______");

    private static String toString(String... args) {
        String result = "";
        //for (int i = 0; i < args.length; i++)
        //    result += args[i] + "\n";
        return result;
    }
}
