public abstract class CharacterArray extends CharacterList {
    protected static char[] all(char[] list)
    {
        return list;
    }

    protected static boolean isCharacterInList(char[] list, char value)
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
