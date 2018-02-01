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
        String base = "";

        for (int i = 0; i < sets.size(); i++)
        {
            for (int j = 0; j < input.length(); j++)
            {
                if (sets.get(i).isCharacterInList(input.charAt(j)))
                {
                    base += sets.get(i) + "\n";
                    break;
                }
            }
        }

        return base;
    }
}
