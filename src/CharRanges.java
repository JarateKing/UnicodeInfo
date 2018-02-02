public enum CharRanges implements CharacterList
{
    ASCII_CONTROL (0x0, 0x1F),
    ASCII_BASIC (0x20, 0x7F);

    private final int start;
    private final int end;

    CharRanges(int start, int end)
    {
        this.start = start;
        this.end = end;
    }

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

    public String getRegex()
    {
        StringBuilder regex = new StringBuilder((char)(start));

        for (int i = 1; i < end - start + 1; i++) {
            regex.append("|");
            regex.append((char) (start + i));
        }

        return regex.toString();
    }
}