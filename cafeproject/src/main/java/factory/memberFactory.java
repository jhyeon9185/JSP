package factory;

import java.awt.Desktop.Action;


public class memberFactory {
	
	private static memberFactory instance  = new memberFactory();
	
	private memberFactory() {}
	
	public static memberFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action  = null;
		
		System.out.println("memberfactory : " + command);
		
		//조건문
		if(command.equals("")) {
			action =  new ();
			
		}// end if
		
	}// end getAction
}