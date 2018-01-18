public abstract class CharacterRange extends CharacterList {
    protected static int start = 0;
    protected static int end = 0;

    public char[] all()
    {
        char[] list = new char[end - start + 1];

        for (int i = 0; i < list.length; i++)
            list[i] = (char)(start + i);

        return list;
    }

    public boolean isCharacterInList(char value)
    {
        return value>=start && value<=end;
    }
}
