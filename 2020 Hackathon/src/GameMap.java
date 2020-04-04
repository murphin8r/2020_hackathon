
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GameMap extends JFrame implements ActionListener{

	protected final int MAPSIZEX = 10;
	protected final int MAPSIZEY = 10;
	protected final Dimension SPACESIZE = new Dimension(50, 50);
	private int[] playerPosition = {8, 3};
	
	private JButton northButton;
	private JButton southButton;
	private JButton eastButton;
	private JButton westButton;
	private JButton interButton;
	private JTextArea descLabel;
	
	protected Space[][] map = new Space[MAPSIZEX][MAPSIZEY];
	
	private boolean gameOver;

	public GameMap() {	
		
		gameOver = false;
		
		map[0][0] = new Space(false, "", false, "");
		map[0][1] = new Space(false, "", false, "");
		map[0][2] = new Space(false, "", false, "");
		map[0][3] = new Space(false, "", false, "");
		map[0][4] = new Space(true, "Looks like a dead end, you can only go back. ", true, 
				"You look up to see a trail lead to somewhere... Do you want to follow the trail?");
		map[0][4].setActionResp("Congrats! You have made it to the peak of Mount Shasta!"
				+ " You see the entire landscape and can almost make out Southern Oregon University.", true);
		map[0][5] = new Space(false, "", false, "");
		map[0][6] = new Space(false, "", false, "");
		map[0][7] = new Space(false, "", false, "");
		map[0][8] = new Space(false, "", false, "");
		map[0][9] = new Space(false, "", false, "");
		
		map[1][0] = new Space(false, "", false, "");
		map[1][1] = new Space(true, "You come to a corner on your path that leads east and south. ", true, 
				"There is a bush with some berries on them. Do you want to eat them?");
		map[1][1].setActionResp("Yummmmmm they are pretty good. They looked poisonous, but you will be okay", false);
		map[1][2] = new Space(true, "The path follows east and west.", false, "");
		map[1][3] = new Space(true, "The path follows east and west.", true, 
				"You look in a bush to see a shiny object. Do you grab the object?");
		map[1][3].setActionResp("The ground starts to shake more and more until you hear a loud explosion."
				+ " You started a volcanic eruption! You try to run, but the lava catches up to you. Game Over. ", true);
		map[1][4] = new Space(true, "The path stays east, but also has a path to the north.", false, "");
		map[1][5] = new Space(true, "The path follows east and west", false, "");
		map[1][6] = new Space(true, "The path follows to the east, west, and a faint path to the south.", false, "");
		map[1][7] = new Space(true, "You come to an edge of a cliff and start to hear a cracking noise as the rocks fall under you."
				+ " Game over.", false, "");
		map[1][7].gameOver = true;
		map[1][8] = new Space(false, "", false, "");
		map[1][9] = new Space(false, "", false, "");
		
		map[2][0] = new Space(false, "", false, "");
		map[2][1] = new Space(true, "The path follows north and south.", false, "");
		map[2][2] = new Space(false, "", false, "");
		map[2][3] = new Space(false, "", false, "");
		map[2][4] = new Space(false, "", false, "");
		map[2][5] = new Space(false, "", false, "");
		map[2][6] = new Space(true, "The path follows north and south", false, "");
		map[2][7] = new Space(false, "", false, "");
		map[2][8] = new Space(true, "You come to a dead end to see a big dropoff and an unstable platform to the northeast.", false, "");
		map[2][9] = new Space(false, "", false, "");
		
		map[3][0] = new Space(false, "", false, "");
		map[3][1] = new Space(true, "You step into a junction that has paths to the north, south, and east.", false, "");
		map[3][2] = new Space(true, "The path follows east and west.", false, "");
		map[3][3] = new Space(true, "The path follows east and west.", true, "There is a branch above that you can jump and touch. "
				+ "Do you want to jump?");
		map[3][3].setActionResp("You grab on to it and do a backflip!", false);
		map[3][4] = new Space(true, "Looks like a dead end, you can only go back. ", true, 
				"You look up to see a trail lead to somewhere... Do you want to follow the trail?");
		map[3][5] = new Space(false, "", false, "");
		map[3][6] = new Space(true, "You come to a dead end and see a glitch in the matrix.", false, "");
		map[3][7] = new Space(false, "", false, "");
		map[3][8] = new Space(true, "There are paths to the north, south, east.", false, "");
		map[3][9] = new Space(true, "You come to a dead end, only way is to the west.", false, "");
		
		map[4][0] = new Space(false, "", false, "");
		map[4][1] = new Space(true, "The path follows north and south.", false, "");
		map[4][2] = new Space(false, "", false, "");
		map[4][3] = new Space(false, "", false, "");
		map[4][4] = new Space(true, "The path follows north and south.", false, "");
		map[4][5] = new Space(false, "", false, "");
		map[4][6] = new Space(false, "", false, "");
		map[4][7] = new Space(false, "", false, "");
		map[4][8] = new Space(true, "The path follows north and south.", false, "");
		map[4][9] = new Space(false, "", false, "");
		
		map[5][0] = new Space(false, "", false, "");
		map[5][1] = new Space(true, "The path follows north and south.", false, "");
		map[5][2] = new Space(false, "", false, "");
		map[5][3] = new Space(false, "", false, "");
		map[5][4] = new Space(true, "The path follows north and south", true, "You get a phone call from work. Do you answer?");
		map[5][4].setActionResp("You are distracted and a mountian lion sneaks up on you. Game over", true);
		map[5][5] = new Space(false, "", false, "");
		map[5][6] = new Space(false, "", false, "");
		map[5][7] = new Space(false, "", false, "");
		map[5][8] = new Space(true, "The path follows north and south.", false, "");
		map[5][9] = new Space(false, "", false, "");
		
		map[6][0] = new Space(true, "", false, "");
		map[6][1] = new Space(true, "The path follows north, south, and a bright light seen down a path to the west.", false, "");
		map[6][2] = new Space(false, "", false, "");
		map[6][3] = new Space(true, "You come to a corner that leads east or south. ", true, 
				"You see a creek to the west, do you go for a swim?");
		map[6][3].setActionResp("You start to swim when you are engulfed by a fresh water shark. Game over.", true);
		map[6][4] = new Space(true, "The path follows east and west with a heavily traveled trail to the north.", false, "");
		map[6][5] = new Space(true, "The path follows east and west with a faint trail to the south.", false, "");
		map[6][6] = new Space(true, "The path follows east and west", false, "");
		map[6][7] = new Space(true, "The path follows east and west", false, "");
		map[6][8] = new Space(true, "You come to a junction you can go north, south, east, and west.", false, "");
		map[6][9] = new Space(true, "You come to a playground and go on the slide. The only way is west.", false, "");
		
		map[7][0] = new Space(false, "", false, "");
		map[7][1] = new Space(true, "The path follows north and south.", false, "");
		map[7][2] = new Space(false, "", false, "");
		map[7][3] = new Space(true, "The path follows north and south.", false, "");
		map[7][4] = new Space(false, "", false, "");
		map[7][5] = new Space(true, "You slip and fall down tumbling down the side of a cliff. Game over.", false, "");
		map[7][5].gameOver = true;
		map[7][6] = new Space(false, "", false, "");
		map[7][7] = new Space(false, "", false, "");
		map[7][8] = new Space(true, "The path follows north and south.", false, "");
		map[7][9] = new Space(false, "", false, "");
		
		map[8][0] = new Space(true, "Congrats! You have found the legend of the Lemurian village. You are greeted by the villagers and "
				+ "live there for the rest of your life. Game over.", false, "");
		map[8][0].gameOver = true;
		map[8][1] = new Space(true, "The path follows west and north.", false, "");
		map[8][2] = new Space(false, "", false, "");
		map[8][3] = new Space(true, "Welcome to Mount Shasta! You are an explorer looking to adventure Mount Shasta. "
				+ "You must be weary of the many dangers of the mountian. Explore to find the legend of the Lemurian village, "
				+ "find the spirit of the above-world, and conquer the peak of Mount Shasta! Press the buttons below to navigate "
				+ "and interact with the world.", false, "");
		map[8][4] = new Space(false, "", false, "");
		map[8][5] = new Space(false, "", false, "");
		map[8][6] = new Space(false, "", false, "");
		map[8][7] = new Space(false, "", false, "");
		map[8][8] = new Space(true, "The path follows north and south.", false, "");
		map[8][9] = new Space(false, "", false, "");
		
		map[9][0] = new Space(false, "", false, "");
		map[9][1] = new Space(false, "", false, "");
		map[9][2] = new Space(false, "", false, "");
		map[9][3] = new Space(false, "", false, "");
		map[9][4] = new Space(false, "", false, "");
		map[9][5] = new Space(false, "", false, "");
		map[9][6] = new Space(false, "", false, "");
		map[9][7] = new Space(false, "", false, "");
		map[9][8] = new Space(true, "You come to a dead end to see a mysterious cave.", true, " Do you enter the cave?");
		map[9][8].setActionResp("Congrats! You have found the spirit of the above-world, below the world! Game over.", true);
		map[9][9] = new Space(false, "", false, "");
		

	}

	public void createGUI() {

		JFrame frame = new JFrame("The Mount Shasta Adventure");
		frame.setLayout(new BorderLayout());

		JLabel titleLabel = new JLabel("The Mount Shasta Adventure");
		titleLabel.setOpaque(true);
		titleLabel.setBackground(Color.GREEN);
		frame.add(titleLabel, BorderLayout.NORTH);

		JPanel mapPanel = new JPanel();
		mapPanel.setLayout(new GridLayout(MAPSIZEX, MAPSIZEY));

		for (int i = 0; i < MAPSIZEX; i++) {
			for (int r = 0; r < MAPSIZEY; r++) {
				map[i][r].setPreferredSize(SPACESIZE);
				map[i][r].setBorder(BorderFactory.createLineBorder(Color.black));
				map[i][r].setOpaque(true);
				if (!map[i][r].isAvaliable) {
					map[i][r].setBackground(Color.LIGHT_GRAY);
				}
				mapPanel.add(map[i][r]);				
			}
		}
		getPlayer().setBackground(Color.BLUE);

		frame.add(mapPanel, BorderLayout.CENTER);

		JPanel placeSpec = new JPanel();
		placeSpec.setLayout(new BorderLayout());
		
		descLabel = new JTextArea();
		descLabel.setText(getDescription());
		descLabel.setLineWrap(true);
		descLabel.setWrapStyleWord(true);		
		
		JPanel butPanel = new JPanel();
		butPanel.setOpaque(true);
		butPanel.setBackground(Color.GREEN);
		
		northButton = new JButton("North");
		northButton.setOpaque(true);
		northButton.setBackground(Color.LIGHT_GRAY);
		northButton.addActionListener(this);
		butPanel.add(northButton);
		
		southButton = new JButton("South");
		southButton.setOpaque(true);
		southButton.setBackground(Color.LIGHT_GRAY);
		southButton.addActionListener(this);
		butPanel.add(southButton);	
		
		westButton = new JButton("West");
		westButton.setOpaque(true);
		westButton.setBackground(Color.LIGHT_GRAY);
		westButton.addActionListener(this);
		butPanel.add(westButton);	
		
		eastButton = new JButton("East");
		eastButton.setOpaque(true);
		eastButton.setBackground(Color.LIGHT_GRAY);
		eastButton.addActionListener(this);
		butPanel.add(eastButton);
		
		interButton = new JButton("Action");
		interButton.setOpaque(true);
		interButton.setBackground(Color.LIGHT_GRAY);
		interButton.addActionListener(this);
		butPanel.add(interButton);	
		
		placeSpec.add(descLabel, BorderLayout.NORTH);
		placeSpec.add(butPanel, BorderLayout.CENTER);
		
		frame.add(placeSpec, BorderLayout.SOUTH);
		
		setButtons();
		
		frame.pack();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);

	}
	
	private String getDescription() {
		return getPlayer().description;
	}
	
	private void setDescription() {
		descLabel.setText(getDescription());
	}
	

	private void setButtons() {
		int playerX = playerPosition[1];
		int playerY = playerPosition[0];
		if (playerY - 1 >= 0 && map[playerY - 1][playerX].isAvaliable)
			northButton.setEnabled(true);
		else
			northButton.setEnabled(false);
		
		if (playerY + 1 < MAPSIZEY && map[playerY + 1][playerX].isAvaliable)
			southButton.setEnabled(true);
		else
			southButton.setEnabled(false);
		
		if (playerX + 1 < MAPSIZEX && map[playerY][playerX + 1].isAvaliable)
			eastButton.setEnabled(true);
		else
			eastButton.setEnabled(false);
		
		if (playerY - 1 >= 0 && map[playerY][playerX - 1].isAvaliable)
			westButton.setEnabled(true);
		else
			westButton.setEnabled(false);
		
		interButton.setEnabled(getPlayer().hasInteraction);
	}
	
	private Space getPlayer() {
		return map[playerPosition[0]][playerPosition[1]];
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object src = e.getSource();
		if (!gameOver) {
			if (src == northButton) {
				getPlayer().setBackground(Color.white);
				playerPosition[0] -= 1;
				getPlayer().setBackground(Color.blue);
			}
			else if (src == southButton) {
				getPlayer().setBackground(Color.white);
				playerPosition[0] += 1;
				getPlayer().setBackground(Color.blue);
			}	
			else if (src == westButton) {
				getPlayer().setBackground(Color.white);
				playerPosition[1] -= 1;
				getPlayer().setBackground(Color.blue);
			}
			else if (src == eastButton) {
				getPlayer().setBackground(Color.white);
				playerPosition[1] += 1;
				getPlayer().setBackground(Color.blue);
			}
			else if (src == interButton) {
				descLabel.setText(getPlayer().interactionDesc);
				if (getPlayer().gameOverResp) {
					gameOver = true;
					northButton.setText("Try again");
					northButton.setEnabled(true);
					southButton.setEnabled(false);
					eastButton.setEnabled(false);
					westButton.setEnabled(false);
					interButton.setEnabled(false);
				}
			}
			
			if (getPlayer().gameOver) {
				gameOver = true;
				northButton.setText("Try again");
				northButton.setEnabled(true);
				southButton.setEnabled(false);
				eastButton.setEnabled(false);
				westButton.setEnabled(false);
				interButton.setEnabled(false);
			}
			else {
				setButtons();
			}
			
			setDescription();
			
		}
		else if (gameOver) {
			if (src == northButton) {
				northButton.setText("North");
				southButton.setText("South");
				getPlayer().setBackground(Color.white);
				playerPosition[0] = 8;
				playerPosition[1] = 3;
				getPlayer().setBackground(Color.blue);
				setButtons();
				setDescription();
				gameOver = false;
			}
		}

	}

}
