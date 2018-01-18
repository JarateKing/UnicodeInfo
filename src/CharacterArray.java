public abstract class CharacterArray extends CharacterList {
    public static char[] all(char[] list)
    {
        return list;
    }

    public static boolean isCharacterInList(char[] list, char value)
    {
        boolean isFound = false;

        for (int i = 0; i < list.length; i++)
        {
            if (value == list[i]) {
                isFound = true;
                break;
            }
        }

        return isFound;
    }
}
