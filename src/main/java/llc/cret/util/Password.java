package llc.cret.util;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;

import java.util.Arrays;
import java.util.List;

public class Password {

    /**
     * パスワード生成.
     * @return パスワード
     */
    public static String generate() {
        List<CharacterRule> rules = Arrays.asList(
                new CharacterRule(EnglishCharacterData.UpperCase, 1),
                new CharacterRule(EnglishCharacterData.LowerCase, 1),
                new CharacterRule(EnglishCharacterData.Digit, 1)
        );
        PasswordGenerator generator = new PasswordGenerator();
        return generator.generatePassword(8, rules);
    }
}
