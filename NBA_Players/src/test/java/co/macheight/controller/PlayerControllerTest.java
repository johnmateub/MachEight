package co.macheight.controller;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import co.macheight.model.Player;

public class PlayerControllerTest {
	
	PlayerController playerController;
	List<Player> players;
	
	@Before
	public void setUp()
	{
		playerController = new PlayerController();
		players = new ArrayList<Player>();
		players.add(new Player("Michael","Jordan", 78, 1.98));
		players.add(new Player("Kobe","Bryant", 78, 1.98));
		players.add(new Player("LeBron","James", 81, 2.06));
		players.add(new Player("Shaquille","O'Neal", 85, 2.16));
	}
	
	@Test
	public void getPairPlayersAddsUpTo_noMatchesFound()
	{
		List<String> response = playerController.getPairPlayersAddsUpTo(players, 155);
		assertTrue(" No matches Found ", response.isEmpty());
	}
	
	@Test
	public void getPairPlayersAddsUpTo_noMatchesFoundMinValue()
	{
		List<String> response = playerController.getPairPlayersAddsUpTo(players, 20);
		assertTrue(" No matches Found ", response.isEmpty());
	}
	
	@Test
	public void getPairPlayersAddsUpTo_matchesFound()
	{
		List<String> response = playerController.getPairPlayersAddsUpTo(players, 159);
		assertTrue(" Two pairs matched ", response.size() == 2);
	}
	
	@Test
	public void getPairPlayersAddsUpTo_noMatchesFoundMaxValue()
	{
		List<String> response = playerController.getPairPlayersAddsUpTo(players, 167);
		assertTrue(" No matches Found ", response.isEmpty());
	}

}
