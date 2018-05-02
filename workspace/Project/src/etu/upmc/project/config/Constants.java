/**
 * This file is a part of the project "Vie artificielle".
 * 
 * @author 	Quentin Serreau | Enzo Wesquy
 * @date 	2018
 * 
**/

package etu.upmc.project.config;

public enum Constants {
	
	/* Speeds */
	SPEED_FOREST,
	SPEED_AGENTS,
	SPEED_HUMANS,
	
	/* Forest */
	DENSITY_TREES,
	DENSITY_GRASS,
	BURNING_FACTOR,
	PROB_TREE_BURN,
	PROB_TREE_BORN,
	PROB_GRASS_BURN,
	PROB_GRASS_BORN,
	
	/* Agents */
	DENSITY_AGENTS,
	PROB_AGENT_MOVE,
	PROB_PREY_FLEE,
	PROB_PREDATOR_HUNT,
	PREY_NATALITY_RATE,
	PREDATOR_NATALITY_RATE,
	PREY_GROWING_TIME,
	PREDATOR_GROWING_TIME,
	PREY_HUNGER_LIMIT,
	PREDATOR_HUNGER_LIMIT,
	
	/* Humans */
	DENSITY_TRIBES,
	DENSITY_HUMANS, 		
	HUMAN_HUNGER_LIMIT, 	
	NEW_BUILDING,
	PROB_KILLING_PREY,
	CARRY_CAPACITY,
	
	/* Landscape */
	ALTITUDE_RATIO,
	WATER_ALTITUDE,
	FOREST_ALTITUDE,
	NB_MAX_VOLCANO,
	FEATURE_SIZE,
	SCALING
}
