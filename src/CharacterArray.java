public abstract class CharacterArray extends CharacterList {
    protected Character[] list = {};

    public Character[] all()
    {
        return list;
    }

    public boolean isCharacterInList(Character value)
    {
        boolean isFound = false;

        for (int i = 0; i < list.length; i++)
        {
            if (value.equals(list[i])) {
                isFound = true;
                break;
            }
        }

        return isFound;
    }
}
