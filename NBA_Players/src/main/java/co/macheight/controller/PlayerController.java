package co.macheight.controller;

import java.util.ArrayList;
import java.util.List;

import co.macheight.model.Player;
import co.macheight.service.ServiceProcessor;
import co.macheight.service.impl.JsonProcessor;

public class PlayerController {
	
	public List<Player> getPlayersData()
	{
		ServiceProcessor processor = new JsonProcessor();
		List<Player> players = processor.processData();
		return players;
	}
	
	public List<String> getPairPlayersAddsUpTo(List<Player> players, int sum)
	{
		List<String> pairPlayers = new ArrayList<String>();
		Player firstPlayer;
		Player secondPlayer;
		for ( int firstPlayerPosition = 0; firstPlayerPosition < players.size(); firstPlayerPosition++ )
		{
			firstPlayer = players.get(firstPlayerPosition);
			if ( firstPlayer.getHeightInches() >= sum  )
			{
				firstPlayerPosition = players.size(); // Escape Condition
			}
			
			
			for ( int secondPlayerPosition = firstPlayerPosition; secondPlayerPosition < players.size(); secondPlayerPosition++ )
			{
				secondPlayer = players.get(secondPlayerPosition);
				if ( Integer.sum(firstPlayer.getHeightInches(), secondPlayer.getHeightInches()) > sum ) {
					secondPlayerPosition = players.size(); // Escape Condition
				}
				else if ( Integer.sum(firstPlayer.getHeightInches(), secondPlayer.getHeightInches()) == sum ) {
					// Add pair of players to the response
					pairPlayers.add(firstPlayer.getCompleteName() + " - " + secondPlayer.getCompleteName());
				}
			}
		}
		return pairPlayers;
	}
	
}
