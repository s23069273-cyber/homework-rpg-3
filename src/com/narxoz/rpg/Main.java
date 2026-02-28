package com.narxoz.rpg;

import com.narxoz.rpg.adapter.EnemyCombatantAdapter;
import com.narxoz.rpg.adapter.HeroCombatantAdapter;
import com.narxoz.rpg.battle.BattleEngine;
import com.narxoz.rpg.battle.Combatant;
import com.narxoz.rpg.battle.EncounterResult;
import com.narxoz.rpg.enemy.Goblin;
import com.narxoz.rpg.hero.Warrior;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        BattleEngine engine = BattleEngine.getInstance().setRandomSeed(42);

        List<Combatant> teamA = new ArrayList<>();
        teamA.add(new HeroCombatantAdapter(new Warrior("Warrior A", 30, 7)));
        teamA.add(new HeroCombatantAdapter(new Warrior("Warrior B", 25, 6)));

        List<Combatant> teamB = new ArrayList<>();
        teamB.add(new EnemyCombatantAdapter(new Goblin("Goblin X", 20, 5)));
        teamB.add(new EnemyCombatantAdapter(new Goblin("Goblin Y", 18, 4)));

        EncounterResult result = engine.runEncounter(teamA, teamB);
        System.out.println(result);
        System.out.println("Winner: " + result.getWinner());
    }
}