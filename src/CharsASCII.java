public class CharsASCII extends CharacterRange {
    protected static int start = 0x20;
    protected static int end = 0x7F;

    public char[] all()
    {
        return super.all(start, end);
    }

    public boolean isCharacterInList(char value)
    {
        return super.isCharacterInList(start, end, value);
    }

    public String toString()
    {
        return getClass().getName();
    }
}
