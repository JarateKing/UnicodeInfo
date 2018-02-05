public class Driver {
    public static void main(String[] args)
    {
        CharacterSets sets = new CharacterSets();

        System.out.println("Sets used in \"Hello World!\":");
        System.out.println(sets.listSetsUsed("Hello World!"));

        System.out.println("Regex of the regex special characters:");
        System.out.println(CharArrays.REGEX_SPECIAL.getRegex());

        System.out.println("Are there zero-width spaces in \"right\u200Bhere\":");
        System.out.println(sets.isSetUsed(CharArrays.ZERO_WITDH, "right\u200Bhere"));
    }
}
