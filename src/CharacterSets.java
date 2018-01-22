import java.util.ArrayList;

public class CharacterSets {
    private ArrayList<CharacterList> sets;

    public CharacterSets()
    {
        sets = new ArrayList();
        sets.add(new CharsASCII());
        sets.add(new CharsZeroWidth());
        sets.add(new CharsZalgoAbove());
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
