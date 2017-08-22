
package xyz.winthan.dota2heros.vos;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class HeroVO implements Serializable {

    private String hero_agility;

    private String hero_armor;

    private String hero_damage;

    private String hero_detail;

    private String hero_image;

    private String hero_intellgience;

    private String hero_movement_speed;

    private String hero_name;

    private String hero_overview;

    private String hero_role;

    private List<HeroSpellVO> hero_spell;

    private String hero_strength;

    private String share_hero;

    public String getHero_agility() {
        return hero_agility;
    }

    public String getHero_armor() {
        return hero_armor;
    }

    public String getHero_damage() {
        return hero_damage;
    }

    public String getHero_detail() {
        return hero_detail;
    }

    public String getHero_image() {
        return hero_image;
    }

    public String getHero_intellgience() {
        return hero_intellgience;
    }

    public String getHero_movement_speed() {
        return hero_movement_speed;
    }

    public String getHero_name() {
        return hero_name;
    }

    public String getHero_overview() {
        return hero_overview;
    }

    public String getHero_role() {
        return hero_role;
    }

    public List<HeroSpellVO> getHero_spell() {
        return hero_spell;
    }

    public String getHero_strength() {
        return hero_strength;
    }

    public String getShare_hero() {
        return share_hero;
    }
}
