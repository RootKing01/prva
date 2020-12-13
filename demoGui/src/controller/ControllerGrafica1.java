package controller;

import demoGui.*;

public class ControllerGrafica1 {
	
	public LoginFrame paginaLogin;
	public Home paginaHome;
	
	
	
	public ControllerGrafica1() 
	{
		
		paginaLogin = new LoginFrame(this);
		paginaLogin.setVisible(false);
		
		paginaHome = new Home(this);
		paginaHome.setVisible(false);

	}
	
	public static void main(String[] args) 
	{
		ControllerGrafica1 controller = new ControllerGrafica1();
		controller.paginaLogin.setVisible(true);
		
	}

	
	
	
	public void controlloCredenziali(String email, String password) 
	{
		System.out.println("ecco "+email+ " "+ password);
		if(controlloPassword() && controlloEmail()) 
		{
			
			paginaLogin.setVisible(false);
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
