public abstract class CharacterRange extends CharacterList {
    protected int start = 0;
    protected int end = 0;

    public Character[] all()
    {
        Character[] list = new Character[end - start + 1];

        for (int i = 0; i < list.length; i++)
            list[i] = (char)(start + i);

        return list;
    }

    public boolean isCharacterInList(Character value)
    {
        return value>=start && value<=end;
    }
}
