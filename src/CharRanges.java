public enum CharRanges implements CharacterList
{
    ASCII_CONTROL (0x0, 0x1F),
    ASCII_BASIC (0x20, 0x7F),
    LATIN_SUPPLEMENT (0xA0, 0xFF),
    LATIN_EXTENDED_A (0x100, 0x17F),
    LATIN_EXTENDED_B (0x180, 0x24F),
    GREEK (0x370, 0x3FF),
    CYRILLIC_BASIC (0x400, 0x4FF),
    CYRILLIC_SUPPLEMENT (0x500, 0x52F);

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

        // add each element to the list
        for (int i = 0; i < list.length; i++)
            list[i] = (char)(start + i);

        return list;
    }

    public int getSize() { return end - start; }

    public boolean isCharacterInList(char value)
    {
        return value>=start && value<=end;
    }

    public String getRegex()
    {
        StringBuilder regex = new StringBuilder();

        // add the first character
        if (CharArrays.REGEX_SPECIAL.isCharacterInList((char)(start)))
            regex.append("\\");
        regex.append((char)(start));

        // add the other characters with a | in front
        for (int i = 1; i < end - start + 1; i++) {
            regex.append("|");
            if (CharArrays.REGEX_SPECIAL.isCharacterInList((char)(start + i)))
                regex.append("\\");
            regex.append((char) (start + i));
        }

        return regex.toString();
    }
}