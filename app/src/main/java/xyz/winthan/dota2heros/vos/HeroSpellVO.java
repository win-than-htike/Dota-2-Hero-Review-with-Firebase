
package xyz.winthan.dota2heros.vos;

import java.io.Serializable;

public class HeroSpellVO implements Serializable {


    private String spell_image;

    private String spell_name;

    private String spell_overview;

    public String getSpell_image() {
        return spell_image;
    }

    public String getSpell_name() {
        return spell_name;
    }

    public String getSpell_overview() {
        return spell_overview;
    }
}
