public enum CharArrays implements CharacterList
{
    REGEX_SPECIAL (new char[]{'$', '(', ')', '*', '+', '.', '?', '[', '^', '\\', '{', '|'}),

    FRACTIONS (new char[]{0xBC, 0xBD, 0xBE, 0x2150, 0x2151, 0x2152, 0x2153, 0x2154,
                          0x2155, 0x2156, 0x2157, 0x2158, 0x2159, 0x215A, 0x215B,
                          0x215C, 0x215D, 0x215E}),

    ZERO_WITDH (new char[]{0x200B, 0x200C, 0x200D, 0xFEFF}),

    DIRECTION (new char[]{0x200E, 0x200F, 0x202A, 0x202B, 0x202C, 0x202D, 0x202E, 0x2066,
            0x2067, 0x2068, 0x2069}),

    ZALGO_ABOVE(new char[]{0x300, 0x301, 0x302, 0x303, 0x304, 0x305, 0x306, 0x307, 0x308, 0x309,
            0x30A, 0x30B, 0x30C, 0x30D, 0x30E, 0x30F, 0x310, 0x311, 0x312, 0x313,
            0x314, 0x315, 0x31A, 0x31B, 0x33D, 0x33E, 0x33F, 0x340, 0x341, 0x342,
            0x343, 0x344, 0x346, 0x34A, 0x34B, 0x34C, 0x350, 0x351, 0x352, 0x357,
            0x358, 0x35B, 0x35D, 0x35E, 0x360, 0x361});

    private final char[] list;

    CharArrays(char[] list)
    {
        this.list = list;
    }

    public char[] all()
    {
        return list;
    }

    public int getSize() { return list.length; }

    public boolean isCharacterInList(char value)
    {
        // assume the list is sorted
        if (value < list[0])
            return false;
        if (value > list[list.length-1])
            return false;

        // otherwise, check if it's in the list
        for (int i = 0; i < list.length; i++)
        {
            if (value == list[i])
                return true;
        }
        return false;
    }

    public String getRegex()
    {
        StringBuilder regex = new StringBuilder();

        // add the first character
        if (CharArrays.REGEX_SPECIAL.isCharacterInList(list[0]))
            regex.append("\\");
        regex.append(list[0]);

        // add the other characters with a | in front
        for(int i = 1; i < list.length; i++) {
            regex.append("|");

            if (CharArrays.REGEX_SPECIAL.isCharacterInList(list[i]))
                regex.append("\\");
            regex.append(list[i]);
        }

        return regex.toString();
    }
}
