public class CharsASCII extends CharacterRange {
    protected static int start = 0x00;
    protected static int end = 0xFF;

    public char[] all()
    {
        return super.all(start, end);
    }

    public boolean isCharacterInList(char value)
    {
        return super.isCharacterInList(start, end, value);
    }
}
