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

        for (int i = 0; i < sets.size(); i++)
        {
            for (int j = 0; j < input.length(); j++)
            {
                if (sets.get(i).isCharacterInList(input.charAt(j)))
                {
                    base.append(sets.get(i));
                    base.append("\n");
                    break;
                }
            }
        }

        return base.toString();
    }

    public boolean isSetUsed(CharacterList set, String input)
    {
        for (int i = 0; i < input.length(); i++)
        {
            if (set.isCharacterInList(input.charAt(i)))
                return true;
        }
        return false;
    }
}
