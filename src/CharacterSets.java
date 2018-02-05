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

        return base.toString();
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
