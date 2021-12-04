package co.macheight.control;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import co.macheight.controller.PlayerController;
import co.macheight.model.Player;

public class ControlMain {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		 
        String arg0 = in.nextLine();
        
		PlayerController controller = new PlayerController();
		List<Player> players = controller.getPlayersData();
		
		players.sort(Comparator.comparing(Player::getHeightInches));
		List<String> pairs = controller.getPairPlayersAddsUpTo(players, Integer.parseInt(arg0));
		if ( !pairs.isEmpty() )
		{
			pairs.forEach(System.out::println);
		}
		else {
			System.out.println("No matches found");
		}
		
		in.close();
		
	}

}
