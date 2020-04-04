
import javax.swing.JLabel;

public class Space extends JLabel{
	
	protected boolean isAvaliable;
	protected String description;
	protected boolean hasInteraction;
	protected String interactionDesc;
	protected String actionResp;
	protected boolean gameOver;
	protected boolean gameOverResp;
	
	public Space(boolean isAvaliable, String description, boolean hasInteraction, String interactionDesc) {
		this.isAvaliable = isAvaliable;
		this.description = description;
		this.hasInteraction = hasInteraction;
		this.interactionDesc = interactionDesc;
		gameOver = false;
	}
	
	protected void setActionResp(String resp, boolean gameOver) {
		actionResp = resp;
		gameOverResp = gameOver;
	}
	
}
