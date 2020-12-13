package controller;

import demoGui.LoginFrame;

public class ControllerGrafic1 {
	
	public LoginFrame paginaLG;
	
	
	public ControllerGrafic1() {
		
		paginaLG = new LoginFrame(this);
		paginaLG.setVisible(true);
	}
	
	public static void main(String[] args) {
		
	ControllerGrafic1 controller = new ControllerGrafic1();
		
		
	}

	public void controlloCredenziali(String email, String password) 
	{
		
		System.out.println("ecco "+email+ " "+ password);
		if(controlloPassword() && controlloEmail()) 
		{
			
			paginaLG.setVisible(false);
		}
		
	}

	private boolean controlloEmail() 
	{
		// TODO Auto-generated method stub
		return true;
	}

	private boolean controlloPassword() 
	{
		// TODO Auto-generated method stub
		return true;
	}
}
