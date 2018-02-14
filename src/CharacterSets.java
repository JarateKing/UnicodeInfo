import java.util.ArrayList;

public class CharacterSets {
    private ArrayList<CharacterList> sets;

    public CharacterSets()
    {
        sets = new ArrayList<CharacterList>();

        for(CharRanges range : CharRanges.values())
            sets.add(range);

        for(CharArrays array : CharArrays.values())
            sets.add(array);

        for (CharCombinations combinations : CharCombinations.values())
            sets.add(combinations);
    }

    public String listSetsUsed(String input)
    {
        StringBuilder base = new StringBuilder();

        // go through each set and appending the ones that work
        for (CharacterList set : sets)
        {
            if (isSetUsed(set, input))
            {
                base.append(set);
                base.append("\n");
            }
        }
        // remove the last nextline
        if (base.length() > 0)
            base.setLength(base.length() - 1);

        return base.toString();
    }

    public CharacterList[] getSetsUsed(String input)
    {
        ArrayList<CharacterList> toReturn = new ArrayList<CharacterList>();

        for (CharacterList set : sets)
        {
            if (isSetUsed(set, input))
                toReturn.add(set);
        }

        return (CharacterList[])(toReturn.toArray());
    }

    public boolean isSetUsed(CharacterList set, String input)
    {
        // go through the whole string, checking each character
        for (int i = 0; i < input.length(); i++)
        {
            if (set.isCharacterInList(input.charAt(i)))
                return true;
        }
        return false;
    }
}
