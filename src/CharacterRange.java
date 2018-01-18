public abstract class CharacterRange extends CharacterList {
    public static char[] all(int start, int end)
    {
        char[] list = new char[end - start + 1];

        for (int i = 0; i < list.length; i++)
            list[i] = (char)(start + i);

        return list;
    }

    public static boolean isCharacterInList(int start, int end, char value)
    {
        return value>=start && value<=end;
    }
}
