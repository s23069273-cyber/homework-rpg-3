package com.narxoz.rpg.battle;

import java.util.List;
import java.util.Random;
import java.util.Iterator;

public class BattleEngine {

    private static BattleEngine instance;
    private Random random = new Random();

    private BattleEngine() {
    }

    public static BattleEngine getInstance() {
        if (instance == null) {
            instance = new BattleEngine();
        }
        return instance;
    }

    public BattleEngine setRandomSeed(long seed) {
        random.setSeed(seed);
        return this;
    }

    public EncounterResult runEncounter(List<Combatant> teamA, List<Combatant> teamB) {

        while (!teamA.isEmpty() && !teamB.isEmpty()) {

            attackRound(teamA, teamB);
            attackRound(teamB, teamA);

            removeDead(teamA);
            removeDead(teamB);
        }

        String winner = teamA.isEmpty() ? "Team B" : "Team A";
        return new EncounterResult(winner);
    }

    private void attackRound(List<Combatant> attackers, List<Combatant> defenders) {

        for (Combatant attacker : attackers) {
            if (defenders.isEmpty()) break;

            Combatant target = defenders.get(0);
            target.takeDamage(attacker.getAttackPower());
        }
    }

    private void removeDead(List<Combatant> team) {
        Iterator<Combatant> iterator = team.iterator();
        while (iterator.hasNext()) {
            if (!iterator.next().isAlive()) {
                iterator.remove();
            }
        }
    }

    public void reset() {
        instance = null;
    }
}