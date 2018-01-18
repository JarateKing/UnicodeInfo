public abstract class CharacterArray extends CharacterList {
    protected static char[] list = {};

    public char[] all()
    {
        return list;
    }

    public boolean isCharacterInList(char value)
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
