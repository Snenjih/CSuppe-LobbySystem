package net.chaotischesuppe.utils.messages;

public class Settings {

    public static String prefix;
    public static String noperm;

    //Items
    public static String navigator;

    //Navigator
    public static String spawn;
    public static String survival;
    public static String challenges;

    static {
        Settings.prefix = "§8[ §6Lobby §8] §7";
        Settings.noperm = String.valueOf(Settings.prefix) + "§7Dazu hast du §cKeine §7Rechte";

        Settings.navigator = "§8» §cNavigator";


        Settings.spawn = "§8» §aSpawn";
        Settings.survival = "§8» §aSurvival";
        Settings.challenges = "§8» §aChallenges";


    }


}
