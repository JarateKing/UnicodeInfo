public class CharsZeroWidth extends CharacterArray {
    private static char[] list = {0x200B, 0x200C, 0x200D, 0xFEFF};

    public char[] all()
    {
        return super.all(list);
    }

    public boolean isCharacterInList(char value)
    {
        return super.isCharacterInList(list, value);
    }

    public String toString()
    {
        return getClass().getName();
    }
}
