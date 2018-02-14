public enum CharCombinations implements CharacterList
{
    LATIN (new CharacterList[]{CharRanges.ASCII_BASIC, CharRanges.LATIN_SUPPLEMENT,
                               CharRanges.LATIN_EXTENDED_A, CharRanges.LATIN_EXTENDED_B});

    private final CharacterList[] list;

    CharCombinations(CharacterList[] list)
    {
        this.list = list;
    }

    public char[] all()
    {
        char[] toReturn = new char[this.getSize()];

        int offset = 0;
        for (int i = 0; i < list.length; i++)
        {
            char[] current = list[i].all();
            for (int j = 0; j < current.length; i++)
            {
                toReturn[j + offset] = current[j];
            }
            offset += list[i].getSize();
        }

        return toReturn;
    }

    public int getSize()
    {
        int size = 0;

        for (int i = 0; i < list.length; i++)
            size += list[i].getSize();

        return size;
    }

    public boolean isCharacterInList(char value)
    {
        for (int i = 0; i < list.length; i++)
        {
            if (list[i].isCharacterInList(value))
                return true;
        }
        return false;
    }

    public String getRegex()
    {
        StringBuilder regex = new StringBuilder();

        // add the first character
        regex.append(list[0].getRegex());

        // add the other characters with a | in front
        for(int i = 1; i < list.length; i++) {
            regex.append("|");
            regex.append(list[i].getRegex());
        }

        return regex.toString();
    }
}
