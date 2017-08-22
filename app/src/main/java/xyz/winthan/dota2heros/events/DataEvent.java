package xyz.winthan.dota2heros.events;

import java.util.List;

import xyz.winthan.dota2heros.vos.HeroVO;

/**
 * Created by winthanhtike on 8/21/17.
 */

public class DataEvent {

    public static class AgilityHeroDataLoadedEvent{

        private List<HeroVO> heroVOList;

        public AgilityHeroDataLoadedEvent(List<HeroVO> heroVOList) {
            this.heroVOList = heroVOList;
        }

        public List<HeroVO> getHeroVOList() {
            return heroVOList;
        }

    }

    public static class StrengthHeroDataLoadedEvent{

        private List<HeroVO> heroVOList;

        public StrengthHeroDataLoadedEvent(List<HeroVO> heroVOList) {
            this.heroVOList = heroVOList;
        }

        public List<HeroVO> getHeroVOList() {
            return heroVOList;
        }
    }

    public static class IntelligenceHeroDataLoadedEvent {

        private List<HeroVO> heroVOList;

        public IntelligenceHeroDataLoadedEvent(List<HeroVO> heroVOList) {
            this.heroVOList = heroVOList;
        }

        public List<HeroVO> getHeroVOList() {
            return heroVOList;
        }
    }

    public static class ErrorLoadedEvent {

        private String message;

        public ErrorLoadedEvent(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

}
